package com.ca.app;

import com.ca.logic.CurrentAccount;
import com.ca.logic.SavingsAccount;
import com.ca.logic.Transaction;

public class TransactionMain {
    public static void main(String[] args) {

        SavingsAccount sa1 = new SavingsAccount("SA123456", "Customer 1", 5000.0);
        SavingsAccount sa2 = new SavingsAccount("SA123477", "Customer 2", 5000.0);
        CurrentAccount ca1 = new CurrentAccount("CA123489", "Customer 3", 5000.0);
        CurrentAccount ca2 = new CurrentAccount("CA123499", "Customer 4", 5000.0);
        Transaction tran = new Transaction();

        sa1.displayBalance();
        sa2.displayBalance();

        tran.Transfer(sa1, sa2, 500.0);

        sa1.displayBalance();
        sa2.displayBalance();

    }
}
