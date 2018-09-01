package edu.ttu.krlab.alm;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;

import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.parser.ALMLexer;
import edu.ttu.krlab.alm.parser.ALMModuleListener;
import edu.ttu.krlab.alm.parser.ALMParser;
import edu.ttu.krlab.alm.parser.ALMParser.Alm_fileContext;
import edu.ttu.krlab.alm.parser.ALMParser.ModuleContext;
import edu.ttu.krlab.alm.parser.ALMParser.Module_nameContext;
import edu.ttu.krlab.alm.parser.ALMSyntaxErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;

public class ALMModuleManager {

    private boolean resolutionFailure = false;
    private final ALMCompilerSettings s;
    private final ErrorReport er;
    private final Set<LibraryImport> imports = new HashSet<>();
    private final Set<LibraryImport> unresolvedImports = new HashSet<>();
    private final Map<LibraryReference, Alm_fileContext> resolvedImports = new HashMap<>();
    private final Set<ModuleReference> unresolvedModules = new HashSet<>();
    private final Map<ModuleReference, ModuleContext> resolvedModules = new HashMap<>();
    private final Map<ModuleContext, ModuleReference> moduleContextReferences = new HashMap<>();
    private final Map<ModuleReference, Set<ModuleReference>> moduleDependencies = new HashMap<>();
    private final Set<ModuleReference> leafModules = new HashSet<>();
    private final Set<ModuleReference> interiorModules = new HashSet<>();
    private final Map<ModuleContext, SymbolTable> modSTs = new HashMap<>();
    private final Map<String, Set<LibraryImport>> localizations = new HashMap<>();

    public ALMModuleManager(ALMCompilerSettings s, ErrorReport er) {
        this.s = s;
        this.er = er;
    }

    public void recordModuleDependency(String theoryName, String moduleName, String dependencyTheoryName,
            String dependencyModuleName, Module_nameContext nameContext) {
        ModuleReference moduleReference = new ModuleReference(theoryName, moduleName, nameContext);
        if (dependencyTheoryName == null) {
            dependencyTheoryName = theoryName;
        }
        ModuleReference dependencyModuleReference = new ModuleReference(dependencyTheoryName, dependencyModuleName, nameContext);

        Set<ModuleReference> dependencies = moduleDependencies.get(moduleReference);
        if (dependencies == null) {
            dependencies = new HashSet<>();
            moduleDependencies.put(moduleReference, dependencies);
        }
        dependencies.add(dependencyModuleReference);

        //populate unresolvedModules if these module references are not resolved. 
        if (!resolvedModules.containsKey(moduleReference)) {
            unresolvedModules.add(moduleReference);
        }
        if (!resolvedModules.containsKey(dependencyModuleReference)) {
            unresolvedModules.add(dependencyModuleReference);
        }

        //update leaf/interior status. 
        leafModules.remove(dependencyModuleReference);
        interiorModules.add(dependencyModuleReference);
        if (!interiorModules.contains(moduleReference)) {
            leafModules.add(moduleReference);
        }
    }

    public Set<ModuleContext> getModuleDependencies(ModuleContext modCtx) {
        ModuleReference moduleReference = moduleContextReferences.get(modCtx);
        Set<ModuleReference> dependencyReferences = getModuleDependencies(moduleReference);
        Set<ModuleContext> result = new HashSet<>();
        for (ModuleReference modRef : dependencyReferences) {
            ModuleContext dmCtx = resolvedModules.get(modRef);
            if (dmCtx != null) {
                result.add(resolvedModules.get(modRef));
            }
        }
        return result;
    }

    private Set<ModuleReference> getModuleDependencies(ModuleReference moduleReference) {
        Set<ModuleReference> dependencies = moduleDependencies.get(moduleReference);
        if (dependencies == null) {
            dependencies = new HashSet<>();
            moduleDependencies.put(moduleReference, dependencies);
        }
        return dependencies;
    }

    public void recordImport(String importingTheory, String libraryName, String theoryName, String moduleName, ParserRuleContext ctx) {
        if (moduleName == null) {
            moduleName = ModuleReference.ALL_MODULES;
        }
        LibraryImport libraryImport = new LibraryImport(importingTheory, libraryName, theoryName, moduleName, ctx);
        if (imports.contains(libraryImport)) {
            return; // library Reference is already scheduled to be imported.  
        }
        imports.add(libraryImport);
        if (!resolvedImports.containsKey(libraryImport.getLibraryReference())) {
            unresolvedImports.add(libraryImport);
        }
        Set<LibraryImport> libImportsForTheory = localizations.get(importingTheory);
        if (libImportsForTheory == null) {
            libImportsForTheory = new HashSet<>();
            localizations.put(importingTheory, libImportsForTheory);
        }
        libImportsForTheory.add(libraryImport);
    }

    public void recordImport(String libraryName, String theoryName, ParserRuleContext ctx) {
        recordImport(null, libraryName, theoryName, ModuleReference.ALL_MODULES, ctx);
    }

    /**
     * Imports all referenced modules and theories from import statements and resolves all unresolved modules if
     * possible. The returned boolean indicates if any modules remain unresolved.
     *
     * @return
     */
    public boolean resolveModules() {
        if (resolutionFailure) {
            return resolutionFailure;
        }

        //repeat resolution of imports until there are no more imports to resolve. 
        while (unresolvedImports.size() > 0 && !resolutionFailure) {
            Set<LibraryImport> unresolvedLibraryImports = new HashSet<>(unresolvedImports);
            //iterate through the current batch of import statements.  (This effectively imports libraries by level.)

            while (unresolvedLibraryImports.size() > 0 && !resolutionFailure) {
                LibraryImport libraryImport = unresolvedLibraryImports.iterator().next();
                //check to see if this particular libraryReference has already been handled.  
                if (resolvedImports.containsKey(libraryImport.getLibraryReference())) {
                    unresolvedLibraryImports.remove(libraryImport);
                    unresolvedImports.remove(libraryImport);
                    continue;
                }
                //pick apart the library reference into its component parts.  
                String libraryName = libraryImport.getImportedLibrary();
                String theoryName = libraryImport.getImportedTheory();
                String moduleName = libraryImport.getImportedModule();

                //create reference to the whole theory in the library. 
                LibraryReference libraryReference = new LibraryReference(libraryName, theoryName, ModuleReference.ALL_MODULES);
                if (resolvedImports.containsKey(libraryReference)) {
                    unresolvedLibraryImports.remove(libraryImport);
                    unresolvedImports.remove(libraryImport);
                    continue;
                }

                //get any existing import for the theory. 
                Alm_fileContext existing = resolvedImports.get(libraryReference);
                if (existing == null) {
                    //import the theory from the library since it doesn't exist.
                    //get the filename of the system description containin the theory. 
                    String libraryTheoryLocation = s.getLibraryEntryFileName(libraryName, theoryName);
                    if (libraryTheoryLocation == null) {
                        //import cannot be resolved given the system settings. 
                        resolutionFailure = true;
                        break;
                    }
                    CharStream libSD = null;
                    try {
                        libSD = CharStreams.fromFileName(libraryTheoryLocation);
                    } catch (IOException e) {
                        ALMCompiler.IMPLEMENTATION_FAILURE("Creating Char Stream",
                                "Failure Not Handled Gracefully yet.");
                    }
                    if (libSD != null) {
                        ALMLexer libLexer = new ALMLexer(libSD);
                        TokenStream libTS = new BufferedTokenStream(libLexer);
                        ALMParser libParser = new ALMParser(libTS);
                        libParser.addErrorListener(new ALMSyntaxErrorListener(er));
                        libParser.addParseListener(new ALMModuleListener(this));
                        //pare the theory
                        existing = libParser.alm_file();
                        //record the parsed theory.
                        resolvedImports.put(libraryReference, existing);
                    }
                }

                //check that the module reference from the library is now resolvable.
                if (moduleName != null && !moduleName.equals("*") && !moduleName.equals("null")) {
                    ModuleContext mc = getModule(theoryName, moduleName);
                    if (mc != null) {
                        //bind the import of the module to the import of the theory.
                        resolvedImports.put(libraryReference, existing);
                        //remove the import from the unresolved set. 
                        unresolvedImports.remove(libraryImport);
                    } else {
                        resolutionFailure = true;
                        break;
                    }
                }
            }
        }

        //Try to resolve modules through localizing import of external theory elements
        HashSet<ModuleReference> unresolvedMods = new HashSet<>(unresolvedModules);
        for (ModuleReference unresolved : unresolvedMods) {
            String theory = unresolved.getTheory();
            String module = unresolved.getModule();
            Set<LibraryImport> libraryImports = localizations.get(theory);
            LibraryImport resolved = null;
            for (LibraryImport libImport : libraryImports) {
                String importedModule = libImport.getImportedModule();
                if (module.compareTo(importedModule) == 0 || importedModule == ModuleReference.ALL_MODULES) {
                    //check of there is a module reference in the imported library with a compatible module name. 
                    ModuleReference matchModRef = new ModuleReference(libImport.getImportedTheory(), module, null);
                    if (resolvedModules.containsKey(matchModRef)) {
                        if (resolved != null) {
                            er.newSemanticError(SemanticError.IMP001)
                                    .add(unresolved.getDependencyStatement())
                                    .add(resolved.getImportStatement())
                                    .add(libImport.getImportStatement());
                            break;
                        }
                        //resolve the unresolved reference with this reference. 
                        resolvedModules.put(unresolved, resolvedModules.get(matchModRef));
                        unresolvedModules.remove(unresolved);
                        resolved = libImport;
                    }
                }
            }

        }

        //The act of importing all library imports should have satisfied all unresolved module references.   
        //any remaining unresolved module references results in failure.  
        if (unresolvedModules.size() > 0) {
            resolutionFailure = true;
        }
        return resolutionFailure;
    }

    public ModuleContext getModule(String theoryName, String moduleName) {
        ModuleReference moduleReference = new ModuleReference(theoryName, moduleName, null);
        return resolvedModules.get(moduleReference);
    }

    /**
     * Binds the parsed ModuleContxt to the theoryName.moduleName
     *
     * @param theoryName The name of the theory for the parsed module.
     * @param moduleName The name of the module in the theory for the parsed module.
     * @param modCtx The parsed module.
     * @throws DuplicateModuleException if the name is already bound to a difference parsed module.
     */
    public void setModule(String theoryName, String moduleName, ModuleContext modCtx) throws DuplicateModuleException {
        ModuleReference moduleReference = new ModuleReference(theoryName, moduleName, null);
        ModuleContext existing = resolvedModules.get(moduleReference);
        if (existing != null) {
            throw new DuplicateModuleException(existing);
        }
        resolvedModules.put(moduleReference, modCtx);
        moduleContextReferences.put(modCtx, moduleReference);
        unresolvedModules.remove(moduleReference);

        //record leaf status if not already in interior
        if (!interiorModules.contains(moduleReference)) {
            leafModules.add(moduleReference);
        }

    }

    public Set<ModuleContext> getLeafModules() {
        Set<ModuleContext> leaves = new HashSet<>();
        for (ModuleReference moduleReference : leafModules) {
            leaves.add(resolvedModules.get(moduleReference));
        }
        return leaves;
    }

    public void setSymbolTableForModule(ModuleContext mc, SymbolTable newST) {
        modSTs.put(mc, newST);
    }

    public SymbolTable getSymbolTableForModule(ModuleContext mc) {
        return modSTs.get(mc);
    }

    private static String getLibraryName(String libraryReference) {
        int i = libraryReference.indexOf("::");
        if (i < 0) {
            return null;
        }
        return libraryReference.substring(0, i);

    }

    private static String getLibraryTheoryName(String libraryReference) {
        int i = libraryReference.indexOf("::");
        int j = libraryReference.indexOf(":", i + 2);
        if (i < 0) {
            return null;
        }
        if (j < 0) {
            return libraryReference.substring(i + 2);
        }
        return libraryReference.substring(i + 2, j);
    }

    private static String getLibraryModuleName(String libraryReference) {
        int i = libraryReference.indexOf("::");
        int j = libraryReference.indexOf(":", i + 2);
        if (j < 0) {
            return null;
        }
        return libraryReference.substring(j + 1);
    }

    private static String getTheoryName(String moduleReference) {
        int i = moduleReference.indexOf(':');
        if (i < 0) {
            return null;
        }
        return moduleReference.substring(0, i);
    }

    private static String getModuleName(String moduleReference) {
        int i = moduleReference.indexOf(':');
        if (i < 0) {
            return null;
        }
        return moduleReference.substring(i + 1);
    }

    public String getModuleContextReference(ModuleContext mc) {
        ModuleReference modRef = moduleContextReferences.get(mc);
        return modRef.getTheory() + ":" + modRef.getModule();

    }
}
