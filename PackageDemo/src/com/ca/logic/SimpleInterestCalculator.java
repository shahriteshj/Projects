package com.ca.logic;

public class SimpleInterestCalculator extends InterestCalculator {
    public SimpleInterestCalculator() {
    }

    public SimpleInterestCalculator(Float principal, Float rate, Integer noOfDays) {
    }

    public Double calculate() {
        return (double) (principal * (rate / 100) * (float) (noOfDays / 365));

    }
}
