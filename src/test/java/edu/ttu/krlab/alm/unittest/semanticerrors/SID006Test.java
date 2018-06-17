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
public class SID006Test extends UnitTestingBase {
    
    @Test
    public void SID006NoAttributeDefinedTest() throws FileNotFoundException {
        System.out.println("1");
        compile(almUnitTest("semanticerrors", "SID006", "1"));
        assertNoSyntaxErrors();
        assertSemanticErrorCount(0);
    }
    
    @Test
    public void SID006AttributeDefinedTest() throws FileNotFoundException {
        compile(almUnitTest("semanticerrors", "SID006", "2"));
        assertNoSyntaxErrors();
        assertSemanticErrorCount(1);
        assertEquals("SID006 did not occur.", SemanticError.SID006, er.getSemanticErrors().get(0).getErrorID());
        
    }
}
