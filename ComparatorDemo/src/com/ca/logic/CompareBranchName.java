package com.ca.logic;

import java.util.Comparator;

public class CompareBranchName implements Comparator<Account> {


    @Override
    public int compare(Account o1, Account o2) {
        return o1.getBranchName().compareTo(o2.getBranchName());
    }
}
