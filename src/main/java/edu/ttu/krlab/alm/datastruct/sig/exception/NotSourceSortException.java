package edu.ttu.krlab.alm.datastruct.sig.exception;

import edu.ttu.krlab.alm.datastruct.sig.SortEntry;

public class NotSourceSortException extends Exception {
	
	SortEntry sort;
	
	public NotSourceSortException(SortEntry sort){
		this.sort = sort;
	}
	
	public SortEntry getSort(){
		return sort;
	}

}
