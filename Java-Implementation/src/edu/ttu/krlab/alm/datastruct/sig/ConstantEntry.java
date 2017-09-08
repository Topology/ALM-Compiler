package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;

public class ConstantEntry {

    String constName;
    List<SortEntry> sourceSorts;
    List<SortEntry> arguments;
    Location loc;

    public ConstantEntry(String name, List<SortEntry> arguments, List<SortEntry> sourceSorts, Location loc) {
        this.constName = name;
        this.arguments = new ArrayList<>(arguments);
        this.sourceSorts = new ArrayList<>(sourceSorts);
        this.loc = loc;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String newName) {
        this.constName = newName;
    }

    public List<SortEntry> getSourceSorts() {
        return sourceSorts;
    }

    public List<SortEntry> getArguments() {
        return arguments;
    }

    public Location getLocation() {
        return loc;
    }

    public void writeTo(BufferedWriter out) throws IOException {
        out.write("const.name: " + constName + "\n");
        out.write("const.sorts: ");
        Iterator<SortEntry> itS = sourceSorts.iterator();
        while (itS.hasNext()) {
            out.write(itS.next().getSortName());
            if (itS.hasNext())
                out.write(", ");
        }
        out.write("\nconst.loc: " + loc + "\n\n");

    }

    /**
     * An ALMTerm matches a ConstantEntry under the following conditions:
     * <ol>
     * <li>The ALMTerm is a variable.
     * <li>If not a variable, The names of the ConstantEntry and ALMTerm match.
     * <li>The arguments of the ConstantEntry and ALMTerm are the same length
     * <li>For each argument position i, the ALMTerm argument matches the sort arguments constant entries
     * </ol>
     * 
     * @param oterm
     * @return
     */
    public boolean matches(ALMTerm oterm) {
        if (oterm.isVariable())
            return true;
        if (oterm.getName().compareTo(this.constName) != 0)
            return false;
        int argSize = arguments.size();
        List<ALMTerm> termArgs = oterm.getArgs();
        if (termArgs.size() != argSize)
            return false;
        boolean match = false;
        for (int i = 0; i < argSize; i++) {
            ALMTerm argi = termArgs.get(i);
            for (ConstantEntry ce : arguments.get(i).getConstants()) {
                match = match || ce.matches(argi);
                if (match)
                    break;
            }
            if (match)
                break;
        }
        return match;
    }

    @Override
    public String toString() {
        if (arguments.size() == 0)
            return this.constName;

        String text = this.constName + "(";
        boolean first = true;
        for (SortEntry arg : arguments) {
            if (first) {
                first = false;
            } else {
                text += ", ";
            }
            text += "#" + arg.getSortName();
        }
        text += ")";
        return text;
    }

}
