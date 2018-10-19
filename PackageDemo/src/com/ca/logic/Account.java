package com.ca.logic;

public abstract class Account {
    protected String accountNo;
    protected String customerName;
    protected Double balance;


    public abstract void depositAmount(Double amount);
    public abstract void withdrawAmount(Double amount);
    public abstract Boolean checkSufficientBalance(Double amount);
}
