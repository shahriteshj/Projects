package com.jp.ba.dao;

import com.jp.ba.entity.Customer;
import com.jp.ba.exception.AccountException;

public interface IAccountDao {
	
	public Integer createAccount(Customer customer) throws AccountException;
	
	public boolean withDraw(Long accountId,Float amount) throws AccountException;
	
	public Float checkBalance(Long accountId) throws AccountException;
	
	public void beginTransaction();
	
	public void commitTransaction();

}
