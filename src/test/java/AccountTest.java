import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void createUser() {
        account = new Account("Will", AccountType.SAVING, 0.0);
    }

    @Test
    public void checkBalance() {
        assertEquals("Check Balance", 0.0, account.checkBalance(), 1);
    }

    @Test
    public void deposit() {
        account.deposit(50.0);
        assertEquals("Deposited 50.0", 50.5, account.checkBalance(), 1);
    }

    @Test
    public void withdraw() {
        account.deposit(50.0);
        account.withdraw(25.0);
        assertEquals("Withdrawn 25", 25.0, account.checkBalance(), 1);
    }

    @Test
    public void ifBalanceTooLowCantWithdraw() {
        account.deposit(50.0);
        account.withdraw(75.0);
        assertEquals("balance stays the same after withdraw", 50.0, account.checkBalance(), 1);
    }

    @Test
    public void transferToDifferentAccount() {
        Account john = new Account("Will", AccountType.SAVING, 0.0);
        account.deposit(50.0);
        account.transfer(john, 20.0);
        assertEquals("John has 20.0", 20.0, john.checkBalance(), 1);
        assertEquals("account has 30.0", 30.0, account.checkBalance(), 1);
    }

    @Test
    public void testSetter() throws Exception {
        account.setName("John");
        final Field field = account.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", "John", field.get(account));
    }

    @Test
    public void adding1PercentToAnyDeposits() {
        account.deposit(50.0);
        assertEquals("1% has been added", 50.50, account.checkBalance(), 1);
    }

    @Test
    public void checkAccountType() {
        assertEquals("Account types match", AccountType.SAVING, account.getAccountType());
    }

    @Test
    public void interestOnSavingAccount() {
        Account person1 = new Account("person1", AccountType.SAVING, 50.00);
        person1.addInterest();
        assertEquals("5% has been added", 52.50, person1.checkBalance(), 1);
    }

    @Test
    public void interestOnCasualAccount() {
        Account person1 = new Account("person1", AccountType.CASUAL, 50.00);
        person1.addInterest();
        assertEquals("2.5% has been added", 51.25, person1.checkBalance(), 1);

    }
}
