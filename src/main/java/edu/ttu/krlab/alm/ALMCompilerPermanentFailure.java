package edu.ttu.krlab.alm;

public class ALMCompilerPermanentFailure extends RuntimeException {

	private String phase;
	private String error;
		
	
	public ALMCompilerPermanentFailure(String phase, String error) {
		this.phase = phase;
		this.error = error;
	}
	
	@Override
	public String getMessage(){
		return "PROGRAM FAILURE: [" + phase + "] "+error;

	}

}
