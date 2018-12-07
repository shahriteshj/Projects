package com.jp.ba.service;

import com.jp.ba.dao.AccountDao;
import com.jp.ba.dao.IAccountDao;
import com.jp.ba.entity.Customer;
import com.jp.ba.exception.AccountException;

public class AccountService implements IAccountService {

	private IAccountDao accountDao;
	
	public AccountService() {
		accountDao = new AccountDao();
	}

	@Override
	public Integer createAccount(Customer customer) throws AccountException {
		accountDao.beginTransaction();
		Integer iAcct = accountDao.createAccount(customer);
		accountDao.commitTransaction();
		return iAcct;
	}

	@Override
	public Float checkBalance(Long accountId) throws AccountException {
		return accountDao.checkBalance(accountId);
	}

	@Override
	public boolean withDraw(Long accountId, Float amount) throws AccountException {
		return accountDao.withDraw(accountId,amount);
	}

}
