import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class PersonTest {

    private Person will;
    private Bank bank;

    @Before
    public void before() {
        will = new Person("Will", 23, "Stevenage", "07765680945");
        bank = new Bank();
    }

    @Test
    public void checkAccountOpensForUser() {
        //Given
        bank.addUser(will);
        Account account = new Account("Will_Saving", AccountType.SAVING, 0.0);
        bank.addAccount(will, account);
        assertEquals("Check Will has been added to his own info", "Will_Saving",
                will.getList().get(0).getName());
    }

    @Test
    public void closeAccountForUser() {
        bank.addUser(will);
        Account account = new Account("Will", AccountType.SAVING, 0.0);
        bank.addAccount(will, account);
        bank.closeAccount(will, account);
        Assert.assertThat("Check account has been removed from user", will.getList(), hasSize(0));
    }

    @Test
    public void createAccount() {
        will.createAccount("Wills_Casual", AccountType.CASUAL, 125.0, bank, will);
        assertEquals("Check Will has been added to his own info", "Wills_Casual",
                will.getList().get(0).getName());
    }

    @Test
    public void testGetLocation() throws Exception {
        Field field = will.getClass().getDeclaredField("location");
        field.setAccessible(true);
        field.set(will, "newLocation");
        String result = will.getLocation();
        assertEquals("Field wasn't retrieved properly", "newLocation", result);
    }

    @Test
    public void testGetNumber() throws Exception {
        Field field = will.getClass().getDeclaredField("number");
        field.setAccessible(true);
        field.set(will, "000000000");
        String result = will.getNumber();
        assertEquals("Field wasn't retrieved properly", "000000000", result);
    }

    @Test
    public void testGetAge() throws Exception {
        Field field = will.getClass().getDeclaredField("age");
        field.setAccessible(true);
        field.set(will, 12);
        int result = will.getAge();
        assertEquals("Field wasn't retrieved properly", 12, result);
    }


}
