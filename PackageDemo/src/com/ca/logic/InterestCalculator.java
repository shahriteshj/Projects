package com.ca.logic;

public class InterestCalculator {

    protected Float principal;
    protected Float rate;
    protected Integer noOfDays;


    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    public Float getPrincipal() {
        return principal;
    }

    public void setPrincipal(Float principal) {
        this.principal = principal;
    }

    public InterestCalculator() {
    }

    public InterestCalculator(Float principal, Float rate, Integer noOfDays) {
        this.principal = principal;
        this.rate = rate;
        this.noOfDays = noOfDays;
    }

    public Double calculate() {
        return (double) (principal * (rate / 100) * (float) (noOfDays / 365));

    }

}
