package edu.ttu.krlab.alm.datastruct.err;

public class ErrorMetaDataBase implements ErrorMetaData {

	private String errorID;
	private String message;
	private String explanation;
	private String recommendation;
	
	public ErrorMetaDataBase(String eID, String msg, String exp, String rec){
		this.errorID = eID;
		this.message = msg;
		this.explanation = exp;
		this.recommendation = rec;
	}
	
	@Override
	public String getErrorID() {
		return errorID;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getExplanation() {
		return explanation;
	}

	@Override
	public String getRecommendation() {
		return recommendation;
	}

}
