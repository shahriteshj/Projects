package com.jp.hr.exceptions;

public class HrException extends Exception {

	private static final long serialVersionUID = 1L;

	public HrException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public HrException(String arg0) {
		super(arg0);

	}

}
