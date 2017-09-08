package edu.ttu.krlab.alm.datastruct.type;

import java.util.Set;

import edu.ttu.krlab.alm.datastruct.sig.SortEntry;

/**
 * A class for managing the type expressions associated with variables.
 * 
 * @author Topology
 */
public interface SortType {

	boolean isSubtypeOf(SortType other);

	boolean isSingleton();

	SortEntry getSingleton();

	Set<SortEntry> getSortEntries();

}
