package edu.ttu.krlab.alm.parser;

public class PermanentTranslatorFailure extends RuntimeException {

	private String phase;
	private String error;
		
	
	public PermanentTranslatorFailure(String phase, String error) {
		this.phase = phase;
		this.error = error;
	}
	
	@Override
	public String getMessage(){
		return "PROGRAM FAILURE: [" + phase + "] "+error;

	}

}
