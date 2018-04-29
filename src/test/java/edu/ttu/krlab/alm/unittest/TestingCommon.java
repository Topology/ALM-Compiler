package edu.ttu.krlab.alm.unittest;

import static org.junit.Assert.assertEquals;
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

public class TestingCommon {

    ALMCompilerSettings s;
    SymbolTable st;
    ErrorReport er;
    ASPfProgram aspf;
    SPARCProgram pm;
    SPARCProgram tm;
    List<AnswerSet> as;

    public TestingCommon() {
        this.s = new ALMCompilerSettings();
    }

    private void reset() {
        st = new SymbolTable("top");
        er = new ErrorReport();
        aspf = new ASPfProgram();
        pm = new SPARCProgram();
        tm = new SPARCProgram();
        as = new ArrayList<AnswerSet>();
    }

    public void Translate(String almProgram) {

        reset();
        StringReader r = new StringReader(almProgram);
        try {
            ALMCompiler.Translate(s, st, er, aspf, pm, as, tm);
        } catch (IOException e) {
            e.printStackTrace();
            assertEquals("Translation Threw An Error That Was Not Handled", 0, 1);
        }

    }

    public void assertNoSyntaxErrors() {
        assertEquals("No Syntax Errors Should Occur", er.getSyntaxErrors().size(), 0);
    }

    public void assertSemanticErrors() {
        assertNotEquals("Semantic Errors Must Occur For This Test", er.getSemanticErrors().size(), 0);
    }

    public void Fail(String comment) {
        assertEquals(comment, 1, 0);

    }
}
