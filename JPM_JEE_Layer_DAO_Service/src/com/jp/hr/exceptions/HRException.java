package com.jp.hr.exceptions;

public class HRException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HRException(String message, Throwable cause) {
		super(message, cause);
	}

	public HRException(String message) {
		super(message);
	}

}
