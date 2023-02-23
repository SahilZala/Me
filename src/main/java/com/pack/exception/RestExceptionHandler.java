package com.pack.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pack.model.StatusModel;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
		
	@ExceptionHandler({DuplicateUserException.class,
		UserNotFoundException.class,
		InternalAuthenticationServiceException.class,RuntimeException.class})
	public ResponseEntity<StatusModel> handleUserRelatedFoundException(
			Exception ex,
			WebRequest request){
		
		return new ResponseEntity<>(new StatusModel(
				LocalDateTime.now().toString(),HttpStatus.FORBIDDEN,ex.getMessage()
				,request.getContextPath().toString(),"no data"),HttpStatus.FORBIDDEN);
		
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		List<FieldError>  errList=ex.getBindingResult().getFieldErrors(); 
		
		for (FieldError error :  errList) {
		
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		
		}
		
		
	
		return new ResponseEntity<>(new StatusModel(LocalDateTime.now().toString(),
				HttpStatus.BAD_REQUEST,errors.get(0),"","no data"),HttpStatus.BAD_REQUEST);
	}

}
