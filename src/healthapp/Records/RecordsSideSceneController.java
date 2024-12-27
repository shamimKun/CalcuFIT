/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Records;
import healthapp.Core.Utility;
import healthapp.HealthApp;
import healthapp.User;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import listener.InputNumberValidator;

/**
 * FXML Controller class
 *
 * @author tosha
 */
public class RecordsSideSceneController implements Initializable {

    @FXML
    private VBox resetButtonPressure;
    @FXML
    private TextField sugerLavelInput;
    @FXML
    private DatePicker sugerDate;
    @FXML
    private Button todayButtonSuger;
    @FXML
    private Button resetButtonSuger;
    @FXML
    private Button saveButtonSuger;
    @FXML
    private TextField pressureInput;
    @FXML
    private DatePicker pressureDateInput;
    @FXML
    private HBox todayButtonPressure;
    @FXML
    private Button saveButtonePressure;
    @FXML
    private Button pressureTodayButton;
    @FXML
    private Button pressureResterButton;
    
    User user=HealthApp.user;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sugerLavelInput.textProperty().addListener(new InputNumberValidator(sugerLavelInput));
        pressureInput.textProperty().addListener(new InputNumberValidator(pressureInput));
    }    

    @FXML
    private void setTodaySuger(ActionEvent event)
    {
        sugerDate.setValue(LocalDate.now());
    }

    @FXML
    private void setResetSuger(ActionEvent event)
    {
         sugerDate.setValue(null);
    }

    @FXML
    private void HandleSaveSuger(ActionEvent event) throws Exception
    {
        System.out.println(sugerLavelInput.getText()+" "+sugerDate.getValue());
        Integer value= Integer.parseInt(sugerLavelInput.getText());
        user.getSugerLevel().put(sugerDate.getValue(),value);
        Utility.changeCenterScene(Utility.mainBorderPane, getClass(), "/healthapp/Records/records.fxml");
    }

    @FXML
    private void setTodayPressure(ActionEvent event)
    {
        pressureDateInput.setValue(LocalDate.now());
    }

    @FXML
    private void setResetPressure(ActionEvent event)
    {
        pressureDateInput.setValue(null);
    }

    @FXML
    private void savePressure(ActionEvent event) throws Exception
    {
        System.out.println(sugerLavelInput.getText()+" "+sugerDate.getValue());
        
        Integer value= Integer.parseInt(pressureInput.getText());
        user.getPressureLevel().put(pressureDateInput.getValue(),value);
        Utility.changeCenterScene(Utility.mainBorderPane, getClass(), "/healthapp/Records/records.fxml");
    }

    @FXML
    private void setRese(MouseEvent event) {
    }
    
}
