package edu.ttu.krlab.alm.datastruct.sparc;

public class PredicateAlreadyDeclared extends Exception {

	private String msg;
	
	public PredicateAlreadyDeclared(String pred_name) {
		msg = "Predicate with name ["+pred_name+" has already been declared and a new declaration cannot be created.";
	}
	
	@Override
	public String getMessage(){
		return msg;
	}

}
