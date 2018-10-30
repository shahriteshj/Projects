package test.com.ca.logic;

import com.ca.entity.Account;
import com.ca.exception.NoSufficientFundException;
import com.ca.logic.AccountService;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * AccountService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 30, 2018</pre>
 */
public class AccountServiceTest {
    AccountService service = null;

    @Before
    public void before(){
        service = new AccountService();
        Map<Integer, Account> accounts = new HashMap<>();
        accounts.put(1001, new Account("Abhishek", 12300.2));
        accounts.put(1002, new Account("Amitabh", 340080.12));
        accounts.put(1003, new Account("Jaya", 123000));
        service.setData(accounts);
    }

    @After
    public void after(){
        service = null;
    }

    /**
     * Method: findAccount(int accountNo)
     */
    @Test(expected = RuntimeException.class)
    public void testFindAccount(){
        Account acc = service.findAccount(1004);
    }

    /**
     * Method: withdraw(int accountNo, double amount)
     */
    @Test(expected = NoSufficientFundException.class)
    public void testWithdraw() {
        service.withdraw(1001, 100000);
    }

    /**
     * Method: deposit(int accountNo, double amount)
     */
    @Test(expected = RuntimeException.class)
    public void testDepositInvalidAccount(){
        service.deposit(1,1000);
    }

    /**
     * Method: deposit(int accountNo, double amount)
     */
    @Test
    public void testDeposit(){
        double beforeAmt = service.findAccount(1001).getAmount();
        service.deposit(1001,1000);
        assertEquals(beforeAmt+1000,service.findAccount(1001).getAmount(),0);

    }
}
