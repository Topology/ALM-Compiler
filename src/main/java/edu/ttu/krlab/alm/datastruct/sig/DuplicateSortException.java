package edu.ttu.krlab.alm.datastruct.sig;

public class DuplicateSortException extends Exception {

	private SortEntry existing;
	
	public DuplicateSortException(SortEntry sortentry){
		existing = sortentry;
	}
	
	public SortEntry getExistingSortEntry(){
		return existing;
	}
}
