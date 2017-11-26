package gov.nasa.mars.enums;

public enum ErrorMessage {
	
	BAD_REQUEST("400 Bad Request");
	
	private ErrorMessage(String message) {
		this.message = message;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}	

}
