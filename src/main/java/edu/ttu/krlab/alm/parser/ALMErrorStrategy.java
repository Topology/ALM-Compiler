package edu.ttu.krlab.alm.parser;

import org.antlr.v4.runtime.ANTLRErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

public class ALMErrorStrategy implements ANTLRErrorStrategy {

	private ANTLRErrorStrategy aes;
	
	public ALMErrorStrategy(ANTLRErrorStrategy antlrErrorStrat) {
		this.aes = antlrErrorStrat;
	}

	@Override
	public boolean inErrorRecoveryMode(Parser arg0) {

		System.out.println("inErrorRecoveryMode");
		return aes.inErrorRecoveryMode(arg0);
	}

	@Override
	public void recover(Parser arg0, RecognitionException arg1) throws RecognitionException {
		System.out.println("recover: "+arg1);
		aes.recover(arg0, arg1);

	}

	@Override
	public Token recoverInline(Parser arg0) throws RecognitionException {
		System.out.println("recoverInLine");
		return aes.recoverInline(arg0);
	}

	@Override
	public void reportError(Parser arg0, RecognitionException arg1) {
		System.out.println("reportError: "+arg1);
		aes.reportError(arg0, arg1);

	}

	@Override
	public void reportMatch(Parser arg0) {
		System.out.println("reportMatch");
		aes.reportMatch(arg0);

	}

	@Override
	public void reset(Parser arg0) {
		System.out.println("reset");
		aes.reset(arg0);

	}

	@Override
	public void sync(Parser arg0) throws RecognitionException {
		aes.sync(arg0);

	}

}
