package com.ca.exception;

public class NoSufficientFundException extends RuntimeException {
    public NoSufficientFundException(int accountNo){
        super("Insufficient Balance in "+ accountNo);
    }
}
