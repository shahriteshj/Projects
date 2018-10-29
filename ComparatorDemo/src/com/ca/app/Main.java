package com.ca.app;

import com.ca.logic.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Account> acctList = new ArrayList<>();
        acctList.add(new Account(1, "Saving", "John", "Mumbai", 100.5));
        acctList.add(new Account(4, "Current", "Smith", "Delhi", 100.4));
        acctList.add(new Account(3, "Loan", "James", "Chennai", 100.2));
        acctList.add(new Account(2, "Saving", "Steve", "Goa", 100.1));
        acctList.add(new Account(7, "Current", "Brian", "Patna", 100.9));

        while (true) {

            displayMenu();
            String value = scan.next();

            switch (value) {
                case "1":
                    acctList.sort(new CompareAccountNo());
                    displayAccounts(acctList);
                    break;
                case "2":
                    acctList.sort(new CompareAccountType());
                    displayAccounts(acctList);
                    break;
                case "3":
                    acctList.sort(new CompareAccHolderName());
                    displayAccounts(acctList);
                    break;
                case "4":
                    acctList.sort(new CompareBranchName());
                    displayAccounts(acctList);
                    break;
                case "5":
                    acctList.sort(new CompareCurrentBalance());
                    displayAccounts(acctList);
                    break;
                case "6":
                    //Exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid number mentioned in the Display Menu");
            }

        }
    }

    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Sort Account by Account Number ");
        System.out.println("2. Sort Account by Account Type");
        System.out.println("3. Sort Account by Account Holder Name");
        System.out.println("4. Sort Account by Branch Name");
        System.out.println("5. Sort Account by Current Balance");
        System.out.println("6. Exit");
        System.out.println("Enter the Number to select Action!");
    }

    private static void displayAccounts(ArrayList<Account> acctList) {
        for (Account acct : acctList) {
            System.out.println(acct.toString());
        }
    }
}
