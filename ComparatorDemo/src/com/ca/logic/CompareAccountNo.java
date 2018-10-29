package com.ca.logic;

import java.util.Comparator;

public class CompareAccountNo implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getAccountNo()-o2.getAccountNo();
    }
}
