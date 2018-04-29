package edu.ttu.krlab.alm.datastruct.sparc;

public class SPARCSortNotDefined extends Exception {

	private String sortname;
	
    public SPARCSortNotDefined(String sortname){
    	super();
    	this.sortname = sortname;
    }
    
    @Override
    public String getMessage(){
    	return "The sort ["+sortname+"] is referenced but has not been defined.";
    }

}
