package com.ca.app;

import com.ca.logic.exceptions.InvalidDDurationException;
import com.ca.logic.exceptions.InvalidPrincipalException;
import com.ca.logic.exceptions.InvalidRateException;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int k = 100 / 2;
            int data[] = new int[1];
            data[1] = k;
            System.out.println("Answer: " + k);
        } catch (ArithmeticException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid index " + ex.getMessage());
        } finally {
            System.out.println("In Finally Block");
        }
        System.out.println("End of Main");

        try {
            calc(230, 13.5, 36);
        } catch (Exception ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }
    }

    static void calc(double p, double r, int d) throws InvalidDDurationException, InvalidPrincipalException, InvalidRateException {
        if ( p < InvalidPrincipalException.MIN_PRINCIPAL || p > InvalidPrincipalException.MAX_PRINCIPAL )
            throw new InvalidPrincipalException();
        if ( r < InvalidRateException.MIN_RATE || r > InvalidRateException.MAX_RATE )
            throw new InvalidRateException();
        if ( d < InvalidDDurationException.MIN_DURATION || d > InvalidDDurationException.MAX_DURATION )
            throw new InvalidDDurationException();

        double interest = p * r / 100 * d / 12;
        System.out.println("Interest: " + interest);
    }
}
