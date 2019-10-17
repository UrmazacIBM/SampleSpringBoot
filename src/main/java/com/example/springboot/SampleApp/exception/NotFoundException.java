package com.example.springboot.SampleApp.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2671295030318159853L;

	public NotFoundException(String message) {
		super(message);
	}
}
