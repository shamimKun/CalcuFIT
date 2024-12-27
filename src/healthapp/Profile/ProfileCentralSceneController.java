/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Profile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import healthapp.*;
import javafx.event.ActionEvent;
import listener.InputNumberValidator;

/**
 * FXML Controller class
 *
 * @author tosha
 */
public class ProfileCentralSceneController implements Initializable {

    @FXML
    private TextField neckText;
    @FXML
    private TextField waistText;
    private Text passwordText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField sexText;
    @FXML
    private TextField heightText;
    @FXML
    private TextField userId;
    @FXML
    private DatePicker date;
    
    private User user=HealthApp.user;
    @FXML
    private TextField pasword;
    @FXML
    private TextField weighrtText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameText.setText(user.getName());
        sexText.setText(user.getSex());
        
        heightText.setText(Integer.toString(user.getHeight()));
        waistText.setText(Integer.toString(user.getWaist()));
        neckText.setText(Integer.toString(user.getNeck()));
        
        userId.setText(user.getUserId());
        pasword.setText(user.getPassword());
        date.setValue(user.getDateOfBirth());
        weighrtText.setText(Integer.toString(user.getWeight()));
        
        heightText.textProperty().addListener(new InputNumberValidator(heightText));
        waistText.textProperty().addListener(new InputNumberValidator( waistText));
        neckText.textProperty().addListener(new InputNumberValidator(neckText));
        weighrtText.textProperty().addListener(new InputNumberValidator(weighrtText));
         
        
    }    

    @FXML
    private void handleName(ActionEvent event){
        user.setName(nameText.getText());
    }

    @FXML
    private void handleHeight(ActionEvent event) {
        int x=Integer.parseInt(heightText.getText());
        user.setHeight(x);
        
    }


    @FXML
    private void handleWaist(ActionEvent event){
        int x=Integer.parseInt(waistText.getText());
        user.setWaist(x);
    }

    @FXML
    private void handlePassword(ActionEvent event) {
        user.setPassword(passwordText.getText());
    }

    @FXML
    private void handleDate(ActionEvent event) {
        user.setDateOfBirth(date.getValue());
    }

    @FXML
    private void handleNeck(ActionEvent event) {
        int x=Integer.parseInt(neckText.getText());
        user.setNeck(x);
    }

    @FXML
    private void handleWeight(ActionEvent event) {
        int x=Integer.parseInt(weighrtText.getText());
        user.setWeight(x);
    }
    
}
