package com.example.springboot.SampleApp.controller.advice;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.springboot.SampleApp.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private ResponseEntity<?> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(message, httpStatus);
	}

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> handleNotFound(NotFoundException e) {
		return error(e, HttpStatus.NOT_FOUND, e.toString());
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> generalHandler(Exception e) {
		return error(e, HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
	}

}
