package com.study.exception;

@SuppressWarnings("serial")
public class AmountNotSufficentException extends RuntimeException {

	public AmountNotSufficentException(String message) {
		super(message);
	}

}
