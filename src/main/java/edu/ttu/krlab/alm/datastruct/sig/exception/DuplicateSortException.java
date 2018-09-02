package edu.ttu.krlab.alm.datastruct.sig.exception;

import edu.ttu.krlab.alm.datastruct.sig.SortEntry;

public class DuplicateSortException extends Exception {

	private SortEntry existing;
	
	public DuplicateSortException(SortEntry sortentry){
		existing = sortentry;
	}
	
	public SortEntry getExistingSortEntry(){
		return existing;
	}
}
