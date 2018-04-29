package edu.ttu.krlab.alm.datastruct.aspf;

import java.io.BufferedWriter;
import java.io.IOException;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;
import edu.ttu.krlab.alm.datastruct.type.TypeChecker;

public interface ASPfLiteral {

	void writeTo(BufferedWriter out) throws IOException;

	void typeCheck(TypeChecker tc, SymbolTable st, ErrorReport er);

	boolean hasFluentFunction(SymbolTable st);

	ALMTerm toALMTerm();
}
