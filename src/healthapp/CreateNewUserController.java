package healthapp;

import healthapp.Core.Utility;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import listener.InputNumberValidator;

/**
 * FXML Controller class
 *
 * @author SHAMIM
 */
public class CreateNewUserController implements Initializable {

    @FXML
    private Text userIdLabel;
    @FXML
    private TextArea userId;
    @FXML
    private TextArea password;
    @FXML
    private TextField weight;
    @FXML
    private Slider heightSIdeBar;
    @FXML
    private Label centimeterLabel;
    @FXML
    private Label feetLabel;
    @FXML
    private ChoiceBox<String> sexBox;
    @FXML
    private DatePicker birthdayPicker;
    String[] choice={"Male","Female"};
    int sliderValue;
    @FXML
    private Button saveButton;
    @FXML
    private Text userIdLabel1;
    @FXML
    private TextArea nameTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       sexBox.getItems().addAll(choice);
       weight.textProperty().addListener(new InputNumberValidator(weight));
       
       ///////////////sliderBar Codes
        sliderValue = (int) heightSIdeBar.getValue();
        // Add a listener to the slider's value property
        heightSIdeBar.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            // Cast the newValue to int and update the variable
            sliderValue = newValue.intValue();
            
            // Update the label with the current slider value
            centimeterLabel.setText(sliderValue+" cm");
            feetLabel.setText(Integer.toString((int)(sliderValue*0.393701))+" inch");
       });
        
       /////////////////////////////////sliderBar End
       
        birthdayPicker.setValue( LocalDate.of(2003,12,31) );
       
       
    }    

    @FXML
    private void handleSave(ActionEvent event) throws Exception
    {
      
        String UserID = userId.getText().trim();
        String Password = password.getText().trim();
        String Weight= weight.getText();
        sexBox.setValue("Male");

        // Check if user ID is empty
        if (UserID.isEmpty() || Password.isEmpty() || Weight.isEmpty())
        {
            userIdLabel.setText("Please Fill All Fields. Enter User ID");
            userIdLabel.setVisible(true);
            return;
        }
        
        // Check if user ID already exists
        for (User existingUser : HealthApp.users)
        {
            if (existingUser.getUserId().equals(UserID))
            {
                userIdLabel.setText("User ID already exists.");
                userIdLabel.setVisible(true);
                return;
            }
        }

        // Create new user and add to the users list
       
        User newUser = new User();
        newUser.setUserId(UserID);
        newUser.setPassword(Password);
        newUser.setWeight(Integer.parseInt(weight.getText()));
        newUser.setHeight(sliderValue);
        newUser.setSex(sexBox.getValue());
        newUser.setDateOfBirth(birthdayPicker.getValue());
        newUser.setWaist(80);
        newUser.setNeck(40);
        newUser.setName(nameTextField.getText());
        HealthApp.users.add(newUser);

        // Save the updated users list
        HealthApp.saveUsers();

        // Show success message (with an alert on the screen)
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("User Created");
        alert.setHeaderText(null);
        alert.setContentText("New user created successfully!");
        alert.showAndWait();
        Utility.changeToScene (getClass(), event, "loginScene.fxml");
        // Clear fields
        userId.clear();
        password.clear();
        userIdLabel.setVisible(false);
    }
    
}
