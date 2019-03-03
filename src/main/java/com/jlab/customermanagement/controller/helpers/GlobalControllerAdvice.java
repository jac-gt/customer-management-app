package com.jlab.customermanagement.controller.helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

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

	/*
	 * @ResponseBody
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
	 * 
	 * return new ResponseEntity<Object>( new ApiError(new Date(),
	 * "Validation failed", e.getBindingResult().toString()),
	 * HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 * 
	 * @ExceptionHandler(MissingServletRequestParameterException.class) public
	 * ResponseEntity<Object> processMissingServletRequestParameterError(
	 * MissingServletRequestParameterException e) { return new
	 * ResponseEntity<Object>( new ApiError(new Date(), e.getParameterName() +
	 * " parameter is missing", e.getLocalizedMessage()), HttpStatus.BAD_REQUEST); }
	 * 
	 */

}
