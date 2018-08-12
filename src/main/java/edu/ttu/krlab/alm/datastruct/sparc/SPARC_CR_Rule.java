package edu.ttu.krlab.alm.datastruct.sparc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import edu.ttu.krlab.alm.ALMCompiler;

public class SPARC_CR_Rule extends SPARCRule {

    SPARCLiteral head = null;
    List<SPARCLiteral> body = null;

    public SPARC_CR_Rule(SPARCLiteral head, List<SPARCLiteral> body) {
        super(null,null);
        this.head = head;
        this.body = body;
        
    }

    @Override
    public void writeTo(BufferedWriter out) throws IOException {
        if (head == null && body == null) {

            // empty rules are used to display general comments.
            super.writeTo(out);
            out.write("\n");
            return;
        }
        // some rule to write
        super.writeTo(out); // first write out comments
        if (head == null) {
            // head does not exist
            if (body == null || body.size() == 0) {
                ALMCompiler.IMPLEMENTATION_FAILURE("Rendering SPARC rule", "Rule Has No Head Or Body");
            } else {
                // body exists but head does not, this is a constraint.
                // write constraint
                out.write(":+ ");
                boolean first = true;
                for (SPARCLiteral lit : body) {
                    if (first) {
                        first = false;
                        lit.writeTo(out);
                    } else {
                        out.write(", ");
                        lit.writeTo(out);
                    }
                }
                out.write(".\n\n");
            }
        } else {
            // head exists.
            if (body == null || body.size() == 0) {
                // body does not exist, but head does, this is a fact.
                // write fact
                head.writeTo(out);
                out.write(".\n\n");
            } else {
                // both head and body exist, this is a normal rule.
                // write full rule
                head.writeTo(out);
                out.write(" :+ ");
                boolean first = true;
                for (SPARCLiteral lit : body) {
                    if (first) {
                        first = false;
                        lit.writeTo(out);
                    } else {
                        out.write(", ");
                        lit.writeTo(out);
                    }
                }
                out.write(".\n\n");
            }
        }
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
