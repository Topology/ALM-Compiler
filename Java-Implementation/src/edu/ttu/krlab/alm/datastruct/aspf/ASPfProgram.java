package edu.ttu.krlab.alm.datastruct.aspf;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.ttu.krlab.alm.ALM;

/*
 *  The ASP{f} program is going to be segmented by relevant parts. 
 *  At the top level it is a map from named sections to arrays of rules.
 *    
 */


public class ASPfProgram {
	
	private Map<String, List<ASPfRule>> program;
	

	public ASPfProgram(){
		program = new HashMap<String, List<ASPfRule>>();

	}
	
	public void createSection(String section){
		List <ASPfRule> sec = program.get(section);
		if(sec == null){
			sec = new ArrayList<ASPfRule>();
			program.put(section, sec);
		}
	}
	
	public ASPfRule newRule(String section, ASPfLiteral head, List<ASPfLiteral> body){
		
		List <ASPfRule> sec = program.get(section);
		if(sec == null){
			sec = new ArrayList<ASPfRule>();
			program.put(section, sec);
		}
		
		ASPfRule aspfrule = new ASPfRule(head, body);
		sec.add(aspfrule);
		return aspfrule;
	}
	
	public List<ASPfRule> getRules(String section) {
		return program.get(section);
	}


	public void writeTo(BufferedWriter out) throws IOException {
		if(out == null)
			return;

		out.write("%---------------------\n");
		out.write("%-- ASP{f} PROGRAM ---\n");
		out.write("%---------------------\n\n");
		
		Iterator<String> sections = program.keySet().iterator();
		while(sections.hasNext()){
			String sect = sections.next();

			out.write("%---------------------\n");
			out.write("%-- ASP{f} PROGRAM: "+sect+"\n");
			out.write("%---------------------\n\n");
			Iterator<ASPfRule> it = program.get(sect).iterator();
			while(it.hasNext()){
				ASPfRule aspfrule = it.next();
				aspfrule.writeTo(out);
			}
		}
		out.write("%-------------------------\n");
		out.write("%-- END ASP{f} PROGRAM ---\n");
		out.write("%-------------------------\n\n");
			
		out.write("\n\n");
		out.flush();
		
	}
}
