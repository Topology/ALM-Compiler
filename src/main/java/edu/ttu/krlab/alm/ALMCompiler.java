package edu.ttu.krlab.alm;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.ttu.krlab.alm.answerset.AnswerSets;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfLiteral;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfProgram;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfRule;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.datastruct.sig.ConstantEntry;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCProgram;
import edu.ttu.krlab.alm.parser.ALMBaseListener;
import edu.ttu.krlab.alm.parser.ALMLexer;
import edu.ttu.krlab.alm.parser.ALMModuleListener;
import edu.ttu.krlab.alm.parser.ALMParser;
import edu.ttu.krlab.alm.parser.ALMParser.ModuleContext;
import edu.ttu.krlab.alm.parser.ALMParser.Solver_modeContext;
import edu.ttu.krlab.alm.parser.ALMParser.StructureContext;
import edu.ttu.krlab.alm.parser.ALMParser.System_descriptionContext;
import edu.ttu.krlab.alm.parser.ALMSyntaxErrorListener;
import edu.ttu.krlab.answerset.parser.AnswerSet;
import edu.ttu.krlab.answerset.parser.SPARCWrapper;

public class ALMCompiler {

    private static ErrorReport er = null;
    private static ALMCompilerSettings s = null;

    public static final String VERSION = "0.1.0"; // Major = huge features, Minor = smaller adjustments, Release Build =
                                                  // bugfixes
    private static final boolean DEBUG_VERSION = true;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.err.println("ALM Translator Version: " + VERSION);

        s = new ALMCompilerSettings();
        s.processCommandlineArgs(args);

        SymbolTable st = new SymbolTable("Whole Theory");
        er = new ErrorReport();
        ASPfProgram aspf = new ASPfProgram();
        SPARCProgram pm = new SPARCProgram();
        pm.addComment("Pre Model Program");
        List<AnswerSet> pm_as = new ArrayList<AnswerSet>();
        SPARCProgram tm = new SPARCProgram();
        List<AnswerSet> tm_as = new ArrayList<AnswerSet>();
        tm.addComment("Final Program For Transition Diagram");

        ALMCompiler.Compile(s, st, er, aspf, pm, pm_as, tm, tm_as);
            if (er.hasErrors())
                ALMCompiler.exitWithErrors(er, s);
    }
    
    public static final void Compile(ALMCompilerSettings s, SymbolTable st, ErrorReport er, ASPfProgram aspf,
            SPARCProgram pm, List<AnswerSet> pm_as, SPARCProgram tm, List<AnswerSet> tm_as) {
        
        //Render input system description into ANTLR Syntax Parse Tree. 
        try {
            //Setup Input to Parser. 
            CharStream sysDescCS = CharStreams.fromFileName(s.getSystemDescriptionFileName());
            ALMLexer sdLexer = new ALMLexer(sysDescCS);
            TokenStream sdTS = new BufferedTokenStream(sdLexer);
            ALMParser sdParser = new ALMParser(sdTS);
            ALMModuleManager amm = new ALMModuleManager(s, er);
            sdParser.removeErrorListeners();
            sdParser.addErrorListener(new ALMSyntaxErrorListener(er));
            sdParser.addParseListener(new ALMModuleListener(amm));

            //Create the parse tree for the top-level system description. 
            //Walk the parse tree, real time, using the ALMModuleListener, populating amm. 
            System_descriptionContext sysDesc = sdParser.system_description();

            //turn module references into parse trees for the modules.
            //Loads multi-modules into memory. 
            amm.resolveModules();

            //Creates symbol tables for each module then flattens them into st
            //Populates axioms of each module into aspf. 
            processTheory(s, amm, st, aspf, er);

            StructureContext structure = sysDesc.structure();
            if (structure != null) {

                //populate aspf with the rules derived from the structure.
                //adds constant declarations to st.  
                processStructure(s, structure, st, aspf, er);
                Solver_modeContext mode = sysDesc.solver_mode();
                if (mode != null) {
                    //Adds rules to define and solve problems such as histories for temporal projections
                    processSolverMode(s, mode, st, aspf, er);
                }
                // Call The Translation Function (Where the magic happens)
                // Produces the final SPARC program 'tm' and if solving a problem, the final answer set(s) 'as'. 
                ALMCompiler.Translate(s, st, er, aspf, pm, pm_as, tm, tm_as);
            } 
        } catch (FileNotFoundException e) {
            System.err
                    .println("Could not locate input system description in file: " + s.getSystemDescriptionFileName());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Could Not Complete Translation Due To Java IO Exception:");
            e.printStackTrace();
        }
    }

    
    
    
    private static void processSolverMode(ALMCompilerSettings s, Solver_modeContext mode, SymbolTable st,
            ASPfProgram aspf, ErrorReport er) {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ALMBaseListener(s, st, aspf, er), mode);
    }

    private static void processStructure(ALMCompilerSettings s, StructureContext structure, SymbolTable st,
            ASPfProgram aspf, ErrorReport er) {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ALMBaseListener(s, st, aspf, er), structure);
    }

    private static void processTheory(ALMCompilerSettings s, ALMModuleManager amm, SymbolTable st, ASPfProgram aspf,
            ErrorReport er) {
        Set<ModuleContext> start = new HashSet<>();
        Set<ModuleContext> finished = new HashSet<>();
        amm.resolveModules();
        for (ModuleContext mc : amm.getLeafModules()) {
            st.addDependency(processModuleToSymbolTable(s, mc, amm, aspf, er, start, finished));
        }
        st.flatten();
    }

    private static SymbolTable processModuleToSymbolTable(ALMCompilerSettings s, ModuleContext mc, ALMModuleManager amm,
            ASPfProgram aspf, ErrorReport er, Set<ModuleContext> start, Set<ModuleContext> finished) {
        if (start.contains(mc))
            ALMCompiler.IMPLEMENTATION_FAILURE("Processing Modules To Symbol Tables",
                    "Circular Module Dependency encountered, no semantic error yet.");
        if (finished.contains(mc))
            return amm.getSymbolTableForModule(mc);
        start.add(mc);
        //process module dependencies
        SymbolTable newST = new SymbolTable(amm.getModuleContextReference(mc));
        amm.setSymbolTableForModule(mc, newST);
        Set<ModuleContext> dependencies = amm.getModuleDependencies(mc);
        for (ModuleContext d : dependencies) {
            SymbolTable dST = amm.getSymbolTableForModule(d);
            if (dST == null) {
                dST = processModuleToSymbolTable(s, d, amm, aspf, er, start, finished);
            }
            newST.addDependency(dST);
        }

        if (er.hasErrors()) {
            ALMCompiler.exitWithErrors(er, s);
        }
        ALMBaseListener mcListener = new ALMBaseListener(s, newST, aspf, er);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(mcListener, mc);

        start.remove(mc);
        finished.add(mc);
        return newST;
    }

    public static void exitWithErrors(ErrorReport er, ALMCompilerSettings s) {
        try {
            er.writeTo(s.getErrorDestination());
            s.closeErrorDestination();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.exit(-1);
    }

    public static final void Translate(ALMCompilerSettings s, SymbolTable st, ErrorReport er, ASPfProgram aspf,
            SPARCProgram pm, List<AnswerSet> pm_as, SPARCProgram tm, List<AnswerSet> tm_as) throws IOException {

        PerformConstantDefinitionSubstitution(st, aspf, er);

        st.writeTo(s.getSymbolTableDestination());
        s.closeSymbolTableDestination();
        aspf.writeTo(s.getIntermediateASPfDestination());
        s.closeIntermediateASPfDestination();

        if (er.hasErrors())
            ALMCompiler.exitWithErrors(er, s);

        ALMTranslator.ConstructPreModelProgram(pm, st, aspf);
        pm.writeTo(s.getPreModelDestination());
        s.closePreModelDestination();
        pm_as = GetAnswerSet(pm, s);
        AnswerSets.writeTo(s.getIntermediateAnswerSetDestination(), pm_as);
        s.closePremodelAnswerSetsDestination();
        if (pm_as.size() == 1) {
            ALMTranslator.ConstructFinalProgram(tm, pm_as.get(0), pm, st, aspf, s, er);
            tm.writeTo(s.getTransitionModelDestination());
            s.closeTransitionModelDestination();
            tm_as.addAll(GetAnswerSet(tm, s));
            AnswerSets.writeTo(s.getFinalAnswerSetDestination(), tm_as);
            s.closeFinalAnswerSetsDestination();
        } else {
            er.newSemanticError(SemanticError.ANS001);
        }
    }

    private static List<AnswerSet> GetAnswerSet(SPARCProgram pm, ALMCompilerSettings s) throws IOException {
        StringWriter sparcwriter = new StringWriter();
        BufferedWriter out = new BufferedWriter(sparcwriter);
        pm.writeTo(out);
        String sparcProgram = sparcwriter.toString();
        // String sparcProgram, String pathToSPARCJar, String pathToJava, String
        // PathToASPSolver, String whichSolver
        return SPARCWrapper.solve(sparcProgram, s.getSPARCLocation(), s.getJavaLocation(), s.getSolverLocation(),
                s.getSolverType());

    }

    public static void IMPLEMENTATION_FAILURE(String phase, String error) {
        try {
            er.writeTo(s.getErrorDestination());
            s.closeErrorDestination();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ALMCompilerPermanentFailure(phase, error);
    }

    private static void PerformConstantDefinitionSubstitution(SymbolTable st, ASPfProgram aspf, ErrorReport er) {

        Map<ALMTerm, ConstantEntry> definedConstants = st.getDefinedConstants();
        //This version of ALM only supports simple ground constant definitions.  
        //When we support complex constant definitions we will need to typecheck their structure here. 
        //This cannot be done at the time of constant definition since the constant may contain structure declared 
        //instances as arguments.  Typechecking must happen after processing the complete structure.  

        //TYPE CHECK COMPLEX CONSTANT DEFINITIONS HERE. 

        //Replace simple constants in the ASPf Program
        for (Map.Entry<ALMTerm, ConstantEntry> entry : definedConstants.entrySet()) {
            ALMTerm constInstance = entry.getKey();
            ConstantEntry ce = entry.getValue();
            ALMTerm definition = ce.getConstantDefinition(constInstance);
            for (List<ASPfRule> section : aspf.getSections()) {
                for (ASPfRule rule : section) {
                    ASPfLiteral head = rule.getHead();
                    if (head != null) {
                        head.toALMTerm().replaceTerm(constInstance, definition);
                    }
                    List<ASPfLiteral> body = rule.getBody();
                    if (body != null && body.size() > 0) {
                        for (ASPfLiteral lit : body) {
                            lit.toALMTerm().replaceTerm(constInstance, definition);
                        }
                    }
                }
            }
        }
    }

}
