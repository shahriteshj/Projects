package com.jp.ba.dao;

import javax.persistence.EntityManager;

import com.jp.ba.entity.Account;
import com.jp.ba.entity.Customer;
import com.jp.ba.exception.AccountException;
import com.jp.ba.utility.JPAUtil;

public class AccountDao implements IAccountDao {

	private EntityManager em;

	public AccountDao() {
		em = JPAUtil.getEntityManager();

	}

	@Override
	public Integer createAccount(Customer customer) throws AccountException {
		em.persist(customer);
		Customer cust = em.find(Customer.class, customer.getCustomerId());
		if (cust.getCustomerId() == customer.getCustomerId()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean withDraw(Long accountId, Float amount) throws AccountException {
		boolean isSuccess=false;
		Account acc = em.find(Account.class, accountId);
		Float balance =acc.getBalance();
		if(balance < amount){
			isSuccess=false;
		}else{
			acc.setBalance(balance-amount);	
			isSuccess=true;
		}
		return isSuccess;
	}

	@Override
	public Float checkBalance(Long accountId) throws AccountException {
		Account acc = em.find(Account.class, accountId);
		return acc.getBalance();
	}

	@Override
	public void beginTransaction() {
		em.getTransaction().begin();

	}

	@Override
	public void commitTransaction() {
		em.getTransaction().commit();

	}

}
