package com.ca.logic.exceptions;

public class InvalidDDurationException extends Exception {
    public static final double MIN_DURATION = 12;
    public static final double MAX_DURATION = 240;

    public InvalidDDurationException() {
        super("Duration must be in range 12 to 240 months");
    }
}
