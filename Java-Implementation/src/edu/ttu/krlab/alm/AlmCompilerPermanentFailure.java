package edu.ttu.krlab.alm;

public class AlmCompilerPermanentFailure extends RuntimeException {

	private String phase;
	private String error;
		
	
	public AlmCompilerPermanentFailure(String phase, String error) {
		this.phase = phase;
		this.error = error;
	}
	
	@Override
	public String getMessage(){
		return "PROGRAM FAILURE: [" + phase + "] "+error;

	}

}
