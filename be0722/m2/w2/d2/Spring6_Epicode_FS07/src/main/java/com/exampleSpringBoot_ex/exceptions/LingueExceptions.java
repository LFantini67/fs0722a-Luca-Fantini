package com.exampleSpringBoot_ex.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class LingueExceptions extends ResponseEntityExceptionHandler{

	@ExceptionHandler(LinguaException.class)
	public ResponseEntity<String> catchexc(LinguaException e){
		return new ResponseEntity<String>("Lingua Errata", HttpStatus.BAD_REQUEST);
	}
}
