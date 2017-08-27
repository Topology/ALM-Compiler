package edu.ttu.krlab.alm.datastruct.aspf;

import java.io.BufferedWriter;
import java.io.IOException;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.VariableManager;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;

public interface ASPfLiteral {

	void writeTo(BufferedWriter out) throws IOException;

	void typeCheck(VariableManager vtc, SymbolTable ST, ErrorReport ER);

	boolean hasFluentFunction(SymbolTable st);

	void registerVariables(VariableManager vm);

	ALMTerm toALMTerm();
}


