package test.com.ca.logic;

import com.ca.logic.SalaryCalculator;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * SalaryCalculator Tester.
 *
 * @author Ritesh Shah
 * @version 1.0
 * @since <pre>Oct 31, 2018</pre>
 */
public class SalaryCalculatorTest {
    private SalaryCalculator sc = null;

    @Before
    public void before() {
        sc = new SalaryCalculator();
    }

    @After
    public void after() {
        sc = null;
    }

    /**
     * Method: calcTax(double salary, double taxRate)
     */
    @Test
    public void testCalcTax() {
        double dtax = sc.calcTax(350000, 0.085);
        System.out.println("Input Salary: 350000");
        System.out.println("Input Tax Rate: 0.085");
        System.out.println("Calculated Tax: " + dtax);
        System.out.println("Expected Tax: 4250");

        assertEquals(4250, dtax, 0.0);
    }


} 
