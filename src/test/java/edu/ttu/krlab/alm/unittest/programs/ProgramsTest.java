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
        testProgram("basicMotion.alm", "basicMotion.answerset");
        testProgram("coin_flip.alm", "coin_flip.answerset");
        testProgram("multi-module-country.alm", "multi-module-country.answerset");
        testProgram("npainting.alm", "npainting.answerset");
        testProgram("named_entity_library.alm", "named_entity_library.answerset");
        testProgram("coin_flip_plan.alm", "coin_flip_plan.answerset");
        testProgramsFinished();
    }
    
    public static void main(String[] args){
        new ProgramsTest().programsTest();
    }
}
