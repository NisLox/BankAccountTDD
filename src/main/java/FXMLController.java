import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class FXMLController {

    AccountType accountType;
    Bank bank;

    public ComboBox combo;
    @FXML
    private TextField accountName;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField locate;
    @FXML
    private TextField number;

    public FXMLController(Bank bank) {
        this.bank = bank;
    }

    public FXMLController(AccountType accountType, ComboBox combo) {
        this.accountType = accountType;
        this.combo = combo;
    }

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        Person person = new Person(name.getText(), Integer.parseInt(age.getText()), locate.getText(), number.getText());
        if("Casual".equals(combo.getSelectionModel().getSelectedItem().toString())) {
            accountType = AccountType.CASUAL;
        } else if ("Saving".equals(combo.getSelectionModel().getSelectedItem().toString())) {
            accountType = AccountType.SAVING;
        }
        person.createAccount(accountName.getText(), accountType, 0.0, bank, person);
        System.out.println(person.getList().get(0).getAccountType());
    }

}