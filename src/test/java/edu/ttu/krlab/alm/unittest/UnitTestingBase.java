package edu.ttu.krlab.alm.unittest;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.ALMCompilerSettings;
import edu.ttu.krlab.alm.datastruct.aspf.ASPfProgram;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.sparc.SPARCProgram;
import edu.ttu.krlab.answerset.parser.AnswerSet;
import edu.ttu.krlab.answerset.parser.DLVAnswerSetParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class UnitTestingBase {

    protected String ls = System.getProperty("line.separator");
    protected ALMCompilerSettings s;
    protected SymbolTable st;
    protected ErrorReport er;
    protected ASPfProgram aspf;
    protected SPARCProgram pm;
    protected SPARCProgram tm;
    protected List<AnswerSet> pm_as;
    protected List<AnswerSet> tm_as;
    protected boolean testProgramsPassed = true;

    private String unit_test_folder = "";

    public UnitTestingBase() {
        this.s = new ALMCompilerSettings();
        String sparc_loc = System.getProperty("SPARC_JAR");
        if (sparc_loc != null && !sparc_loc.trim().isEmpty()) {
            sparc_loc = (new File(sparc_loc)).getAbsolutePath();
            this.s.setSPARCLocation(sparc_loc);
        } else {
            System.err.println("SPARC_JAR location not set.");
        }
        String solver_loc = System.getProperty("ASP_SOLVER_DIRECTORY");
        String solver_type = System.getProperty("ASP_SOLVER_TYPE");
        if (solver_loc != null && solver_type != null) {
            solver_loc = solver_loc.trim();
            solver_type = solver_type.trim();
            if (!(solver_loc.isEmpty() || solver_type.isEmpty())) {
                solver_loc = (new File(solver_loc)).getAbsolutePath();
                this.s.setSolverLocation(solver_loc);
                this.s.setSolverType(solver_type);
            }
        } else {
            System.err.println("ASP_SOLVER_DIRECTORY or ASP_SOLVER_TYPE not set.");
        }
        unit_test_folder = System.getProperty("UNIT_TEST_DIRECTORY");
        s.setErrorDestination(null);
        s.setFinalAnswerSetDestination(null);
        s.setIntermediateASPfDestination(null);
        s.setIntermediateAnswerSetDestination(null);
        s.setPreModelDestination(null);
        s.setSymbolTableDestination(null);
        s.setTransitionModelDestination(null);
    }

    private void reset() {
        st = new SymbolTable("top", null);
        er = new ErrorReport();
        aspf = new ASPfProgram();
        pm = new SPARCProgram();
        tm = new SPARCProgram();
        pm_as = new ArrayList<>();
        tm_as = new ArrayList<>();
    }

    public void compile(String almProgramLocation) {
        reset();
        s.setSystemDescriptionFileName(almProgramLocation);
        ALMCompiler.Compile(s, st, er, aspf, pm, pm_as, tm, tm_as);
    }

    public void assertNoSyntaxErrors() {
        assertEquals("Syntax error occurred where none was expected.", er.getSyntaxErrors().size(), 0);
    }

    public void assertSemanticErrorCount(int size) {
        int count = er.getSemanticErrors().size();
        assertEquals("Number Of Semantic Errors = " + count + ", Expected = " + size, count, size);
    }

    public void assertNoSemanticErrors() {
        assertSemanticErrorCount(0);
    }

    public void Fail(String comment) {
        assertEquals(comment, 1, 0);
    }

    protected String almUnitTest(String folder, String testfamily, String testnumber) throws FileNotFoundException {
        String relative_path = unit_test_folder + File.separator + folder + File.separator + testfamily + File.separator + testfamily + "-" + testnumber + ".alm";
        return new File(relative_path).getAbsolutePath();

    }

    protected void testProgram(String programFile, String answersetFile) {
        System.out.println("TEST PROGRAM: " + programFile);
        String almProgLoc = unit_test_folder + File.separator + "programs" + File.separator + programFile;
        String ansLoc = unit_test_folder + File.separator + "programs" + File.separator + answersetFile;
        compile(almProgLoc);

        System.out.println("Verifying Answerset");
        if (tm_as.size() != 1) {
            System.out.println("FAILED to produce exactly 1 intermediate answerset.");
            testProgramsPassed = false;
            return;
        }

        String rawAS = null;
        try {
            rawAS = readFile(ansLoc);
        } catch (IOException ex) {
            System.out.println("FAILED due to bad file location for expected answerset: " + ex.getMessage());
            testProgramsPassed = false;
            return;
        }
        List<AnswerSet> ansSets = new DLVAnswerSetParser().getAnswerSets(new BufferedReader(new StringReader(rawAS)));
        if (ansSets.size() != 1) {
            System.out.println("FAILED to produce exactly 1 final answerset.");
            testProgramsPassed = false;
            return;
        }
        AnswerSet aSet = ansSets.get(0);
        Set<String> expected = aSet.getAllLiteralInstances();
        Set<String> received = tm_as.get(0).getAllLiteralInstances();
        Set<String> expMinusRec = new HashSet<>(expected);
        expMinusRec.removeAll(received);
        Set<String> recMinusExp = new HashSet<>(received);
        recMinusExp.removeAll(expected);
        if (expMinusRec.size() != 0 || recMinusExp.size() != 0) {
            if (expMinusRec.size() != 0) {
                System.out.println("Final Answerset Missing Literals:");
                for (String lit : expMinusRec) {
                    System.out.println("        " + lit);
                }
            }
            if (recMinusExp.size() != 0) {
                System.out.println("Final Answerset Excess Literals:");
                for (String lit : recMinusExp) {
                    System.out.println("        " + lit);
                }
            }
            testProgramsPassed = false;
            System.out.println("FAILED\n");
            return;
        }
        System.out.println("PASSED\n");
    }

    protected void testProgramsFinished() {
        assertEquals("One or more test programs failed.", testProgramsPassed, true);
    }

    public void assertFinalAnswersetContainsFacts(String... facts) {
        assertEquals("Failed to achieve exactly one answerset.", tm_as.size(), 1);
        AnswerSet as = tm_as.get(0);
        Set<String> allFacts = as.getAllLiteralInstances();
        for (String fact : facts) {
            if (!allFacts.contains(fact)) {
                assertEquals("Final answerset is missing fact: " + fact, true, false);
            }
        }
    }

    public void assertFinalAnswersetMissingFacts(String... facts) {
        assertEquals("Failed to achieve exactly one answerset.", tm_as.size(), 1);
        AnswerSet as = tm_as.get(0);
        Set<String> allFacts = as.getAllLiteralInstances();
        for (String fact : facts) {
            if (allFacts.contains(fact)) {
                assertEquals("Final answerset is contains fact: " + fact, true, false);
            }
        }
    }

    private String readFile(String fileLoc) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileLoc));
        StringBuilder output = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                output.append(line).append(ls);
            }
            return output.toString();
        } finally {
            reader.close();
        }
    }

}
