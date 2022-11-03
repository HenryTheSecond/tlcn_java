package com.example.demo.exception;

import java.util.HashMap;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.constant.Constant;
import com.example.demo.model.DataResponse;

@RestControllerAdvice
@ResponseStatus
public class ControllerExceptionHandler {
	
	@ExceptionHandler(GeneralException.class)
	public DataResponse generalException(GeneralException exception) {
		DataResponse response = new DataResponse();
		response.setMessage(exception.getMessage());
		
		if(exception.getStatus() != null) response.setStatus(exception.getStatus());
		
		if(exception.getDetailMessage() != null) response.setDetailMessage(exception.getDetailMessage());
		
		if(exception.getData() != null) response.setData(exception.getData());
		
		return response;
	}

	//Handle validate exception, including IsNumber Validator
	@ExceptionHandler(ConstraintViolationException.class)
	public DataResponse constraintViolation(ConstraintViolationException ex) {
		HashMap<String, String> error = new HashMap<>();
		for(ConstraintViolation violation: ex.getConstraintViolations()) {
			error.put(violation.getPropertyPath().toString(), violation.getMessage());
		}
		return new DataResponse(Constant.VALIDATE_ERROR, error, Constant.FAILED_CODE, null);
	}
}
