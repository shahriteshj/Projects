package com.ca.logic;

public class Account {

    private Integer accountNo;
    private String accountType;
    private String accHolderName;
    private String branchName;
    private Double currentBalance;


    public Account(Integer accountNo, String accountType, String accHolderName, String branchName, Double currentBalance) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.accHolderName = accHolderName;
        this.branchName = branchName;
        this.currentBalance = currentBalance;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", accountType='" + accountType + '\'' +
                ", accHolderName='" + accHolderName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
