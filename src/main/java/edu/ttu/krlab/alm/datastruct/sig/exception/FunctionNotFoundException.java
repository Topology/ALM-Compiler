package edu.ttu.krlab.alm.datastruct.sig.exception;

import edu.ttu.krlab.alm.datastruct.ALMTerm;

public class FunctionNotFoundException extends Exception {
	
	ALMTerm a = null;

	public FunctionNotFoundException(ALMTerm afun) {
		a = afun;
	}

	@Override
	public String getMessage(){
		return "Function Matching Term "+a.toString()+" Could Not Be Found.";
	}
	
	public ALMTerm getALMTerm(){
		return a;
	}
}
