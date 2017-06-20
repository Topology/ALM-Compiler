package edu.ttu.krlab.alm.datastruct.sig;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.Location;

public class SortEntry {
	
	String sortName;
	Set<SortEntry> parentSorts;
	Set<SortEntry> childSorts;
	Set<NormalFunctionEntry> attributes;
	List<ALMTerm> instances;
	List<ConstantEntry> constants; 
	Location loc;
	
	

	public SortEntry(String sortname, Location loc){
		sortName = sortname;
		if(loc == null)
			this.loc =  new Location();
		else
			this.loc = loc;
		parentSorts = new HashSet<SortEntry>();
		childSorts = new HashSet<SortEntry>();
		attributes = new HashSet<NormalFunctionEntry>();
		instances = new ArrayList<ALMTerm>();
		constants = new ArrayList<ConstantEntry>();
	}
	
	public String getSortName() {
		return sortName;
	}
	
	public void addParentSort(SortEntry parent) {
		parentSorts.add(parent);
		parent.getChildSorts().add(this);
		
	}
	
	public Set<SortEntry> getParentSorts() {
		return parentSorts;
	}
	
	public void addChildSort(SortEntry child) {
		childSorts.add(child);	
		child.getParentSorts().add(this);
	}
	
	public Set<SortEntry> getChildSorts() {
		return childSorts;
	}
	
	public void addAttribute(NormalFunctionEntry attribute) {
		attributes.add(attribute);
	}

	public Set<NormalFunctionEntry> getAttributes() {
		Set <NormalFunctionEntry> attributes = new HashSet<NormalFunctionEntry>();
		attributes.addAll(this.attributes);
		for(SortEntry parent : this.parentSorts)
			attributes.addAll(parent.getAttributes());
		return attributes;
	}
	
	public Location getLocation() {
		return loc;
	}

	public void writeTo(BufferedWriter out, Set<SortEntry> printed) throws IOException {
		if(printed.contains(this)) return;
		
		//Make sure all parent sorts printed first. 
		Iterator<SortEntry> itP = parentSorts.iterator();
		while(itP.hasNext()) {
			itP.next().writeTo(out, printed);
		}
		out.write("\n");
		
		out.write("sort.name: "+sortName+"\n");
		out.write("sort.parents: ");
		itP = parentSorts.iterator();
		while(itP.hasNext()){
			SortEntry parent = itP.next();
			out.write(parent.getSortName());
			if(itP.hasNext())
				out.write(", ");
		}
		out.write("\n");
		out.write("sort.children: ");
		Iterator<SortEntry>itC = childSorts.iterator();
		while(itC.hasNext()){
			SortEntry child = itC.next();
			out.write(child.getSortName());
			if(itC.hasNext())
				out.write(", ");
		}
		out.write("\n");
		out.write("sort.attributes:\n");
		Iterator<NormalFunctionEntry> itF = attributes.iterator();
		while(itF.hasNext()){
			out.write("   ");
			FunctionEntry fe = itF.next();
			fe.writeTo(out);
		}

		out.write("sort.instances:\n");
		for(ALMTerm instance : instances){
			instance.writeTo(out);
			out.write("\n");
		}
		out.write("\n");
		
		out.write("sort.location: ");
		loc.writeTo(out);
		out.write("\n");
		
		
		
		
		printed.add(this);
		out.flush();
	}

	public List<ALMTerm> getInstances() {
		return instances;
	}

	public void addSortInstance(ALMTerm si) {
		instances.add(si);
		
	}

	public List<ConstantEntry> getConstants() {
		return constants;
	}

	public void addConstants(ConstantEntry constants) {
		this.constants.add(constants);
	}
	
	public boolean subsortof(SortEntry sort) {
		if(sort == null)
			return false;
		if(this == sort)
			return true;
		for(SortEntry parent : this.parentSorts)
			if(parent.subsortof(sort))
				return true;
		
		return false;
	}

	@Override
	public String toString(){
		return this.sortName;
	}
	
}
