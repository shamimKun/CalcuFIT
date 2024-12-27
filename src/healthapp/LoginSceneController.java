package healthapp;

import healthapp.Core.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author SHAMIM
 */
public class LoginSceneController implements Initializable {

    @FXML
    private Label userIdLabel;
    @FXML
    private TextArea userIdTextArea;
    @FXML
    private PasswordField passwordTextArea;
    @FXML
    private Label messageError;
    @FXML
    private Button createNewButton;
    @FXML
    private Button loginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws Exception 
    {
        String userId = userIdTextArea.getText();
        String password = passwordTextArea.getText();
        boolean isAuthenticated = false;

        // Check each user in the list
        for (User user : HealthApp.users)
        {
          if (user.getUserId().equals(userId) && user.getPassword().equals(password))
          {
              HealthApp.setUSER(user);
              isAuthenticated = true;
              break; 
          }
        }

        if (isAuthenticated)
        {
            Utility.changeToScene(getClass(), event, "Landing/landingScene.fxml");
        } 
        else 
        {
            messageError.setText("Invalid user ID or password!");
        }
    }

    @FXML
    private void handleCreateNew(ActionEvent event) throws Exception
    {
         Utility.changeToScene(getClass(), event, "/healthapp/createNewUser.fxml");
    }
    
}
