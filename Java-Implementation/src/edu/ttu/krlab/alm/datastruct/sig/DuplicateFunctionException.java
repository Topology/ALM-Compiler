package edu.ttu.krlab.alm.datastruct.sig;

public class DuplicateFunctionException extends Exception {
	
	FunctionEntry existing;

	public DuplicateFunctionException(FunctionEntry fe){
		existing = fe;
	}
	
	public FunctionEntry getFunctionEntry(){
		return existing;
	}
}
