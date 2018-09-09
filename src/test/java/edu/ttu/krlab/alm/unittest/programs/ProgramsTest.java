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
        testProgram("briefcase.alm", "briefcase.answerset");
        testProgram("blocks_world.alm", "blocks_world.answerset");
        testProgram("painting.alm", "painting.answerset");
        testProgram("range_sort.alm", "range_sort.answerset");
        testProgram("basic_motion_library.alm", "basic_motion_library.answerset");
        testProgram("basic_holds_library.alm", "basic_holds_library.answerset");
        testProgram("frenchtoast.alm", "frenchtoast.answerset");
        testProgram("frenchtoast_plan.alm", "frenchtoast_plan.answerset");
        testProgram("var_as_instance.alm", "var_as_instance.answerset");
        testProgram("animal_development.alm", "animal_development.answerset");
        testProgram("herbrand_term_attribute.alm", "herbrand_term_attribute.answerset");
        testProgram("MonkeyBanana-allInOne.p.alm", "MonkeyBanana-allInOne.p.answerset");
        testProgram("MonkeyBanana-allInOne.tp.alm", "MonkeyBanana-allInOne.tp.answerset");
        testProgram("MonkeyBanana-useLib.tp.alm", "MonkeyBanana-useLib.p.answerset");
        testProgram("MonkeyBanana-useLib.p.alm", "MonkeyBanana-useLib.tp.answerset");
        testProgramsFinished();
    }
    
    public static void main(String[] args){
        new ProgramsTest().programsTest();
    }
}
