package edu.ttu.krlab.alm.parser;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import edu.ttu.krlab.alm.datastruct.Location;
import edu.ttu.krlab.alm.datastruct.err.ErrorReport;

public class ALMSyntaxErrorListener implements ANTLRErrorListener {

	private ErrorReport er;
	
	public ALMSyntaxErrorListener(ErrorReport er) {
		this.er = er;
	}

	@Override
	public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3, boolean arg4, BitSet arg5,
			ATNConfigSet arg6) {
		// TODO Auto-generated method stub
		//System.out.println("reportAmbiguity");

	}

	@Override
	public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2, int arg3, BitSet arg4, ATNConfigSet arg5) {
		// TODO Auto-generated method stub
		//System.out.println("reportAttemptingFullContext");

	}

	@Override
	public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2, int arg3, int arg4, ATNConfigSet arg5) {
		// TODO Auto-generated method stub
		//System.out.println("reportContextSensitivity");

	}

	@Override
	public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
			RecognitionException arg5) {
		//System.out.println("syntaxError");
		if(arg5 != null)
			er.newSyntaxError(arg5);
		else if (arg1 != null){
			er.newSyntaxError(new Location((Token)arg1), arg4);
		} else {
			er.newSyntaxError(new Location( new DummyToken(arg2, arg3)), arg4);
		}

	}

}
