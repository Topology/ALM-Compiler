package edu.ttu.krlab.alm.datastruct.aspf;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.ttu.krlab.alm.ALM;
import edu.ttu.krlab.alm.datastruct.ALMTerm;
import edu.ttu.krlab.alm.datastruct.sig.ConstantEntry;

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
	
	//change and find rules by constant definition value
	public void replaceConstant(String section, ConstantEntry cnt, ALMTerm value){
		List <ASPfRule> sec = program.get(section);
		if(sec != null){
			for(int i = 0 ; i < sec.size(); i++){
				ASPfRule aspfrule = sec.get(i);
				//first check the Head
				ALMTerm head = (ALMTerm) aspfrule.getHead();
				if(head != null){
					if(head.getType() == ALMTerm.ID || head.getType() == ALMTerm.FUN)
						findChange(sec, aspfrule, head, cnt, value);
					else if (head.getType() == ALMTerm.TERM_RELATION){
						findChange(sec, aspfrule, head.getArg(0), cnt, value);
						findChange(sec, aspfrule, head.getArg(1), cnt, value);
					}
				}
				List<ASPfLiteral> body = aspfrule.getBody();
				if(body != null){
					for(ASPfLiteral bodyElement : body){
						ALMTerm bodyTerm = (ALMTerm) bodyElement;
						if(bodyTerm.getType() == ALMTerm.ID || bodyTerm.getType() == ALMTerm.FUN)
							findChange(sec, aspfrule, bodyTerm, cnt, value);
						else if (bodyTerm.getType() == ALMTerm.TERM_RELATION){
							findChange(sec, aspfrule, bodyTerm.getArg(0), cnt, value);
							findChange(sec, aspfrule, bodyTerm.getArg(1), cnt, value);
						}
					}
				}
			}
		}
	}
	public void findChange(List<ASPfRule> sec, ASPfRule aspfrule, ALMTerm literal, ConstantEntry cnt, ALMTerm value){
		
		if(literal.getType() == ALMTerm.ID){
			if(literal.getName().equals(cnt.getConstName())){
				literal = value;
				sec.remove(aspfrule);
				ASPfRule newASPfrule = new ASPfRule(literal, aspfrule.getBody());
				sec.add(newASPfrule);
			}
		}else if(literal.getType() == ALMTerm.FUN){
			if(literal.getName().equals(cnt.getConstName())){
				literal = value;
				sec.remove(aspfrule);
				ASPfRule newASPfrule = new ASPfRule(literal, aspfrule.getBody());
				sec.add(newASPfrule);
			}
			else{
				List<ALMTerm> literalArgs = literal.getArgs();
				boolean exist = false;
				if(literalArgs != null){
					for(int j = 0 ; j < literalArgs.size(); j++){
						if(literalArgs.get(j).getName().equals(cnt.getConstName())){
							literalArgs.set(j, value);
							exist = true;
						}
					}
				}
				if(exist){
					sec.remove(aspfrule);
					ASPfRule newASPfrule = new ASPfRule(literal, aspfrule.getBody());
					sec.add(newASPfrule);
				}
			}
		}

					
	
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
