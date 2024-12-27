/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Index;

import healthapp.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author tosha
 */
public class IndexCentralSceneController implements Initializable {

    @FXML
    private Label bmiLabel;
    @FXML
    private Label bmiMessage;
    @FXML
    private Label bmrLabel;
    @FXML
    private Label bmrMessage;
    @FXML
    private Label idealLabel;
    @FXML
    private Label idealMessage;
    @FXML
    private Label fatLabel;
    @FXML
    private Label fatMessage;
    User user=HealthApp.user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("Working On here");
        HealthMetrics index;
        index = new HealthMetrics(user);
        
        bmiLabel.setText(Double.toString(index.getBMI()));
        bmrLabel.setText(Double.toString(index.getBMR()));
        idealLabel.setText(Double.toString(index.getIdealWeight()));
        fatLabel.setText(Double.toString(index.getBodyFat()));
        
        bmiMessage.setText(index.getBMIStatus());
        bmrMessage.setText("Daily Caloris Needed");
        fatMessage.setText(index.getBodyFatStatus());
        idealMessage.setText(index.getWHtRStatus());
    }    
    
}
