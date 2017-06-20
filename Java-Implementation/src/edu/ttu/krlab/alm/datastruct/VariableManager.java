package edu.ttu.krlab.alm.datastruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import edu.ttu.krlab.alm.datastruct.err.ErrorReport;
import edu.ttu.krlab.alm.datastruct.sig.SortEntry;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;

public class VariableManager {
	
	private class VTL {
		public String var;
		public SortEntry sort;
		public ParserRuleContext loc;
		
		public VTL(){
			var = null;
			sort = null;
			loc = null;
		}
	}
	
	
	private Map<String, Set<VTL>> entries;
	private Map<String, Set<String>> equivalences;
	private Map<String, VTL> narrowestSorts;
	private SymbolTable ST;
	private boolean typechecked = false;
	private boolean passed = false;
	public VariableManager(SymbolTable ST){
		entries = new HashMap<String, Set<VTL>>();
		equivalences = new HashMap<String, Set<String>>();
		narrowestSorts = new HashMap<String, VTL>();
		this.ST = ST;
	}
	
	public void addVar(String var, ParserRuleContext location){
		typechecked = false;
		VTL entry = new VTL();
		entry.var = var;
		entry.sort = null;
		entry.loc = location;
		if(!entries.containsKey(var))
			entries.put(var,  new HashSet<VTL>());
		entries.get(var).add(entry);
		if(!equivalences.containsKey(var)){
			Set<String> vEQ = new HashSet<String>();
			vEQ.add(var);
			equivalences.put(var , vEQ);
		}
			
	}
	
	public void addTypedVar(String var, SortEntry sort, ParserRuleContext loc){
		typechecked = false;
		VTL entry = new VTL();
		entry.var = var;
		entry.sort = sort;
		entry.loc = loc;
		if(!entries.containsKey(var))
			entries.put(var,  new HashSet<VTL>());
		entries.get(var).add(entry);
		if(!equivalences.containsKey(var)){
			Set<String> vEQ = new HashSet<String>();
			vEQ.add(var);
			equivalences.put(var , vEQ);
		}
	}
	
	public void addVarEquivalence(String var1, String var2, ParserRuleContext loc){
		typechecked = false;
		if(!equivalences.containsKey(var1))
			addVar(var1, loc);
		if(!equivalences.containsKey(var2))
			addVar(var2, loc);
		Set<String> v1Eq = equivalences.get(var1);
		Set<String> v2Eq = equivalences.get(var2);
		Set<String> v3Eq = new HashSet<String>();
		v3Eq.addAll(v1Eq);
		v3Eq.addAll(v2Eq);
		equivalences.put(var1, v3Eq);
		equivalences.put(var2, v3Eq);
	}

	public boolean typeCheckPasses(ErrorReport er) {
		if(!typechecked)	
		{
			typechecked = true;
			passed = true; //until proven otherwise.
			//Type check passes if
			// 1) Every variables has a type (sort) that is inferable. 
			// 2) all overlapping type declarations have a non-empty intersection.  
			//    (types are in each other's hierarchies).  
			for(String var : this.entries.keySet()){
				for( String var2 : this.equivalences.get(var)){
					Set<VTL> intersection = new HashSet<VTL>();
					intersection.addAll(this.entries.get(var2));
					if(intersection.size() == 0){
						er.newSemanticError("AXM001").add(new Location(this.entries.get(var).iterator().next().loc));
						passed = false;
					} else {
						//this likely doesn't occur very often, so the penalty in nested for loops shouldn't be high.
						VTL narrowest = null;
						for(VTL X : intersection){
							if(X.sort == null)
								continue;								
							if(narrowest == null)
								narrowest = X;
							else if(narrowest.sort.subsortof(X.sort))
								continue;
							else if(X.sort.subsortof(narrowest.sort))
								narrowest = X;
							else{
								er.newSemanticError("AXM007").add(new Location(X.loc)).add(X.sort.getLocation()).add(narrowest.sort.getLocation());
								passed = false;
								break;
							}
						}
						this.narrowestSorts.put(var, narrowest);
					}
						
						
				}
			}
		}
			
		return passed;
	}

	public SortEntry getNarrowestSort(String var) {
		//check this part for override function on structure - it shows an error
		System.out.println(this.narrowestSorts.get(var).sort);
		return this.narrowestSorts.get(var).sort;
	}
	
	
	
	public String newVariable(String base){
		int count = 1;
		String newVar = base;
		while(entries.containsKey(newVar)){
			newVar = base + count;
			count++;
		}
		
		VTL entry = new VTL();
		entry.var = newVar;
		entry.sort = null;
		entry.loc = null;
		Set<VTL> varEntries = new HashSet<VTL>();
		varEntries.add(entry);
		entries.put(newVar, varEntries);
		
		this.typechecked = false;
		
		return newVar;
	}

}
