package com.jp.shopping.exceptions;

public class ShoppingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShoppingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShoppingException(String message) {
		super(message);
	}

}
