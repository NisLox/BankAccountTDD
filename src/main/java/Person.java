import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private final int age;
    private final String location;
    private final String number;
    private final List<Account> list = new ArrayList<Account>();


    public Person(String name, int age, String location, String number) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.number = number;
    }

    public Account createAccount(String accountName, AccountType accountType, double balance,
            Bank bank, Person will) {
        Account account = new Account(accountName, accountType, balance);
        bank.addAccount(will,account);
        addAccount(account);
        return account;
    }

    public void addAccount(Account account) {
        list.add(account);
    }

    public List<Account> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getNumber() {
        return number;
    }


}
