package com.arya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.arya.error.ApiError;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = NoProductFoundException.class)
	public ResponseEntity<ApiError> handleNoProductFoundException() {
		ApiError error= new ApiError(400, "product not found");
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}

}
