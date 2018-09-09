/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ttu.krlab.alm.datastruct.sig;

import edu.ttu.krlab.alm.datastruct.Location;
import java.util.Objects;

/**
 *
 * @author Topology
 */
public class SortInstanceEntry {

    private final String name;
    private final int numArgs;
    private final Location location;
    private final SortEntry sort;

    public SortInstanceEntry(String name, int numArgs, SortEntry sort,  Location loc) {
        this.name = name;
        this.numArgs = numArgs;
        this.sort = sort;
        this.location = loc;
    }

    public String getName() {
        return name;
    }

    public int getNumArgs() {
        return numArgs;
    }

    public Location getLocation() {
        return location;
    }
    
    public SortEntry getSort() {
        return sort;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.numArgs;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SortInstanceEntry other = (SortInstanceEntry) obj;
        if (this.numArgs != other.numArgs) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
