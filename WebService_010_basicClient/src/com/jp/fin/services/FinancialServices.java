package com.jp.fin.services;

import javax.jws.WebMethod;

import com.jp.fin.exceptions.FinException;

public interface FinancialServices  {

	@WebMethod
	public int getEmpCount() throws FinException;
	
}
