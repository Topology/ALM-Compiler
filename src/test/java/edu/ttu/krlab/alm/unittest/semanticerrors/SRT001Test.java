/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ttu.krlab.alm.unittest.semanticerrors;

import edu.ttu.krlab.alm.datastruct.err.SemanticError;
import edu.ttu.krlab.alm.unittest.UnitTestingBase;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Topology
 */
public class SRT001Test extends UnitTestingBase {

    @Test
    public void SRT001BooleansTest() throws FileNotFoundException {
        Compile(almUnitTest("semanticerrors", "srt001", "1"));
        assertNoSyntaxErrors();
        assertSemanticErrorCount(1);
        assertEquals("SRT001 for 'booleans' did not occur.", SemanticError.SRT001, er.getSemanticErrors().get(0).getErrorID());
    }
    
    @Test
    public void SRT001IntegersTest() throws FileNotFoundException {
        Compile(almUnitTest("semanticerrors", "srt001", "2"));
        assertNoSyntaxErrors();
        assertSemanticErrorCount(1);
        assertEquals("SRT001 for 'integers' did not occur.", SemanticError.SRT001, er.getSemanticErrors().get(0).getErrorID());
    }
}
