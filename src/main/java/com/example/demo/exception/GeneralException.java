package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private Integer status = 400;
	private String detailMessage;
	private Object data;
	
	public GeneralException(String message, Integer status, String detailMessage, Object data) {
		super(message);
		this.status = status;
		this.detailMessage = detailMessage;
		this.data = data;
	}
	
	public GeneralException(String message, Integer status) {
		super(message);
		this.status = status;
	}
	
	public GeneralException(String message) {
		super(message);
	}
	
}
