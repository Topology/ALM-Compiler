package edu.ttu.krlab.alm.datastruct.sparc;

public class SPARCSortAlreadyDefined extends Exception {
	
	private String sortname;
	
    public SPARCSortAlreadyDefined(String sortname){
    	super();
    	this.sortname = sortname;
    }
    
    @Override
    public String getMessage(){
    	return "The sort ["+sortname+"] is already defined.";
    }

}
