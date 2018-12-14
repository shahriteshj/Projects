package com.jp.complaint.exceptions;

/*
 * Class to handle Custom Exception 
 * 
 */

public class ComplaintException extends Exception {

	private static final long serialVersionUID = 1L;

	public ComplaintException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public ComplaintException(String arg0) {
		super(arg0);

	}

}
