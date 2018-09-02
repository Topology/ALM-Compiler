/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ttu.krlab.alm.datastruct.sig.exception;

import edu.ttu.krlab.alm.datastruct.Location;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 *
 * @author Topology
 */
public class NameCollisionException extends Exception {

    private String name;
    private Location location;

    public NameCollisionException(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

}
