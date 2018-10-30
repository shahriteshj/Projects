package test.com.ca.logic;

import com.ca.logic.Calculator;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Calculator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 30, 2018</pre>
 */
public class CalculatorTest {
    Calculator calc = new Calculator();

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Test Suite");
    }

    @AfterClass
    public static void actionAfterClass(){
        System.out.println("After Test Suite");
    }

    @Before
    public void before() throws Exception {
        System.out.println("Before each test case");
    }

    @After
    public void after() throws Exception {
        System.out.println("After each test case");
    }

    /**
     * Method: add(double d1, double d2)
     */
    @Test
    public void testAdd() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: subtract(double d1, double d2)
     */
    @Test
    public void testSubtract() throws Exception {
//TODO: Test goes here... 
    }


    @Test
    public void addDataSet01() {
        double result = calc.add(10, 50);
        assertEquals(60.0, result, 0);
    }

    @Test
    public void addDataSet02() {
        double result = calc.add(100, 50);
        assertEquals(150, result, 0);
    }

    @Test
    public void doNothingTest() {

    }

} 
