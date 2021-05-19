package com.bridgelabz.employeepayroll.dto;

public class ResponseDTO {

	private String message;
	private Object data;
	
	public ResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Object getData() {
		return data;
	}
	
}
