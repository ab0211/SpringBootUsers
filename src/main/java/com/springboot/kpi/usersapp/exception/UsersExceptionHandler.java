package com.springboot.kpi.usersapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<UsersErrorResponse> handleException(UserNotFoundException exc){
		UsersErrorResponse error=new UsersErrorResponse();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage("Exception Caught: "+exc.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<UsersErrorResponse> handleException(InvalidRequestParamException exc){
		UsersErrorResponse error=new UsersErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage("Exception Caught: "+exc.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<UsersErrorResponse> handleException(Exception exc){
		UsersErrorResponse error=new UsersErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage("Exception Caught: "+exc.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
