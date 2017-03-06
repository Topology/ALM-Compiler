package edu.ttu.krlab.alm.datastruct;

import java.io.BufferedWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class  Location {
	
	private ParserRuleContext prc = null;
	private Token token = null;
	
	public Location(){
		
	}
	
	public Location(ParserRuleContext prc){
		this.prc = prc;
		token = prc.start;
		
	}
	
	public Location(Token token) {
		this.token = token;
	}

	public Location(TerminalNode termnode) {
		this.token = termnode.getSymbol();
	}

	public int getLineNumber() {
		if(token != null)
			return token.getLine(); 
		return 0;
	}

	public int getColumnNumber() {
		if(token != null)
			return token.getCharPositionInLine(); 
		return 0;
	}

	public String toString(){
		return "["+ getText() + " "+ getLineCol() + "]";
	}

	public void writeTo(BufferedWriter out) throws IOException {
		out.write(toString());	
	}
	
	public ParserRuleContext getParserRuleContext(){
		return prc;
	}
	
	public Token getFirstToken(){
		return token;
	}

	public String getText() {
		if(prc != null)
			return prc.getText();
		if(token != null)
			return token.getText();
		return "[NO TEXT]";
	}

	public String getLineCol() {
		if(token != null)
			return String.format("(%d:%d)", token.getLine(), token.getCharPositionInLine());
		else 
			return "(0,0)";
	}
}
