package com.ca.logic.exceptions;

public class InvalidPrincipalException extends Exception {
    public static final double MIN_PRINCIPAL = 10000;
    public static final double MAX_PRINCIPAL = 10000000;

    public InvalidPrincipalException(){
        super("Principal amount must be in range of 10000 to 10000000");
    }
}
