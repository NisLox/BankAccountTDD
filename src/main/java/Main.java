public class Main {

    public static void main(String... args) {

        Bank bank = new Bank();
        Person will = new Person("Will", 23, "Stevenage", "01438723702");
        Person john = new Person("John", 27, "London", "01421357856");
        Account willsAccount = will
                .createAccount("Wills_Casual", AccountType.CASUAL, 125.0, bank, will);
        Account johnsAccount = john
                .createAccount("John_Saving", AccountType.SAVING, 5000.0, bank, john);

        System.out.println(willsAccount.checkBalance());
        System.out.println(johnsAccount.checkBalance());
        willsAccount.deposit(75.0);
        willsAccount.transfer(johnsAccount, 50);
        System.out.println(willsAccount.checkBalance());
        System.out.println(johnsAccount.checkBalance());
        willsAccount.addInterest();
        System.out.println(willsAccount.checkBalance());
        System.out.println(willsAccount.getAccountType());
        willsAccount.changeAccountType(AccountType.SAVING);
        System.out.println(willsAccount.getAccountType());


    }

}
