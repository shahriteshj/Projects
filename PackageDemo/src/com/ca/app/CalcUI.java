package com.ca.app;

import com.ca.logic.CompoundInterestCalculator;
import com.ca.logic.InterestCalculator;

import java.util.Scanner;

public class CalcUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Principal: ");
        Float principal = scanner.nextFloat();

        System.out.println("Enter Rate: ");
        Float rate = scanner.nextFloat();

        System.out.println("Enter no of days: ");
        Integer noOfDays = scanner.nextInt();

        InterestCalculator SI = new InterestCalculator();
        SI.setNoOfDays(noOfDays);
        SI.setPrincipal(principal);
        SI.setRate(rate);
        System.out.println(SI.calculate());

        CompoundInterestCalculator CI = new CompoundInterestCalculator();
        CI.setNoOfDays(noOfDays);
        CI.setPrincipal(principal);
        CI.setRate(rate);

        System.out.println(CI.calculate());

    }
}
