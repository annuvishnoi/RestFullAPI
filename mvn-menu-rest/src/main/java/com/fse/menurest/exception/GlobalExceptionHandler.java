package com.fse.menurest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fse.menurest.entity.BookErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<BookErrorResponse> handleException(BookException ex){
		BookErrorResponse errResponse=new BookErrorResponse(
												HttpStatus.BAD_REQUEST.value(),
												ex.getMessage(),
												System.currentTimeMillis());
		return new ResponseEntity<>(errResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException ex){
		BookErrorResponse errResponse=new BookErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												ex.getMessage(),
												System.currentTimeMillis());
		return new ResponseEntity<>(errResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<BookErrorResponse> handleException(Exception ex){
		BookErrorResponse errResponse=new BookErrorResponse(
												HttpStatus.BAD_REQUEST.value(),
												ex.getMessage(),
												System.currentTimeMillis());
		return new ResponseEntity<>(errResponse,HttpStatus.BAD_REQUEST);
	}
}
