package com.ca.logic;

public abstract class Account {
    protected String accountNo;
    String customerName;
    Double balance;


    public abstract void depositAmount(Double amount);
    public abstract void withdrawAmount(Double amount);
}
