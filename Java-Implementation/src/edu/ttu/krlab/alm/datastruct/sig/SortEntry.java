package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;

public class SortEntry {

    String sortName;
    Set<SortEntry> parentSorts;
    Set<SortEntry> childSorts;
    Set<NormalFunctionEntry> attributes;
    List<ALMTerm> instances;
    Location loc;
    ConstantEntry singletonConstant = null;
    Set<ConstantEntry> constants = null;
    boolean constantsSetIsFresh = false;

    public SortEntry(String sortname, Location loc) {
        sortName = sortname;
        if (loc == null)
            this.loc = new Location();
        else
            this.loc = loc;
        parentSorts = new HashSet<SortEntry>();
        childSorts = new HashSet<SortEntry>();
        attributes = new HashSet<NormalFunctionEntry>();
        instances = new ArrayList<ALMTerm>();
    }

    public String getSortName() {
        return sortName;
    }

    public void addParentSort(SortEntry parent) {
        parentSorts.add(parent);
        parent.getChildSorts().add(this);
        parent.descendantSortEntryAdded(this);

    }

    public Set<SortEntry> getParentSorts() {
        return parentSorts;
    }

    public void addChildSort(SortEntry child) {
        childSorts.add(child);
        child.getParentSorts().add(this);
    }

    public Set<SortEntry> getChildSorts() {
        return childSorts;
    }

    public void addAttribute(NormalFunctionEntry attribute) {
        attributes.add(attribute);
    }

    public Set<NormalFunctionEntry> getAttributes() {
        Set<NormalFunctionEntry> attributes = new HashSet<NormalFunctionEntry>();
        attributes.addAll(this.attributes);
        for (SortEntry parent : this.parentSorts)
            attributes.addAll(parent.getAttributes());
        return attributes;
    }

    public Location getLocation() {
        return loc;
    }

    public void writeTo(BufferedWriter out, Set<SortEntry> printed) throws IOException {
        if (printed.contains(this))
            return;

        //Make sure all parent sorts printed first. 
        Iterator<SortEntry> itP = parentSorts.iterator();
        while (itP.hasNext()) {
            itP.next().writeTo(out, printed);
        }
        out.write("\n");

        out.write("sort.name: " + sortName + "\n");
        out.write("sort.parents: ");
        itP = parentSorts.iterator();
        while (itP.hasNext()) {
            SortEntry parent = itP.next();
            out.write(parent.getSortName());
            if (itP.hasNext())
                out.write(", ");
        }
        out.write("\n");
        out.write("sort.children: ");
        Iterator<SortEntry> itC = childSorts.iterator();
        while (itC.hasNext()) {
            SortEntry child = itC.next();
            out.write(child.getSortName());
            if (itC.hasNext())
                out.write(", ");
        }
        out.write("\n");
        out.write("sort.attributes:\n");
        Iterator<NormalFunctionEntry> itF = attributes.iterator();
        while (itF.hasNext()) {
            out.write("   ");
            FunctionEntry fe = itF.next();
            fe.writeTo(out);
        }

        out.write("sort.instances:\n");
        for (ALMTerm instance : instances) {
            instance.writeTo(out);
            out.write("\n");
        }
        out.write("\n");

        out.write("sort.location: ");
        loc.writeTo(out);
        out.write("\n");

        printed.add(this);
        out.flush();
    }

    public List<ALMTerm> getInstances() {
        return instances;
    }

    public void addSortInstance(ALMTerm si) {
        instances.add(si);

    }

    public boolean subsortof(SortEntry sort) {
        if (sort == null)
            return false;
        if (this == sort)
            return true;
        for (SortEntry parent : this.parentSorts)
            if (parent.subsortof(sort))
                return true;

        return false;
    }

    @Override
    public String toString() {
        return this.sortName;
    }

    public void setSingletonConstant(ConstantEntry ce) {
        this.singletonConstant = ce;
    }

    public ConstantEntry getSingletonConstant() {
        return this.singletonConstant;
    }

    public boolean isSingletonSort() {
        return this.singletonConstant != null;
    }

    public Set<ConstantEntry> getConstants() {
        //caches the set until and does not recalculate it until a descendant sort is added and marks the set as stale.  
        if (constantsSetIsFresh) {
            return constants;
        } else {
            if (constants == null)
                constants = new HashSet<>();
            getConstantsHelp(constants);
            constantsSetIsFresh = true;
            return constants;
        }
    }

    /**
     * Recursively descends the childSort tree to collect all the ConstantEntries from anys descendant SingletonSorts
     * 
     * @param constants
     *            A Set of ConstantEntry to accumulate the contents of SingletonSorts into.
     */
    private void getConstantsHelp(Set<ConstantEntry> constants) {
        if (this.isSingletonSort()) {
            constants.add(this.singletonConstant);
        } else {
            for (SortEntry childSort : childSorts) {
                childSort.getConstantsHelp(constants);
            }
        }
    }

    private void descendantSortEntryAdded(SortEntry sort) {
        constantsSetIsFresh = false;
        if (parentSorts != null)
            for (SortEntry parent : parentSorts) {
                parent.descendantSortEntryAdded(sort);
            }
    }

    public void removeSortInstanceWithName(String name) {
        ALMTerm matching = null;
        for (ALMTerm inst : instances) {
            if (inst.getName().equals(name)) {
                matching = inst;
                break;
            }
        }
        if (matching != null)
            instances.remove(matching);
    }
}
