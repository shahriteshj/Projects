package com.ca.logic;

import java.util.Comparator;

public class CompareAccHolderName implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getAccHolderName().compareTo(o2.getAccHolderName());
    }
}
