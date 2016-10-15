package edu.ttu.krlab.alm.datastruct.sig;

public class DuplicateConstantException extends Exception {

	
	private ConstantEntry existing;
	
	public DuplicateConstantException(ConstantEntry constantentry){
		existing = constantentry;
	}
	
	public ConstantEntry getConstantEntry(){
		return existing;
	}
}
