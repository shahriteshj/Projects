/**
 * SalaryCalculator
 *
 * @author Ritesh Shah
 * @version 1.0
 * @since <pre>10/31/2018</pre>
 */

package com.ca.logic;

public class SalaryCalculator {
    private static final double TAX_FREE = 0;

    public double calcTax(double salary, double taxRate) {
        double taxableSal = salary - TAX_FREE;
        if ( taxableSal > 0 )
            return taxableSal * taxRate;
        else return 0;
    }

}
