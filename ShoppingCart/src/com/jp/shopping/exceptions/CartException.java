package com.jp.shopping.exceptions;

public class CartException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartException(String message, Throwable cause) {
		super(message, cause);
	}

	public CartException(String message) {
		super(message);
	}

}
