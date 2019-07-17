import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private final List<Account> list = new ArrayList<Account>();


    public void addAccount(Account account) {
        list.add(account);
    }

    public List<Account> getList() {
        return Collections.unmodifiableList(list);
    }

    public void closeAccount(Account account) {
        list.remove(account);
    }
}
