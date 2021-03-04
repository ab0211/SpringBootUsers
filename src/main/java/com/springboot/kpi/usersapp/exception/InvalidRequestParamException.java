package com.springboot.kpi.usersapp.exception;

public class InvalidRequestParamException extends RuntimeException {
	
	public InvalidRequestParamException(String message) {
		super(message);
	}
}
