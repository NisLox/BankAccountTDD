public class Account {

    private String name;
    private final AccountType accountType;
    private double balance;

    public Account(String name, AccountType accountType, double balance) {
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        double newAmount = depositWithInterest(amount) + amount;
        balance += newAmount;
    }

    private static double depositWithInterest(double amount){
       return amount / 100.0 * 1.0;
    }

    public void withdraw(double amount) {
        if (amount < balance) {
            balance -= amount;
        }
    }

    public void transfer(Account account, double amount) {
        withdraw(amount);
        account.deposit(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void addInterest() {
        double balanceDivide100 = balance / 100.0;
        if (accountType == AccountType.SAVING){
           balance += balanceDivide100 * 5.0;
        } else if (accountType == AccountType.CASUAL){
            balance += balanceDivide100 * 2.5;
        }
    }
}
