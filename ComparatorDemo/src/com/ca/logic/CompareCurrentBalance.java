package com.ca.logic;

import java.util.Comparator;

public class CompareCurrentBalance implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        Double d = o1.getCurrentBalance() - o2.getCurrentBalance();
        if ( d > 0 ) {
            return 1;
        } else if ( d < 0 ) {
            return -1;
        } else {
            return 0;
        }

    }
}
