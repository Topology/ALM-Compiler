package edu.ttu.krlab.alm.datastruct.err;

import java.io.BufferedWriter;
import java.io.IOException;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Vocabulary;

import edu.ttu.krlab.alm.datastruct.Location;
import edu.ttu.krlab.alm.parser.ALMParser;

public class SyntaxError{
	
	private RecognitionException recErr = null;
	private String msg = null;
	private Location loc = null;


	public SyntaxError(Location location, RecognitionException recErr) {
		loc = location;
		this.recErr = recErr;
	}

	public SyntaxError(Location location, String message) {
		msg = message;
		loc = location;
	}

	public void writeTo(BufferedWriter err) throws IOException {
		err.write("Syntax Error: ");
		if(loc != null){
			err.write("("+loc.toString()+") ");
		}
		if(msg != null){
			err.write(msg);
		}
		if(recErr != null){
			Vocabulary v = recErr.getRecognizer().getVocabulary();
			err.write("unexpected token {"+recErr.getOffendingToken().getText()+"}, expected one of "+recErr.getExpectedTokens().toString(v)+".");			
		}
		err.write("\n\n");
		err.flush();
		
	}
	
	

}
