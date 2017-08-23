package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.ALMCompiler;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;

public class SymbolTable{

	SortEntry universe;
	SortEntry actions;
	SortEntry nodes;
	SortEntry booleans;
	SortEntry integers;
	
	SortEntry timestep;
	
	private HashSet<SortEntry> predefined;
	private HashMap<String, SortEntry> SEMap;
	private HashMap<String, ConstantEntry> CEMap;
	
	/**
	 * FunctionEntrys may have the same name but the combination of name and signature must be unique. 
	 * Looking up by name should return a set of compatible functions
	 * To look up by signature as well, first lookup by name then look for the function in the set with the matching signature. 
	 */
	private HashMap<String, Set<NormalFunctionEntry>> FEMap;
	private HashMap<NormalFunctionEntry, DOMFunctionEntry> DMap;
	
	
	public SymbolTable(){
		
		SEMap = new HashMap<String, SortEntry>();
		CEMap = new HashMap<String, ConstantEntry>();
		FEMap = new HashMap<String, Set<NormalFunctionEntry>>();
		DMap = new HashMap<NormalFunctionEntry, DOMFunctionEntry>();
		try {
			initialize();
		} catch (DuplicateFunctionException | DuplicateSortException e) {
			e.printStackTrace();
			ALMCompiler.PROGRAM_FAILURE("Initializing Symbol Table", "Initialize Function Threw An Exception");
			//this should never happen.
		}
	}
	
	
	public SortEntry createSortEntry(String sortname, Location loc) throws DuplicateSortException {
		// Sort Entries must be uniquely named.
		SortEntry existing;
		try {
			existing = getSortEntry(sortname);
			throw new DuplicateSortException(existing);
		} catch (SortNotFoundException e) { 
			// Add new Sort Entry
			SortEntry srt = new SortEntry(sortname,loc);
			SEMap.put(sortname,srt);
			nodes.addSortInstance(new ALMTerm(srt.getSortName(), ALMTerm.ID));
			return srt;
		}
	}

	public SortEntry getSortEntry(String sortname) throws SortNotFoundException {
		SortEntry se = SEMap.get(sortname);
		if(se == null)
			throw new SortNotFoundException(sortname);
		return se;
	}



	public ConstantEntry createConstantEntry(String constname, List<SortEntry> sourceSorts, List<SortEntry> arguments, Location loc) throws DuplicateConstantException {
		// Constant Entries must be uniquely named
		ConstantEntry existing = getConstantEntry(constname);
		if(existing != null)
			throw new DuplicateConstantException(existing);
		
		// Add new Constant Entry
		ConstantEntry ce = new ConstantEntry(constname, sourceSorts, arguments, loc);
		Iterator<SortEntry> itS = sourceSorts.iterator();
		while(itS.hasNext()){
			SortEntry se = itS.next();
//			if(se.getChildSorts().isEmpty() == false)
//				throw new NotSourceSortException(se);
		}
		CEMap.put(constname, ce);
		return ce;
	}

	public ConstantEntry getConstantEntry(String constname) {
		return CEMap.get(constname);
	}

	public NormalFunctionEntry createFunctionEntry(String funname, List<SortEntry> signature, Location loc) throws DuplicateFunctionException {
		// Check conditions for whether or not its safe to declare the functions
		// Specifically the function to be created does not have the same function name and signature. 
		FunctionEntry existing = getFunctionEntry(funname, signature);
		if(existing != null) 
			throw new DuplicateFunctionException(existing);
		
		//safe to create new function entry, add it to the set in the map. 
		Set<NormalFunctionEntry> set = FEMap.get(funname);
		if(set == null){
			set = new HashSet<NormalFunctionEntry>();
			FEMap.put(funname, set);
		}
		NormalFunctionEntry newFun = new NormalFunctionEntry(funname, signature, loc);
		set.add(newFun );
		
		//Set DOMFunctionEntry for NormalFunction.
		DMap.put(newFun, new DOMFunctionEntry(newFun, booleans));
		return newFun;
	}

	private Set<NormalFunctionEntry> getFunctionEntry(String funname) {
		return FEMap.get(funname);
	}
	
	private FunctionEntry getFunctionEntry(String funname, List<SortEntry> signature){
		Set<NormalFunctionEntry> FS = FEMap.get(funname);
		if(FS == null)return null;
		Iterator<NormalFunctionEntry> it = FS.iterator();
		while(it.hasNext()){
			FunctionEntry fe = it.next();
			if(fe.sigMatch(signature))
				return fe;
		}
		return null;
	}

private  void initialize() throws DuplicateFunctionException, DuplicateSortException{
	
		//Before the Hierarchy can be initialized, we need a special sort entry for nodes in the hierarchy. 
		nodes = new SortEntry(ALM.SPECIAL_SORT_NODES, null);
		SEMap.put(ALM.SPECIAL_SORT_NODES, nodes);
	
		// Add Universe Sort
		universe = this.createSortEntry(ALM.SORT_UNIVERSE, null);
		
		// Add timestep Sort
		timestep = this.createSortEntry(ALM.SORT_TIMESTEP, null);
		
		//Add Actions Sort (child of universe)
		actions = this.createSortEntry(ALM.SORT_ACTIONS, null);
		actions.addParentSort(universe);
				
		//Add Predefined Sorts
		predefined = new HashSet<SortEntry>();
		//boolean
		booleans = this.createSortEntry(ALM.SORT_BOOLEANS, null);
		predefined.add(booleans);
		
		//integer
		integers = this.createSortEntry(ALM.SORT_INTEGERS, null);
		predefined.add(integers);
		
		// Add special functions
		
		//SIGNATURES 
		//universe x nodes -> booleans
		List<SortEntry> universe_nodes_booleans_sig = new ArrayList<SortEntry>();
		universe_nodes_booleans_sig.add(universe);
		universe_nodes_booleans_sig.add(nodes);
		universe_nodes_booleans_sig.add(booleans);

		//nodes x nodes -> booleans
		List<SortEntry> nodes_nodes_booleans_sig = new ArrayList<SortEntry>();
		nodes_nodes_booleans_sig.add(nodes);
		nodes_nodes_booleans_sig.add(nodes);
		nodes_nodes_booleans_sig.add(booleans);
		
		// nodes -> booleans
		List<SortEntry> nodes_booleans_sig = new ArrayList<SortEntry>();
		nodes_booleans_sig.add(nodes);
		nodes_booleans_sig.add(booleans);
		
		// actions -> booleans
		List<SortEntry> actions_booleans_sig = new ArrayList<SortEntry>();
		actions_booleans_sig.add(actions);
		actions_booleans_sig.add(booleans);
		
		
		//SPECIAL FUNCTIONS
		
		// is_a
		FunctionEntry is_a = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_IS_A, universe_nodes_booleans_sig, null);
		is_a.setSpecial();
		is_a.setStatic();
		is_a.setTotal();
		is_a.setDefined();
		
		
		// instance
		FunctionEntry instance = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_INSTANCE, universe_nodes_booleans_sig, null);
		instance.setSpecial();
		instance.setStatic();
		instance.setTotal();
		instance.setDefined();
		
		// link
		FunctionEntry link = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_LINK, nodes_nodes_booleans_sig, null);
		link.setSpecial();
		link.setStatic();
		link.setTotal();
		link.setDefined();
		
		// subsort
		FunctionEntry subsort = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_SUBSORT, nodes_nodes_booleans_sig, null);
		subsort.setSpecial();
		subsort.setStatic();
		subsort.setTotal();
		subsort.setDefined();
		
		// has_child
		FunctionEntry has_child = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_HAS_CHILD, nodes_booleans_sig, null);
		has_child.setSpecial();
		has_child.setStatic();
		has_child.setTotal();
		has_child.setDefined();
		
		// has_parent
		FunctionEntry has_parent = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_HAS_PARENT, nodes_booleans_sig, null);
		has_parent.setSpecial();
		has_parent.setStatic();
		has_parent.setTotal();
		has_parent.setDefined();
		
		// sink
		FunctionEntry sink = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_SINK, nodes_booleans_sig, null);
		sink.setSpecial();
		sink.setStatic();
		sink.setTotal();
		sink.setDefined();
		
		// source
		FunctionEntry source = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_SOURCE, nodes_booleans_sig, null);
		source.setSpecial();
		source.setStatic();
		source.setTotal();
		source.setDefined();
		
		// occurs
		FunctionEntry occurs = this.createFunctionEntry(ALM.SPECIAL_FUNCTION_OCCURS, actions_booleans_sig, null);
		occurs.setSpecial();
		occurs.setFluent();
		occurs.setTotal();
		occurs.setDefined();
		
	}
	
	public void writeTo(BufferedWriter out) throws IOException {
		if(out == null)
			return;
		out.write("------------------\n");
		out.write("-- SYMBOL TABLE --\n");
		out.write("------------------\n\n");

		out.write("-------------------\n");
		out.write("-- Sort Hierachy --\n");
		out.write("-------------------\n\n");
		

		Set<SortEntry> printed = new HashSet<SortEntry>();
		
		Iterator<String> itS = SEMap.keySet().iterator();
		while(itS.hasNext()){
			SortEntry se = SEMap.get(itS.next());
			se.writeTo(out, printed);
		}
		out.write("\n");
		out.flush();
		
		out.write("---------------------------\n");
		out.write("-- Constant Declarations --\n");
		out.write("---------------------------\n\n");
		
		Iterator<String> itC = CEMap.keySet().iterator();
		while(itC.hasNext()){
			ConstantEntry ce = CEMap.get(itC.next());
			ce.writeTo(out);
			out.write("\n");
		}
		
		out.flush();
		
		out.write("---------------------------\n");
		out.write("-- Function Declarations --\n");
		out.write("---------------------------\n\n");
		
		Iterator<String> itFS = FEMap.keySet().iterator();
		while(itFS.hasNext()){
			Set<NormalFunctionEntry> sfe = FEMap.get(itFS.next());
			Iterator<NormalFunctionEntry> itF = sfe.iterator();
			while(itF.hasNext()){
				FunctionEntry fe = itF.next();
				fe.writeTo(out);
				out.write("\n");
			}
		}
		
		out.flush();
	}


	public boolean isPredefinedSort(String sort_text) {

		if(sort_text.compareTo(ALM.SORT_BOOLEANS) == 0)
			return true;

		if(sort_text.compareTo(ALM.SORT_INTEGERS) == 0)
			return true;

		ALMTerm IntegerRange = ALM.ParseIntegerRangeFromString(sort_text);
		if(IntegerRange != null)
			return true;
	
		return false;
	}


	public List<FunctionEntry> getFunctions() {
		List<FunctionEntry> functions = new ArrayList<FunctionEntry>();
		for(String fname : FEMap.keySet())
			for(NormalFunctionEntry fun : FEMap.get(fname))
				functions.add(fun);
		return functions;
	}


	public Collection<SortEntry> getSortEntries() {
		return this.SEMap.values();
	}


	public SortEntry getUniverseSortEntry() {
		
		return universe;
	}
	
	
	public SortEntry getTimestepSortEntry() {
		
		return timestep;
	}
	
	public SortEntry getActionsSortEntry(){
		return actions;
	}
	
	public SortEntry getNodesSpecialSortEntry(){
		return nodes;
	}


	public SortEntry getBooleansSortEntry() {
		return booleans;
	}


	public FunctionEntry getFunctionEntry(ALMTerm afun) throws FunctionNotFound {
		if(afun == null || afun.getType() != ALMTerm.FUN)
			return null;
		
		//This algorithm uses the number of arguments to match functions.  
		//It might be possible to use type inference, but that would require passing in a variable manager to provide type information.  
		int num_afun_args = 0;
		if(afun.getArgs() != null)
			num_afun_args = afun.getArgs().size();
		String funName = afun.getName();
		
		if(funName.startsWith(ALM.DOM_PREFIX)){
			String actualFunName = funName.substring(ALM.DOM_PREFIX.length());
			Set<NormalFunctionEntry> entries = this.getFunctionEntry(actualFunName);
			if(entries != null)
				for(FunctionEntry f : entries){
					if(f.getSignature().size() == num_afun_args+1){  // first function of proper number of arguments is returned.
						DOMFunctionEntry d = DMap.get(f);
						if(d == null)
							throw new FunctionNotFound(afun);
						return d;
					}
				}
			throw new FunctionNotFound(afun);
		} else {
			Set<NormalFunctionEntry> entries = this.getFunctionEntry(funName);
			if(entries != null)
				for(FunctionEntry f : entries){
					if(f.isAttribute()){
						if(f.getSignature().size() == num_afun_args+1 || num_afun_args == 0)  // first function of proper number of arguments is returned.  
							return f;
					}
					else if(f.getSignature().size() == num_afun_args+1)  // first function of proper number of arguments is returned.  
						return f;
				}
			throw new FunctionNotFound(afun);
		}
	}


	public SortEntry getIntegersSortEntry() {
		return integers;
	}
	

	public Set<DOMFunctionEntry> getDOMFunctions(){
		return new HashSet<>(DMap.values());
	}
	
	public DOMFunctionEntry getDOMFunction(FunctionEntry f) {
		return DMap.get(f);
	}

	/**
	 * Creates the time step instances i where 0 <= i < {@code upper_boud}
	 * 
	 * @param upper_bound The number of time steps.  
	 */
	public void setMaxSteps(int upper_bound) {
		this.timestep.instances.clear();
		for(int i = 0; i < upper_bound; i++) {
			timestep.instances.add(new ALMTerm(Integer.toString(i), ALMTerm.INT));
		}
	}
}
