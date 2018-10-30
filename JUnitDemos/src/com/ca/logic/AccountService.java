package com.ca.logic;

import com.ca.entity.Account;
import com.ca.exception.NoSufficientFundException;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<Integer, Account> accounts = new HashMap<Integer,Account>();

    public AccountService(){

    }

    public void setData(Map<Integer,Account> accounts){
        this.accounts=accounts;
    }

    public Account findAccount(int accountNo){
        if(accounts.containsKey(accountNo)){
            return accounts.get(accountNo);
        }
        else throw new RuntimeException("Account No "+accountNo+" does not exists!");
    }

    public void withdraw(int accountNo, double amount) throws NoSufficientFundException {
        Account acc = accounts.get(accountNo);
        if(acc.getAmount()<amount)
            throw new NoSufficientFundException(accountNo);
        else
            acc.setAmount( acc.getAmount()-amount );
    }

    public void deposit(int accountNo, double amount){
        Account acc = findAccount(accountNo);
        acc.setAmount(acc.getAmount()+amount);
    }
}
