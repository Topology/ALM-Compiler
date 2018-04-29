package edu.ttu.krlab.alm.answerset;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.answerset.parser.*;

public class AnswerSets {

	public static void writeTo(BufferedWriter out, List<AnswerSet> asets) throws IOException{
		if(out == null)
			return;
		int count = 0;
		int num_anssets = asets.size();
		for(AnswerSet as : asets){
			count ++;
			out.write("% Answer Set "+count+" of "+ num_anssets+"\n");
			out.write("{\n");
			boolean firstLine = true;
			for(List<ALMTerm> lits : as.getAllAlmTerms()){
				if(firstLine) {
					firstLine = false;
					out.write(" ");
				} else {
					out.write(",");
				}
				boolean first = true;
				for(ALMTerm lit : lits){
					if(first){
						first = false;
					} else {
						out.write(", ");
					}
					lit.writeTo(out);
				}

				out.write("\n");
			}
			out.write("}\n\n");
		}
		
		
		out.flush();
	}
	
}
