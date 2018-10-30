package test.com.ca.logic;

import com.ca.logic.AccountService;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AccountServiceTest.class, AccountServiceParameterizedTest.class})
public class MySuite {
}
