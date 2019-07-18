import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;

public class BankTest {

    Person will;
    Bank bank;


    @Before
    public void createUser() {
        will = new Person("Will", 23, "Stevenage", "07765680945");
        bank = new Bank();
    }

    @Test
    public void addUserToBank() {
        bank.addUser(will);
        Assert.assertEquals("Check Will has been added", "Will",
                bank.getPersonList().get(0).getName());
    }

    @Test
    public void checkAccountOpensForBank() {
        //Given
        bank.addUser(will);
        Account account = new Account("Will_Saving", AccountType.SAVING, 0.0);
        bank.addAccount(will, account);
        Assert.assertEquals("Check Will has been added", "Will_Saving",
                bank.getAccountList().get(0).getName());
    }

    @Test
    public void closeAccountForUser() {
        bank.addUser(will);
        Account account = new Account("Will", AccountType.SAVING, 0.0);
        bank.addAccount(will, account);
        bank.closeAccount(will, account);
        Assert.assertThat("Check Account has been removed", bank.getAccountList(), hasSize(0)); }
}



