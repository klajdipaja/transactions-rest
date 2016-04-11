package com.elidjongrembi.transactions.domain;

public class ResponseJson {

	private String message;
	private String details;
	
	public ResponseJson(){
		
	}
	public ResponseJson(Exception ex, String details){
		this.message = ex.getLocalizedMessage();
        this.details = details;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "ResponseJson [message=" + message + ", details=" + details + "]";
	}
}
