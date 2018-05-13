package edu.ttu.krlab.alm.unittest;

import static org.junit.Assert.assertNotEquals;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

public class UnitTestingBase {

    protected ALMCompilerSettings s;
    protected SymbolTable st;
    protected ErrorReport er;
    protected ASPfProgram aspf;
    protected SPARCProgram pm;
    protected SPARCProgram tm;
    protected List<AnswerSet> as;

    private String unit_test_folder = "";
    
    
    public UnitTestingBase() {
        this.s = new ALMCompilerSettings();
        String sparc_loc = System.getProperty("SPARC_JAR");
        if(sparc_loc != null && !sparc_loc.trim().isEmpty()){
            sparc_loc = (new File(sparc_loc)).getAbsolutePath();
            //System.out.println("SPARC_JAR: "+sparc_loc);
            this.s.setSPARCLocation(sparc_loc);
        } else {
            System.err.println("SPARC_JAR location not set.");
        }
        String solver_loc = System.getProperty("ASP_SOLVER_FOLDER");
        String solver_type = System.getProperty("ASP_SOLVER_TYPE");
        if(solver_loc != null && solver_type != null){
            solver_loc = solver_loc.trim();
            solver_type = solver_type.trim();
            if(!(solver_loc.isEmpty() || solver_type.isEmpty())){
                solver_loc = (new File(solver_loc)).getAbsolutePath();
                //System.out.println("ASP_SOLVER_FOLDER: "+solver_loc);
                //System.out.println("ASP_SOLVER_TYPE: "+solver_type);
                this.s.setSolverLocation(solver_loc);
                this.s.setSolverType(solver_type);
            }
        } else {
            System.err.println("ASP_SOLVER_FOLDER or ASP_SOLVER_TYPE not set.");
        }
        unit_test_folder = System.getProperty("UNIT_TEST_FOLDER");
    }

    private void reset() {
        st = new SymbolTable("top");
        er = new ErrorReport();
        aspf = new ASPfProgram();
        pm = new SPARCProgram();
        tm = new SPARCProgram();
        as = new ArrayList<>();
    }

    public void Compile(String almProgramLocation) {
        reset();
        s.setSystemDescriptionFileName(almProgramLocation);
        ALMCompiler.Compile(s, st, er, aspf, pm, as, tm);
    }

    public void assertNoSyntaxErrors() {
        assertEquals("No Syntax Errors Should Occur", er.getSyntaxErrors().size(), 0);
    }

    public void assertSemanticErrorCount(int size) {
        int count =  er.getSemanticErrors().size();
        assertEquals("Number Of Semantic Errors = "+count+", Expected = "+size, count, size);
    }
    
    public void assertNoSemanticErrors(){
        assertSemanticErrorCount(0);
    }

    public void Fail(String comment) {
        assertEquals(comment, 1, 0);
    }
    
    protected String almUnitTest(String folder, String testfamily, String testnumber) throws FileNotFoundException {
       String relative_path = unit_test_folder + File.separator + folder + File.separator + testfamily + File.separator + testfamily + "-" + testnumber + ".alm";
       return new File(relative_path).getAbsolutePath();
       
    }

    
}
