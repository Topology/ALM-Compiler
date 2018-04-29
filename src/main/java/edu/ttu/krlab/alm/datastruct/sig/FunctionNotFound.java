package edu.ttu.krlab.alm.datastruct.sig;

import edu.ttu.krlab.alm.datastruct.ALMTerm;

public class FunctionNotFound extends Exception {
	
	ALMTerm a = null;

	public FunctionNotFound(ALMTerm afun) {
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
