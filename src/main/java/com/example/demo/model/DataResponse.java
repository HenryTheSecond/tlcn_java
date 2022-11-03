package com.example.demo.model;

import com.example.demo.constant.Constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
	private String message;
	private Object data;
	private int status = 0;
	private String detailMessage;

	public DataResponse(Object data) {
		this.data = data;
		this.message = Constant.SUCCESSFUL;
		this.status = Constant.SUCCESSFUL_CODE;
	}

	public DataResponse(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public DataResponse(String message, int status, String detailMessage) {
		this(message, status);
		this.detailMessage = detailMessage;
	}

	public static final DataResponse SUCCESSFUL = new DataResponse(Constant.SUCCESSFUL, Constant.SUCCESSFUL_CODE);
	public static final DataResponse FAILED = new DataResponse(Constant.FAILED, Constant.FAILED_CODE);
	public static final DataResponse UNAUTHORIZED = new DataResponse(Constant.UNAUTHORIZED, Constant.UNAUTHORIZED_CODE);
	public static final DataResponse FORBIDDEN = new DataResponse(Constant.FORBIDDEN, Constant.FORBIDDEN_CODE);
	public static final DataResponse BAD_REQUEST = new DataResponse(Constant.BAD_REQUEST, Constant.BAD_REQUEST_CODE);
	public static final DataResponse NOT_FOUND = new DataResponse(Constant.NOT_FOUND, Constant.NOT_FOUND_CODE);
}
