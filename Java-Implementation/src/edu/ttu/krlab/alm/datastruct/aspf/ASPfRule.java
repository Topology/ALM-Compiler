package edu.ttu.krlab.alm.datastruct.aspf;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.ttu.krlab.alm.datastruct.LogicProgramArtifact;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.type.TypeChecker;

public class ASPfRule extends LogicProgramArtifact {

    TypeChecker typeChecker = null;
    final Set<String> variables = new HashSet<>();
    ASPfLiteral head;
    List<ASPfLiteral> body;

    public ASPfRule(ASPfLiteral head, List<ASPfLiteral> body) {
        this.head = head;
        this.body = body;
        if (head != null)
            head.toALMTerm().registerVariables(variables);
        if (body != null)
            for (ASPfLiteral lit : body) {
                lit.toALMTerm().registerVariables(variables);
            }

    }

    public ASPfLiteral getHead() {
        return head;
    }

    public List<ASPfLiteral> getBody() {
        return body;
    }

    @Override
    public void writeTo(BufferedWriter out) throws IOException {

        super.writeTo(out);

        if (head != null) {
            // head exists
            head.writeTo(out);
            if (body == null || body.size() == 0)
                // complete writing a fact.
                out.write(".\n\n");
        }
        if (body != null && body.size() > 0) {
            // body exists
            if (head != null)
                out.write(" :- "); // space preceding and after separator
            else
                out.write(":- "); // no preceding space for constraint rule
            boolean first = true;
            for (ASPfLiteral lit : body) {
                if (first)
                    first = false;
                else
                    out.write(", ");
                if (lit == null)
                    out.write("what is going on here?");
                lit.writeTo(out);
            }
            out.write(".\n\n"); // complete rule
        }
        // if both head and body are null, write nothing out.
        out.flush();
    }

    public boolean hasFluentFunction(SymbolTable st) {
        if (this.head != null)
            if (head.hasFluentFunction(st))
                return true;
        if (this.body != null)
            for (ASPfLiteral body_lit : body)
                if (body_lit.hasFluentFunction(st))
                    return true;

        return false;

    }

    public String newVariable(String var) {
        if (!variables.contains(var))
            return var;
        int count = 1;
        String newVar = var + count;
        while (variables.contains(newVar))
            newVar = var + (++count);
        return newVar;
    }

    public void setTypeChecker(TypeChecker tc) {
        typeChecker = tc;
    }

    public TypeChecker getTypeChecker() {
        if (typeChecker == null) {
            if (head != null)
                typeChecker = head.toALMTerm().getTypeChecker();
            else
                typeChecker = body.iterator().next().toALMTerm().getTypeChecker();
        }
        return typeChecker;
    }

}
