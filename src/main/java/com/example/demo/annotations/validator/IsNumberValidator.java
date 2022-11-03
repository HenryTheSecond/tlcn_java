package com.example.demo.annotations.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.annotations.IsNumber;


public class IsNumberValidator implements ConstraintValidator<IsNumber, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			Long.parseLong(value);
			return true;
		} catch(NumberFormatException e) {}
		try {
			Integer.parseInt(value);
			return true;
		} catch(NumberFormatException e) {}
		return false;
	}

}
