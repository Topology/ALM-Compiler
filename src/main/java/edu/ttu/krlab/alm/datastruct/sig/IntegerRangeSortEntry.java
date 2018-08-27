/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ttu.krlab.alm.datastruct.sig;

import edu.ttu.krlab.alm.datastruct.Location;

/**
 *
 * @author Topology
 */
public class IntegerRangeSortEntry extends SortEntry {
    
    private int low;
    private int high;
    
    public IntegerRangeSortEntry(String sortname, int low, int high, Location loc) {
        super(sortname, loc);
        this.low = low;
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
    
}
