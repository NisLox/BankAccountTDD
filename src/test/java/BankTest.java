import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;

public class BankTest {

    @Test
    public void openAccount() {
        //Given
        Account account = new Account("Will", AccountType.SAVING, 0.0);
        Bank bank = new Bank();
        bank.addAccount(account);
        Assert.assertEquals("Check Will has been added", "Will", bank.getList().get(0).getName());
    }

    @Test
    public void closeAccount() {
        Account account = new Account("Will", AccountType.SAVING, 0.0);
        Bank bank = new Bank();
        bank.addAccount(account);
        bank.closeAccount(account);
        Assert.assertThat("Check Account has been removed", bank.getList(), hasSize(0));
    }
}
