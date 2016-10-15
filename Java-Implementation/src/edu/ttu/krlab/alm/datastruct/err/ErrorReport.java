package edu.ttu.krlab.alm.datastruct.err;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.RecognitionException;

import edu.ttu.krlab.alm.datastruct.Location;

public class ErrorReport {
	
	List<SyntaxError> syntaxError;
	List<SemanticError> semanticError;
	
	public ErrorReport(){
		syntaxError = new ArrayList<SyntaxError>();
		semanticError = new ArrayList<SemanticError>();
	}
	
	public SemanticError newSemanticError(String errorid){
		SemanticError se = new SemanticError(errorid);
		semanticError.add(se);
	  return se;
	}
	
	public List<SyntaxError> getSyntaxErrors(){
		return syntaxError;
	}

	public List<SemanticError> getSemanticErrors(){
		return semanticError;
	}

	public void writeTo(BufferedWriter err) throws IOException {
		if(err == null)
			return;
		Iterator<SyntaxError> synIT = syntaxError.iterator();
		if(synIT.hasNext()){
			err.write("-----------------------\n");
			err.write("---- SYNTAX ERRORS ----\n");
			err.write("-----------------------\n\n");
			while(synIT.hasNext()){
				synIT.next().writeTo(err);
			}
		} else {
			err.write("--------------------------\n");
			err.write("---- NO SYNTAX ERRORS ----\n");
			err.write("--------------------------\n\n");
		}
		Iterator<SemanticError> semIT = semanticError.iterator();
		if(semIT.hasNext()){
			err.write("-------------------------\n");
			err.write("---- SEMANTIC ERRORS ----\n");
			err.write("-------------------------\n\n");
			while(semIT.hasNext()){
				semIT.next().writeTo(err);
			}
		} else {
			err.write("----------------------------\n");
			err.write("---- NO SEMANTIC ERRORS ----\n");
			err.write("----------------------------\n\n");
		}
		err.write("\n\n");
		err.flush();
	}

	public SyntaxError newSyntaxError(RecognitionException recExc) {
		SyntaxError se = new SyntaxError(new Location(recExc.getOffendingToken()), recExc);
		syntaxError.add(se);
		return se;
		
	}

	public SyntaxError newSyntaxError(Location location, String message) {
		SyntaxError se = new SyntaxError(location, message);
		syntaxError.add(se);
		return se;
		
	}

	public boolean noErrors() {
		int total = semanticError.size() + syntaxError.size();
		return (total == 0);
	}


}
