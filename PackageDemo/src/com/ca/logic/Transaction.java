package com.ca.logic;

public class Transaction {
    public void Transfer(Account fromAcc, Account toAcc, Double amount){
        fromAcc.withdrawAmount(amount);
        toAcc.depositAmount(amount);
    }

    public void PayBill(Account fromAcc, String billerName, Double amount){
        fromAcc.withdrawAmount(amount);
    }
}
