import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accountList = new ArrayList<Account>();
    private final List<Person> personList = new ArrayList<Person>();


    public void addAccount(Person person, Account account) {
        person.addAccount(account);
        accountList.add(account);
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void closeAccount(Person person, Account account) {
        accountList.remove(account);
        person.getList().remove(account);
    }

    public void addUser(Person person) {
        personList.add(person);
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
