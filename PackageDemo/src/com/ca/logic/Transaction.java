package com.ca.logic;

public class Transaction {
    public void Transfer(Account fromAcc, Account toAcc, Double amount){
        if(fromAcc.checkSufficientBalance(amount)) {
            fromAcc.withdrawAmount(amount);
            toAcc.depositAmount(amount);
            System.out.println("Fund transfer from account "+ fromAcc.accountNo + " to account "+ toAcc.accountNo +
                    " is successful");
        }
        else{
            System.out.println("Insufficient Balance in "+ fromAcc.accountNo);
        }
    }

    public void PayBill(Account fromAcc, String billerName, Double amount){
        if(fromAcc.checkSufficientBalance(amount)) {
            fromAcc.withdrawAmount(amount);
            System.out.println("Bill Payment from account "+ fromAcc.accountNo + " to Biller "+ billerName +
                    " is successful");
        }
        else{
            System.out.println("Insufficient Balance in "+ fromAcc.accountNo);
        }
    }
}
