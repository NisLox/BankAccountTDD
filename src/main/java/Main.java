import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

//    public static void main(String... args) {
//
//        Bank bank = new Bank();
//        Person will = new Person("Will", 23, "Stevenage", "01438723702");
//        Person john = new Person("John", 27, "London", "01421357856");
//        Account willsAccount = will
//                .createAccount("Wills_Casual", AccountType.CASUAL, 125.0, bank, will);
//        Account johnsAccount = john
//                .createAccount("John_Saving", AccountType.SAVING, 5000.0, bank, john);
//
//        System.out.println(willsAccount.checkBalance());
//        System.out.println(johnsAccount.checkBalance());
//        willsAccount.deposit(75.0);
//        willsAccount.transfer(johnsAccount, 50);
//        System.out.println(willsAccount.checkBalance());
//        System.out.println(johnsAccount.checkBalance());
//        willsAccount.addInterest();
//        System.out.println(willsAccount.checkBalance());
//        System.out.println(willsAccount.getAccountType());
//        willsAccount.changeAccountType(AccountType.SAVING);
//        System.out.println(willsAccount.getAccountType());
//
//
//    }


    @Override
    public void start(Stage stage) throws Exception {
        Bank bank = new Bank();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        // Create a controller instance
        FXMLController controller = new FXMLController(bank);
        // Set it in the FXMLLoader
        loader.setController(controller);
        GridPane flowPane = loader.load();
        Scene scene = new Scene(flowPane, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

}
