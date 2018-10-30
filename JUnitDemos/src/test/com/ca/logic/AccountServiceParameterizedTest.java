package test.com.ca.logic;

import com.ca.entity.Account;
import com.ca.logic.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class AccountServiceParameterizedTest {
    Integer acctNo;
    Double withdrawalAmount;
    Double expectedOutput;

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


    public AccountServiceParameterizedTest(Integer acctNo, Double withDrawalAmount, Double expectedOutput) {
        this.acctNo = acctNo;
        this.withdrawalAmount = withDrawalAmount;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection params() {

        List data = new ArrayList();
        data.add(new Object[]{1001, 100D, 12200.2D});
        data.add(new Object[]{1002, 40080D, 300000.12D});
        data.add(new Object[]{1003, 1000000D, 122000D});

        return data;
    }

    @Test
    public void testWithdraw(){
        service.withdraw(acctNo,withdrawalAmount);
        assertEquals(expectedOutput,service.findAccount(acctNo).getAmount() ,0.0);
    }
}
