package com.jlab.customermanagement.controller.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.jlab.customermanagement.exceptions.CustomerNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {
		
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		return new ResponseEntity<Object>(new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(HttpMessageNotReadableException.class)

	public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {

		return new ResponseEntity<Object>(new ApiError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage(), "Bad Request"),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> customerNotFoundHandler(CustomerNotFoundException ex) {
		return new ResponseEntity<Object>( new ApiError(HttpStatus.BAD_REQUEST, "Not Found", ex.getMessage() ), HttpStatus.NOT_FOUND);
	}
}
