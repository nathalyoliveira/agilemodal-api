package br.com.fiap.agilemodalapi.exception;

public class AgileModalError {
	
	private String error;
	private String message;
	
	public AgileModalError(String error, String message) {
	    this.error = error;
	    this.message = message;
	}
	
	public String getError() {
	    return error;
	}
	
	public String getMessage() {
	    return message;
	}
}