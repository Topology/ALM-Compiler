package edu.ttu.krlab.alm.datastruct.sparc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import edu.ttu.krlab.alm.datastruct.LogicProgramArtifact;

public class SPARCPredicate extends LogicProgramArtifact {

    String predicateName;
    List<SPARCSort> signature; //list<string> which of them should be declared?

    public SPARCPredicate(String predName) {
        this.predicateName = predName;
        signature = null;
    }

    public String getPredicateName() {
        return predicateName;
    }

    public void setPredicateName(String predicateName) {
        this.predicateName = predicateName;
    }

    public List<SPARCSort> getSignatrue() {
        return signature;
    }

    public void setSignatrue(List<SPARCSort> signature) {
        this.signature = signature;
    }

    @Override
    public void writeTo(BufferedWriter out) throws IOException {
        super.writeTo(out);
        if (signature == null || signature.size() == 0) {
            out.write(predicateName + "().\n\n");
        } else {
            out.write(predicateName + "(");
            boolean first = true;
            for (SPARCSort sort : signature) {
                if (first) {
                    first = false;
                    out.write("#" + sort.getSortName());
                } else {
                    out.write(", #" + sort.getSortName());
                }
            }
            out.write(").\n\n");
        }
    }

    public void addSPARCSort(SPARCSort sparcSort) {
        if (this.signature == null)
            this.signature = new ArrayList<SPARCSort>();
        this.signature.add(sparcSort);
    }

    @Override
    public String toString() {
        StringWriter text = new StringWriter();
        BufferedWriter bw = new BufferedWriter(text);
        try {
            writeTo(bw);
            bw.flush();
        } catch (IOException e) {
            return "";
        }
        return text.toString();
    }

}
