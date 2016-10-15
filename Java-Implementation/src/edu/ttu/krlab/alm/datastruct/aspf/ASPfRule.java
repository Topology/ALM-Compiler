package edu.ttu.krlab.alm.datastruct.aspf;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ttu.krlab.alm.datastruct.LogicProgramArtifact;
import edu.ttu.krlab.alm.datastruct.VariableManager;
import edu.ttu.krlab.alm.datastruct.sig.SymbolTable;

public class ASPfRule extends LogicProgramArtifact {

	ASPfLiteral head;
	List<ASPfLiteral> body;
	
	public ASPfRule(ASPfLiteral head, List<ASPfLiteral>body){
		this.head = head;
		this.body = body;
	}
	


	public ASPfLiteral getHead() {
		return head;
	}
	
	
	public List<ASPfLiteral> getBody() {
		return body;
	}

	
	public void writeTo(BufferedWriter out) throws IOException {
		
		super.writeTo(out);
		
		if(head != null) {
			//head exists
			head.writeTo(out);
			if(body == null || body.size() == 0) 
				//complete writing a fact.
				out.write(".\n\n");
		}
		if(body != null && body.size() > 0) {
			//body exists
			if(head != null)
				out.write(" :- "); //space preceding and after separator
			else 
				out.write(":- "); //no preceding space for constraint rule
			boolean first = true;
			for(ASPfLiteral lit : body){
				if(first)
					first = false;
				else 
					out.write(", ");
				if(lit == null)
					out.write("what is going on here?");
				lit.writeTo(out);
			}
			out.write(".\n\n"); // complete rule
		}
		//if both head and body are null, write nothing out. 
		out.flush();
	}



	public boolean hasFluentFunction(SymbolTable st) {
		if(this.head != null)
			if(head.hasFluentFunction(st))
				return true;
		if(this.body != null)
			for(ASPfLiteral body_lit : body)
				if(body_lit.hasFluentFunction(st))
					return true;
			
		return false;
				
	}



	public VariableManager initializeNewVariableManager(SymbolTable st) {
		VariableManager vm = new VariableManager(st);
		if(head != null)
			head.registerVariables(vm);
		if(body != null)
			for(ASPfLiteral lit : body)
				lit.registerVariables(vm);
		return vm;
	}
	

	
}
