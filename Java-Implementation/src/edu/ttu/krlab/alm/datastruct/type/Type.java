package edu.ttu.krlab.alm.datastruct.type;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.ttu.krlab.alm.datastruct.sig.SortEntry;

public abstract class Type {

	public static enum TypeKind {
		SORT, UNION, FUNCTION;
	}

	public final static SortType EMPTY_TYPE = new SortType() {

		@Override
		public boolean isSubtypeOf(SortType other) {
			return false;
		}

		@Override
		public boolean isSingleton() {
			return false;
		}

		@Override
		public SortEntry getSingleton() {
			return null;
		}

		@Override
		public Set<SortEntry> getSortEntries() {
			return null;
		}

		@Override
		public String toString() {
			return "no type";
		}

	};

	public final static SortType ANY_TYPE = new SortType() {

		@Override
		public boolean isSubtypeOf(SortType other) {
			return true;
		}

		@Override
		public boolean isSingleton() {
			return false;
		}

		@Override
		public SortEntry getSingleton() {
			return null;
		}

		@Override
		public Set<SortEntry> getSortEntries() {
			return null;
		}

		@Override
		public String toString() {
			return "any type";
		}
	};

	private static final Map<SortEntry, SortType> SETypes = new HashMap<>();
	private static final Map<Set<SortEntry>, SortType> SetTypes = new HashMap<>();

	public static SortType getSortType(SortEntry sort) {
		SortType result = SETypes.get(sort);
		if (result == null) {
			result = new SortType() {
				private final SortEntry se = sort;

				@Override
				public boolean isSubtypeOf(SortType other) {
					if (other == EMPTY_TYPE)
						return false;
					if (other == ANY_TYPE)
						return true;
					if (other.isSingleton()) {
						// se is subtype of other sort if se is subsort of other sort.
						SortEntry otherSort = other.getSingleton();
						return se.subsortof(otherSort);
					} else {
						Set<SortEntry> otherSorts = other.getSortEntries();
						// se is subtype of otherSorts if se is subsort of at least one of the other
						// sorts.
						for (SortEntry sort : otherSorts) {
							if (se.subsortof(sort))
								return true;
						}
					}
					return false;
				}

				@Override
				public boolean isSingleton() {
					return true;
				}

				@Override
				public SortEntry getSingleton() {
					return se;
				}

				@Override
				public Set<SortEntry> getSortEntries() {
					return null;
				}

				@Override
				public String toString() {
					return se.toString();
				}
			};
			SETypes.put(sort, result);
		}
		return result;
	}

	public static SortType getSortType(Collection<SortEntry> sourceSorts) {
		if (sourceSorts.size() == 0)
			return EMPTY_TYPE;

		Set<SortEntry> sorts = new HashSet<>(sourceSorts);

		SortType result = SETypes.get(sorts);
		if (result == null) {
			result = new SortType() {
				private final Set<SortEntry> sortSet = sorts;

				@Override
				public boolean isSubtypeOf(SortType other) {
					if (other == EMPTY_TYPE)
						return false;
					if (other == ANY_TYPE)
						return true;
					if (other.isSingleton()) {
						SortEntry otherSort = other.getSingleton();
						// every element of sortSet must be subtype of other sort.
						for (SortEntry sort : sortSet) {
							if (!sort.subsortof(otherSort))
								return false;
						}
						return true;
					} else {
						Set<SortEntry> otherSorts = other.getSortEntries();
						// every element of sortSet must be a subsort of at least one of the otherSorts.
						for (SortEntry sort : sortSet) {
							boolean subsort = false;
							for (SortEntry oSort : otherSorts) {
								if (sort.subsortof(oSort)) {
									subsort = true;
								}
							}
							if (!subsort)
								return false;
						}
						return true;
					}
				}

				@Override
				public boolean isSingleton() {
					return false;
				}

				@Override
				public SortEntry getSingleton() {
					return null;
				}

				@Override
				public Set<SortEntry> getSortEntries() {
					return sortSet;
				}

				@Override
				public String toString() {
					return sortSet.toString();
				}
			};
			SetTypes.put(sorts, result);
		}
		return result;
	}

	public static SortType intersect(SortType t1, SortType t2) {

		// self-intersection
		if (t1 == t2)
			return t1;
		// intersection with EMPTY_TYPE
		if (t1 == EMPTY_TYPE || t2 == EMPTY_TYPE)
			return EMPTY_TYPE;
		// intersection with ANY_TYPE
		if (t1 == ANY_TYPE)
			return t2;
		if (t2 == ANY_TYPE)
			return t1;

		if (t1.isSingleton()) {
			SortEntry t1Sort = t1.getSingleton();
			if (t2.isSingleton()) {
				// intersect two singleton sorts.
				SortEntry t2Sort = t2.getSingleton();
				if (t1Sort.subsortof(t2Sort))
					return t1;
				else if (t2Sort.subsortof(t1Sort))
					return t2;
				else
					return EMPTY_TYPE;
			} else {
				return intersectSingletonAndSet(t1Sort, t2.getSortEntries());
			}
		} else if (t2.isSingleton()) {
			return intersectSingletonAndSet(t2.getSingleton(), t1.getSortEntries());
		} else {
			return intersectSetAndSet(t1.getSortEntries(), t2.getSortEntries());
		}

	}

	private static SortType intersectSingletonAndSet(SortEntry se, Set<SortEntry> seSet) {
		Set<SortEntry> result = new HashSet<>();
		for (SortEntry sort : seSet) {
			if (se.subsortof(sort))
				addMinimize(se, result);
			if (sort.subsortof(se))
				addMinimize(sort, result);
		}

		return getSortType(result);
	}

	public static SortType intersectSetAndSet(Set<SortEntry> set1, Set<SortEntry> set2) {
		if (set1.size() == 0 || set2.size() == 0)
			return EMPTY_TYPE;
		Set<SortEntry> result = new HashSet<>();
		for (SortEntry sort1 : set1) {
			for (SortEntry sort2 : set2) {
				if (sort1.subsortof(sort2)) {
					addMinimize(sort1, result);
				} else if (sort2.subsortof(sort1)) {
					addMinimize(sort2, result);
				}
			}
		}
		return getSortType(result);
	}

	/**
	 * addMinimize maintains the invarient that there is no intersection between any
	 * of the sorts in the set. When adding a new sort, if the new sort is a subsort
	 * of an existing sort, it is not added and the original set is returned. If one
	 * of the existing sorts in the set is a subsort of the new sort, it is added to
	 * the remove list. All sorts on the remove list are removed and replaced by the
	 * new sort which contains them all.
	 * 
	 * @param se
	 * @param seSet
	 */
	private static void addMinimize(SortEntry se, Set<SortEntry> seSet) {
		Set<SortEntry> removeSet = new HashSet<>();
		for (SortEntry sort : seSet) {
			if (se.subsortof(sort))
				return;
			else if (sort.subsortof(se)) {
				removeSet.add(sort);
			}
		}

		for (SortEntry remove : removeSet) {
			seSet.remove(remove);
		}
		seSet.add(se);
	}

}
