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
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.parser.ALMLexer;
import edu.ttu.krlab.alm.parser.ALMModuleListener;
import edu.ttu.krlab.alm.parser.ALMParser;
import edu.ttu.krlab.alm.parser.ALMParser.ModuleContext;
import edu.ttu.krlab.alm.parser.ALMParser.System_descriptionContext;
import edu.ttu.krlab.alm.parser.ALMSyntaxErrorListener;

public class ALMModuleManager {

    private boolean resolutionFailure = false;
    private ALMCompilerSettings s;
    private ErrorReport er;
    private Map<String, ModuleContext> imports = new HashMap<>();
    private Set<String> unresolvedImports = new HashSet<>();
    private Map<String, System_descriptionContext> resolvedImports = new HashMap<>();
    private Set<String> unresolvedModules = new HashSet<>();
    private Map<String, ModuleContext> resolvedModules = new HashMap<>();
    private Map<ModuleContext, String> moduleContextReferences = new HashMap<>();
    private Map<String, Set<String>> moduleDependencies = new HashMap<String, Set<String>>();
    private Set<String> leafModules = new HashSet<>();
    private Set<String> interiorModules = new HashSet<>();
    private Map<ModuleContext, SymbolTable> modSTs = new HashMap<>();

    public ALMModuleManager(ALMCompilerSettings s, ErrorReport er) {
        this.s = s;
        this.er = er;
    }

    public void recordModuleDependency(String theoryName, String moduleName, String dependencyTheoryName,
            String dependencyModuleName) {
        String moduleReference = createModuleReference(theoryName, moduleName);
        if (dependencyTheoryName == null)
            dependencyTheoryName = theoryName;
        String dependencyModuleReference = createModuleReference(dependencyTheoryName, dependencyModuleName);

        Set<String> dependencies = moduleDependencies.get(moduleReference);
        if (dependencies == null) {
            dependencies = new HashSet<String>();
            moduleDependencies.put(moduleReference, dependencies);
        }
        dependencies.add(dependencyModuleReference);

        //populate unresolvedModules if these module references are not resolved. 
        if (!resolvedModules.containsKey(moduleReference))
            unresolvedModules.add(moduleReference);
        if (!resolvedModules.containsKey(dependencyModuleReference))
            unresolvedModules.add(dependencyModuleReference);

        //update leaf/interior status. 
        leafModules.remove(dependencyModuleReference);
        interiorModules.add(dependencyModuleReference);
        if (!interiorModules.contains(moduleReference))
            leafModules.add(moduleReference);
    }

    public Set<ModuleContext> getModuleDependencies(ModuleContext modCtx) {
        String moduleReference = moduleContextReferences.get(modCtx);
        Set<String> dependencyReferences = getModuleDependencies(moduleReference);
        Set<ModuleContext> result = new HashSet<>();
        for (String modRef : dependencyReferences) {
            ModuleContext dmCtx = resolvedModules.get(modRef);
            if (dmCtx != null) {
                result.add(resolvedModules.get(modRef));
            }
        }
        return result;
    }

    private Set<String> getModuleDependencies(String moduleReference) {
        Set<String> dependencies = moduleDependencies.get(moduleReference);
        if (dependencies == null) {
            dependencies = new HashSet<>();
            moduleDependencies.put(moduleReference, dependencies);
        }
        return dependencies;
    }

    public void recordImport(String libraryName, String theoryName, String moduleName, ModuleContext modCtx) {
        String libraryReference = createLibraryReference(libraryName, theoryName, moduleName);
        if (imports.containsKey(libraryReference))
            return; // library Reference is already scheduled to be imported.  
        imports.put(libraryReference, modCtx);
        if (!resolvedImports.containsKey(libraryReference))
            unresolvedImports.add(libraryReference);
    }

    public void recordImport(String libraryName, String theoryName) {
        recordImport(libraryName, theoryName, null, null);
    }

    /**
     * Imports all referenced modules and theories from import statements and resolves all unresolved modules if
     * possible. The returned boolean indicates if any modules remain unresolved.
     */
    public boolean resolveModules() {
        if (resolutionFailure)
            return resolutionFailure;

        //repeat resolution of imports until there are no more imports to resolve. 
        while (unresolvedImports.size() > 0 && !resolutionFailure) {
            Set<String> unresolvedLibraryReferences = new HashSet<>(unresolvedImports);
            //iterate through the current batch of import statements.  (This effectively imports libraries by level.)

            while (unresolvedLibraryReferences.size() > 0 && !resolutionFailure) {
                String libraryReference = unresolvedLibraryReferences.iterator().next();
                //check to see if this particular libraryReference has already been handled.  
                if (resolvedImports.containsKey(libraryReference)) {
                    unresolvedLibraryReferences.remove(libraryReference);
                    unresolvedImports.remove(libraryReference);
                    continue;
                }
                //pick apart the library reference into its component parts.  
                String libraryName = getLibraryName(libraryReference);
                String theoryName = getLibraryTheoryName(libraryReference);
                String moduleName = getLibraryModuleName(libraryReference);

                //create reference to the whole theory in the library. 
                String theoryReference = createLibraryReference(libraryName, theoryName, "*");
                if (resolvedImports.containsKey(theoryReference)) {
                    unresolvedLibraryReferences.remove(libraryReference);
                    unresolvedImports.remove(libraryReference);
                    continue;
                }

                //get any existing import for the theory. 
                System_descriptionContext existing = resolvedImports.get(theoryReference);
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
                        existing = libParser.system_description();
                        //record the parsed theory.
                        resolvedImports.put(theoryReference, existing);
                    }
                }

                //check that the module reference from the library is now resolvable.
                if (moduleName != null && !moduleName.equals("*") && !moduleName.equals("null")) {
                    ModuleContext mc = getModule(theoryName, moduleName);
                    if (mc != null) {
                        //bind the import of the module to the import of the theory.
                        resolvedImports.put(libraryReference, existing);
                        //remove the import from the unresolved set. 
                        unresolvedImports.remove(libraryReference);
                    } else {
                        resolutionFailure = true;
                        break;
                    }
                }
            }
        }

        //The act of importing all library imports should have satisfied all unresolved module references.   
        //any remaining unresolved module references results in failure.  
        if (unresolvedModules.size() > 0)
            resolutionFailure = true;
        return resolutionFailure;
    }

    public ModuleContext getModule(String theoryName, String moduleName) {
        String moduleReference = createModuleReference(theoryName, moduleName);
        return resolvedModules.get(moduleReference);
    }

    /**
     * Binds the parsed ModuleContxt to the theoryName.moduleName
     * 
     * @param theoryName
     *            The name of the theory for the parsed module.
     * @param moduleName
     *            The name of the module in the theory for the parsed module.
     * @param modCtx
     *            The parsed module.
     * @throws DuplicateModuleException
     *             if the name is already bound to a difference parsed module.
     */
    public void setModule(String theoryName, String moduleName, ModuleContext modCtx) throws DuplicateModuleException {
        String moduleReference = createModuleReference(theoryName, moduleName);
        ModuleContext existing = resolvedModules.get(moduleReference);
        if (existing != null)
            throw new DuplicateModuleException(existing);
        resolvedModules.put(moduleReference, modCtx);
        moduleContextReferences.put(modCtx, moduleReference);
        unresolvedModules.remove(moduleReference);

        //record leaf status if not already in interior
        if (!interiorModules.contains(moduleReference))
            leafModules.add(moduleReference);

    }

    public Set<ModuleContext> getLeafModules() {
        Set<ModuleContext> leaves = new HashSet<>();
        for (String moduleReference : leafModules)
            leaves.add(resolvedModules.get(moduleReference));
        return leaves;
    }

    public void setSymbolTableForModule(ModuleContext mc, SymbolTable newST) {
        modSTs.put(mc, newST);
    }

    public SymbolTable getSymbolTableForModule(ModuleContext mc) {
        return modSTs.get(mc);
    }

    private static String createLibraryReference(String libraryName, String TheoryName, String moduleName) {
        return libraryName + "::" + TheoryName + ":" + moduleName;
    }

    private static String getLibraryName(String libraryReference) {
        int i = libraryReference.indexOf("::");
        if (i < 0)
            return null;
        return libraryReference.substring(0, i);

    }

    private static String getLibraryTheoryName(String libraryReference) {
        int i = libraryReference.indexOf("::");
        int j = libraryReference.indexOf(":", i + 2);
        if (i < 0)
            return null;
        if (j < 0)
            return libraryReference.substring(i + 2);
        return libraryReference.substring(i + 2, j);
    }

    private static String getLibraryModuleName(String libraryReference) {
        int i = libraryReference.indexOf("::");
        int j = libraryReference.indexOf(":", i + 2);
        if (j < 0)
            return null;
        return libraryReference.substring(j + 1);
    }

    private static String createModuleReference(String theoryName, String moduleName) {
        return theoryName + ":" + moduleName;
    }

    private static String getTheoryName(String moduleReference) {
        int i = moduleReference.indexOf(':');
        if (i < 0)
            return null;
        return moduleReference.substring(0, i);
    }

    private static String getModuleName(String moduleReference) {
        int i = moduleReference.indexOf(':');
        if (i < 0)
            return null;
        return moduleReference.substring(i + 1);
    }

    public String getModuleContextReference(ModuleContext mc) {
        return moduleContextReferences.get(mc);
    }
}
