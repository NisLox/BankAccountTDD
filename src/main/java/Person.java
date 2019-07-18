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
