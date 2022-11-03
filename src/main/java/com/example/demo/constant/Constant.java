package com.example.demo.constant;

import com.auth0.jwt.algorithms.Algorithm;

public class Constant {

	// RESPONSE CONSTANT
	public static final String SUCCESSFUL = "SUCCESSFUL";
	public static final int SUCCESSFUL_CODE = 200;
	public static final String FAILED = "FAILED";
	public static final int FAILED_CODE = 400;
	public static final String UNAUTHORIZED = "UNAUTHORIZED";
	public static final int UNAUTHORIZED_CODE = 401;
	public static final String FORBIDDEN = "FORBIDDEN";
	public static final int FORBIDDEN_CODE = 403;
	public static final String BAD_REQUEST = "BAD_REQUEST";
	public static final int BAD_REQUEST_CODE = 400;
	public static final String BAD_REQUEST_MESSAGE = "Bad request";
	public static final String NOT_FOUND = "NOT_FOUND";
	public static final int NOT_FOUND_CODE = 404;
	
	public static final String VALIDATE_ERROR = "VALIDATE_ERROR";
	
	public static final String EMAIL_OR_PASSWORD_MISSING = "Email or password missing";
	public static final String ACCOUNT_INACTIVE = "Account has not been activated";
	public static final String EMAIL_OR_PASSWORD_INCORRECT = "Email or password is incorrect";

	public static final Long JWT_ACCESS_TOKEN_EXPIRATION = 600000L; // 10 minutes in milliseconds
	public static final String JWT_SECRET = "HenryTheSecond";
	public static final Algorithm JWT_ALGORITHM = Algorithm.HMAC256(JWT_SECRET.getBytes());
	public static final String JWT_TOKEN_MISSING = "JWT_TOKEN_MISSING";
	public static final String JWT_INCORRECT = "JWT_INCORRECT";
	
	public static final String COUNTRY_AND_CITY_DIRECTORY = "src\\main\\resources\\static\\location\\country_and_city.json";
	public static final String VIETNAM_REGION = "src\\main\\resources\\static\\location\\vietnam_city_district_ward.json";
	
	//Localtion constants
	public static final String WARD_NOT_FOUND = "WARD NOT FOUND";
	public static final String CITY_NOT_FOUND = "CITY NOT FOUND";
	public static final String DISTRICT_NOT_FOUND = "DISTRICT NOT FOUND";
}
