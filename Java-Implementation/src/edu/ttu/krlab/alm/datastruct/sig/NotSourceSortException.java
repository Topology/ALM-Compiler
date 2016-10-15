package edu.ttu.krlab.alm.datastruct.sig;

public class NotSourceSortException extends Exception {
	
	SortEntry sort;
	
	public NotSourceSortException(SortEntry sort){
		this.sort = sort;
	}
	
	public SortEntry getSort(){
		return sort;
	}

}
