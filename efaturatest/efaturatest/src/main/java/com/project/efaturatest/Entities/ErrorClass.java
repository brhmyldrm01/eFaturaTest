package com.project.efaturatest.Entities;

public class ErrorClass {

	
	
	
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


	public ErrorClass(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}



	@Override
	public String toString() {
		return "Error {code:" + code + ", message:" + message + "}";
	}
	
	
	
	
}
