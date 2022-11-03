package com.example.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.demo.annotations.validator.IsNumberValidator;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsNumberValidator.class)
public @interface IsNumber {
	String message() default "Id is invalid";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
