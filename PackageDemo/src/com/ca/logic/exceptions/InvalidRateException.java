package com.ca.logic.exceptions;

public class InvalidRateException extends Exception {
    public static final double MIN_RATE = 4;
    public static final double MAX_RATE = 25;

    public InvalidRateException() {
        super("Rate of interest must be in range " + MIN_RATE + " to " + MAX_RATE);
    }
}
