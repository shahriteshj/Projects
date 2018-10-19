package com.ca.logic;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNo, String customerName, Double balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
    }

    @Override
    public void depositAmount(Double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawAmount(Double amount) {
        if ( this.balance > amount ) {
            this.balance -= amount;
        }
    }

    public void displayBalance() {
        System.out.println(customerName + " with Account No. " + accountNo + " has balance of " + balance);
    }

    public Boolean checkSufficientBalance(Double amount) {
        return this.balance > amount;
    }

}
