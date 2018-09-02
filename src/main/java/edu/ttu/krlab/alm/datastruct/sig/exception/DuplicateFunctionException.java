package edu.ttu.krlab.alm.datastruct.sig.exception;

import edu.ttu.krlab.alm.datastruct.sig.FunctionEntry;

public class DuplicateFunctionException extends Exception {
	
	FunctionEntry existing;

	public DuplicateFunctionException(FunctionEntry fe){
		existing = fe;
	}
	
	public FunctionEntry getFunctionEntry(){
		return existing;
	}
}
