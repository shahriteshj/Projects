package com.ca.logic;

public class SavingsAccount extends Account{
    @Override
    public void depositAmount(Double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawAmount(Double amount) {
        if(this.balance>amount ){
            this.balance-=amount;
        }

    }
}
