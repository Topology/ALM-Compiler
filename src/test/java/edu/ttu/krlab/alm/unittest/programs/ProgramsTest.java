/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ttu.krlab.alm.unittest.programs;

import edu.ttu.krlab.alm.unittest.UnitTestingBase;
import org.junit.Test;

/**
 *
 * @author Topology
 */
public class ProgramsTest extends UnitTestingBase {
    
    
    @Test
    public void programsTest() {
        testProgram("empty.alm", "empty.answerset");
        testProgram("basic1.alm", "basic1.answerset");
        testProgram("multi-module-country.alm", "multi-module-country.answerset");
        testProgramsFinished();
    }
}
