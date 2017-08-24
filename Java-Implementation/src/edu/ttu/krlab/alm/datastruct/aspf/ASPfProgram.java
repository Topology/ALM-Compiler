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
	
	//Replace all constants in section by value, where section is a string of ASPf rules.
	public void replaceConstant(String section, ALMTerm cnt, ALMTerm value){
		List <ASPfRule> sec = program.get(section);
		if(sec != null){
			for(int i = 0 ; i < sec.size(); i++){
				ASPfRule aspfrule = sec.get(i);
				// first check the Head
				ALMTerm head = (ALMTerm) aspfrule.getHead();
				if(head != null){
					findChange(sec, aspfrule, head, cnt, value);
				}
				// check the Body of the rule
				List<ASPfLiteral> body = aspfrule.getBody();
				if(body != null){
					for(ASPfLiteral bodyElement : body){
						ALMTerm bodyTerm = (ALMTerm) bodyElement;
						if(bodyTerm.getType() == ALMTerm.ID || bodyTerm.getType() == ALMTerm.FUN) {
							findChange(sec, aspfrule, bodyTerm, cnt, value);
						}
						else { // bodyTerm is t1 == t2
							findChange(sec, aspfrule, bodyTerm.getArg(0), cnt, value);
							findChange(sec, aspfrule, bodyTerm.getArg(1), cnt, value);
						}
					}
				}
			}
		}
	}
	
	public void findChange(List<ASPfRule> sec, ASPfRule aspfrule, ALMTerm literal, ALMTerm cnt, ALMTerm value) {
		if(literal.toString().equals(cnt.toString())) {
			literal.setContent(value);
			/*literal =  new ALMTerm(value.getName(), value.getType(), value.getSort(), value.getSign(), value.getArgs(), 
												value.getParserRuleContext(), value.getTypeChecker()); // destroy link to outside world*/
		}
		else {
			List<ALMTerm> literalArgs = literal.getArgs();
			if(literalArgs != null) {
				for(int j = 0 ; j < literalArgs.size(); j++) {
					if(literalArgs.get(j).toString().equals(cnt.toString())) {
						literalArgs.set(j, value);
					}
					else {
						findChange(sec, aspfrule, literalArgs.get(j), cnt, value);
					}
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
