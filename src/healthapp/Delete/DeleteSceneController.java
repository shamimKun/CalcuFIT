/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Delete;

import healthapp.User;
import healthapp.HealthApp;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import listener.InputNumberValidator;

/**
 * FXML Controller class
 *
 * @author tosha
 */
public class DeleteSceneController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField editValue;
    @FXML
    private Button editButton;
    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private DatePicker datePicker2;
    @FXML
    private Button leftButton2;
    @FXML
    private Button rightButton2;
    
    String[] choices={"Walking","Swimming","Running","Exercise","Food Intake","Sugar Level","Pressure Level"};
    User user=HealthApp.user;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalDate today=LocalDate.now();
        choiceBox.getItems().addAll(choices);
        choiceBox2.getItems().addAll(choices);
        datePicker.setValue(today);
        datePicker2.setValue(today);
        editValue.textProperty().addListener(new InputNumberValidator(editValue));
    }    

    @FXML
    private void handleDelete(ActionEvent event) {
        LocalDate date=datePicker.getValue();
        String choice=choiceBox.getValue();
        Integer value=0;
        setValues(choice,date,value);
    }

    @FXML
    private void handleEdit(ActionEvent event) {
        LocalDate date=datePicker2.getValue();
        String choice=choiceBox2.getValue();
        Integer value = Integer.parseInt(editValue.getText());
        setValues(choice,date,value);
    }

    @FXML
    private void handleLeft(ActionEvent event) {
        LocalDate date=datePicker.getValue();
        datePicker.setValue(date.minusDays(1));
    }

    @FXML
    private void handleRight(ActionEvent event) {
        LocalDate date=datePicker.getValue();
        datePicker.setValue(date.plusDays(1));
    }

    @FXML
    private void handleLeft2(ActionEvent event) {
        LocalDate date=datePicker2.getValue();
        datePicker2.setValue(date.minusDays(1));
    }

    @FXML
    private void handleRight2(ActionEvent event) {
         LocalDate date=datePicker2.getValue();
         datePicker2.setValue(date.plusDays(1));
    }
    
    private void setValues(String choice,LocalDate date,Integer value){
        
        switch (choice) {
            case "Walking":
                user.getWalking().put(date, value);
                break;
            case "Running":
                user.getRunning().put(date, value);
                break;
            case "Swimming":
                user.getSwimming().put(date, value);
                break;
            case "Exercise":
                user.getExercise().put(date, value);
                break;
            case "Food Intake":
                user.getCaloriesTaken().put(date, value);
                break;
            case "Sugar Level":
                user.getSugerLevel().put(date, value);
                break;
            case "Pressure Level":
                user.getPressureLevel().put(date, value);
                break;
            default:
                break;
        }
        
    }
    
}
