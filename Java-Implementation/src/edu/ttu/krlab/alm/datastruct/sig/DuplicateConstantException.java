package edu.ttu.krlab.alm.datastruct.sig;

import java.util.Set;

public class DuplicateConstantException extends Exception {

	private final ConstantEntry existing;
	private final Set<SortEntry> prevDecSorts;

	public DuplicateConstantException(ConstantEntry constantentry, Set<SortEntry> duplicatedEntries) {
		existing = constantentry;
		prevDecSorts = duplicatedEntries;
	}

	public ConstantEntry getConstantEntry() {
		return existing;
	}

	public Set<SortEntry> getPreviouslyDeclaredSorts() {
		return prevDecSorts;
	}
}
