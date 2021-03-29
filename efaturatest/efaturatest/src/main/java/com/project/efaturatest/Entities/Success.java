package com.project.efaturatest.Entities;

public class Success {

	
	
	
	public int  code;
	public String message;
	

	
	public int getCode() {
		return code;
	}




	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Success(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	@Override
	public String toString() {
		return "Success {code:" + code + ", message:" + message + "}";
	}
	
	
	
	
}
