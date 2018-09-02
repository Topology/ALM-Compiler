package edu.ttu.krlab.alm.datastruct.sig.exception;

import edu.ttu.krlab.alm.datastruct.Location;

public class SortNotFoundException extends Exception {
	private String sortname = null;
	
	public SortNotFoundException(String sortname){
		this.sortname = sortname;
	}
	
	@Override
	public String getMessage(){
		return "The sort ["+sortname+"] was not found in the symbol table.";
	}

	public String getSortName() {
		return sortname;
	}
}
