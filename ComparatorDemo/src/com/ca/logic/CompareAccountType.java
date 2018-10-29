package com.ca.logic;

import java.util.Comparator;

public class CompareAccountType implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getAccountType().compareTo(o2.getAccountType());
    }
}
