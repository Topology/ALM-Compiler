package edu.ttu.krlab.alm.datastruct.sig;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import edu.ttu.krlab.alm.datastruct.Location;

public class ConstantEntry {
	
	String constName;
	List<SortEntry> sourceSorts;
	Location loc;
	
	public ConstantEntry(String name, List<SortEntry> sourceSorts, Location loc){
		this.constName = name;
		this.sourceSorts = sourceSorts;
		this.loc = loc;
	}
	public String getConstName() {
		return constName;
	}
	
	public List<SortEntry> getSourceSorts() {
		return sourceSorts;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public void writeTo(BufferedWriter out) throws IOException {
		out.write("const.name: "+constName+"\n");
		out.write("const.sorts: ");
		Iterator<SortEntry> itS = sourceSorts.iterator();
		while(itS.hasNext()){
			out.write(itS.next().getSortName());
			if(itS.hasNext())
				out.write(", ");
		}
		out.write("\nconst.loc: "+loc+"\n\n");
		
	}

}
