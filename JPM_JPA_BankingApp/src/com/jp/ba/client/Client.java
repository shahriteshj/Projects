package com.jp.ba.client;

import java.util.HashSet;
import java.util.Set;

import com.jp.ba.entity.Account;
import com.jp.ba.entity.CurrentAccount;
import com.jp.ba.entity.Customer;
import com.jp.ba.entity.SavingAccount;
import com.jp.ba.exception.AccountException;
import com.jp.ba.service.AccountService;
import com.jp.ba.service.IAccountService;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws AccountException {

		//Set 1*********************************
		Customer c = new Customer();
		c.setCustomerName("ABCD");
		c.setEmail("a@a.com");
		c.setPhone("123-456-789");
		c.setAddress("Address");
		
		SavingAccount savingsAcct = new SavingAccount();
		savingsAcct.setBalance(5000.99F);
		savingsAcct.setRateOfInterest(10.5f);
		savingsAcct.setCustomer(c);

		Set<Account> accounts = new HashSet<Account>();
		accounts.add(savingsAcct);
	
		c.setAccounts(accounts);

		//*************************************************************

		//Set 2*********************************
		CurrentAccount currentAcct = new CurrentAccount();
		currentAcct.setBalance(5000.99F);
		currentAcct.setOverDraftLimit(2500.00f);
		currentAcct.setCustomer(c);
		

		
		IAccountService service = new AccountService();
		service.createAccount(c);
		
		System.out.println(service.checkBalance(1L));

	}

}
