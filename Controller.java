import javafx.fxml.FXML;

/**
 * This class contains all of the elements that execute the main program.
 */
public class Controller
{
    /**
     * The Controller class instance variables.
     * Contain variables accessed through FXML.
     */
    @FXML
    private javafx.scene.control.TextArea mainDisplay;
    @FXML
    private javafx.scene.control.TextField nameTextField;
    @FXML
    private javafx.scene.control.TextField telephoneTextField;
    @FXML
    private javafx.scene.control.TextField emailTextField;
    @FXML
    private javafx.scene.control.TextField addressTextField;
    @FXML
    private javafx.scene.control.TextField dobTextField;
    @FXML
    private javafx.scene.control.TextField searchInput;

    private AddressList addressList;

    /**
     * The Controller class constructor.
     * Creates a new instance of the AddressList class.
     */
    public Controller()
    {
        addressList = new AddressList();
    }

    /**
     * The addToFrontButtonControl method accesses the appropriate button in the FXML view to add a new node to
     * the AddressList to the front.
     */
    public void addToFrontButtonControl()
    {
        String name = nameTextField.getText();
        String telephone = telephoneTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String dob = dobTextField.getText();

        if (!name.equals("") && !telephone.equals("") && !email.equals("") && !address.equals("") && !dob.equals(""))
        {
            addressList.addToFront(name, telephone, email, address, dob);
            mainDisplay.setText("Data successfully added!");

            nameTextField.setText("");
            telephoneTextField.setText("");
            emailTextField.setText("");
            addressTextField.setText("");
            dobTextField.setText("");
        }
        else
        {
            mainDisplay.setText("Unable to process data. Please enter data into each field.");
        }
    }
    /**
     * The addToBackButtonControl method accesses the appropriate button in the FXML view to add a new node to
     * the AddressList to the back.
     */
    public void addToBackButtonControl()
    {
        String name = nameTextField.getText();
        String telephone = telephoneTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String dob = dobTextField.getText();

        if (!name.equals("") && !telephone.equals("") && !email.equals("") && !address.equals("") && !dob.equals(""))
        {
            addressList.addToBack(name, telephone, email, address, dob);
            mainDisplay.setText("Data successfully added!");

            nameTextField.setText("");
            telephoneTextField.setText("");
            emailTextField.setText("");
            addressTextField.setText("");
            dobTextField.setText("");
        }
        else
        {
            mainDisplay.setText("Unable to process data. Please enter data into each text field.");
        }
    }
    /**
     * The phoneByNameButtonControl method accesses the appropriate button in the FXML view to look up a phone number
     * by name.
     */
    public void phoneByNameButtonControl()
    {
        String input = searchInput.getText();

        if (!input.equals(""))
        {
            mainDisplay.setText(addressList.phoneNumberByName(input));
        }
        else
        {
            mainDisplay.setText("Unable to process your search. Please enter data into the search text field.");
        }
    }
    /**
     * The emailByNameButtonControl method accesses the appropriate button in the FXML view to look up an email
     * by name.
     */
    public void emailByNameButtonControl()
    {
        String input = searchInput.getText();

        if (!input.equals(""))
        {
            mainDisplay.setText(addressList.emailByName(input));
        }
        else
        {
            mainDisplay.setText("Unable to process your search. Please enter data into the search text field.");
        }
    }
    /**
     * The nameByPhoneButtonControl method accesses the appropriate button in the FXML view to look up a name by
     * phone number.
     */
    public void nameByPhoneButtonControl()
    {
        String input = searchInput.getText();

        if (!input.equals(""))
        {
            mainDisplay.setText(addressList.nameByPhoneNumber(input));
        }
        else
        {
            mainDisplay.setText("Unable to process your search. Please enter data into the search text field.");
        }
    }
    /**
     * The dobByNameButtonControl method accesses the appropriate button in the FXML view to look up a date of birth
     * by name.
     */
    public void dobByNameButtonControl()
    {
        String input = searchInput.getText();

        if (!input.equals(""))
        {
            mainDisplay.setText(addressList.dobByName(input));
        }
        else
        {
            mainDisplay.setText("Unable to process your search. Please enter data into the search text field.");
        }
    }
    /**
     * The printButtonControl method accesses the appropriate button in the FXML view to
     * display the entire AddressList into a single readable string.
     */
    public void printButtonControl()
    {
        mainDisplay.setText(addressList.toString());
    }
    /**
     * The reversePrintButtonControl method accesses the appropriate button in the FXML view to
     * display the entire AddressList into a single readable string in reverse.
     */
    public void reversePrintButtonControl()
    {
        mainDisplay.setText(addressList.reverseToString());
    }
    /**
     * The sizeButtonControl method accesses the appropriate button in the FXML view to
     * display the current size of the AddressList.
     */
    public void sizeButtonControl()
    {
        mainDisplay.setText("The size of the address list is " + addressList.sizeOf() + ".");
    }
    /**
     * The isEmptyButtonControl method accesses the appropriate button in the FXML view to
     * display information on if the AddressList is empty or contains data.
     */
    public void isEmptyButtonControl()
    {
        if (addressList.isEmpty())
        {
            mainDisplay.setText("The address list is empty.");
        }
        else
        {
            mainDisplay.setText("The address list contains data.");
        }
    }
    /**
     * The reverseListButtonControl method accesses the appropriate button in the FXML view to
     * replace the current AddressList with a new one that has all of the previous nodes in reverse.
     */
    public void reverseListButtonControl()
    {
        if (!addressList.isEmpty())
        {
            addressList = addressList.reverse();
            mainDisplay.setText("The address list was successfully reversed.");
        }
        else
        {
            mainDisplay.setText("Unable to reverse the list. The address list is empty.");
        }
    }
}