
package healthapp.Activities;
import healthapp.Core.Utility;
import healthapp.HealthApp;
import healthapp.User;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import listener.InputNumberValidator;

/**
 * FXML Controller class
 *
 * @author SHAMIM
 */
public class ActivitiesCentralSceneController implements Initializable {

    @FXML
    private TextField walkingInputText;
    @FXML
    private TextField runningInputText;
    @FXML
    private TextField swimmimgInputText;
    @FXML
    private TextField excerciseInputText;
    
    User user=HealthApp.user;
    private LocalDate date;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.date=LocalDate.now();
        //listener So That Only Integer Can Be Added In The Text Feilds
        //Check The Input Number Validator Class For More Details
        runningInputText.textProperty().addListener(new InputNumberValidator(runningInputText));
        walkingInputText.textProperty().addListener(new InputNumberValidator(walkingInputText));
        swimmimgInputText.textProperty().addListener(new InputNumberValidator(swimmimgInputText));
        excerciseInputText.textProperty().addListener(new InputNumberValidator(excerciseInputText));
    }    

    @FXML
    private void saveInWalkingHashMap(ActionEvent event) throws Exception
    {
       Integer x=Integer.parseInt(walkingInputText.getText());
       if(user.getWalking().containsKey(date))
       {
         x=user.getWalking().get(date)+x;
       }
       user.getWalking().put(date,x);
       System.out.println(x);
       //For Refresing The Side Table
       Utility.changeRightScene(Utility.mainBorderPane, getClass(), "/healthapp/Activities/activitiesSideScene.fxml");
    }

    @FXML
    private void saveInRunningHashMap(ActionEvent event) throws Exception
    {
       Integer x=Integer.parseInt(runningInputText.getText());
       if(user.getRunning().containsKey(date))
       {
          x=user.getRunning().get(date)+x;
       }
       user.getRunning().put(date,x);
       System.out.println(x);
       
       Utility.changeRightScene(Utility.mainBorderPane, getClass(), "/healthapp/Activities/activitiesSideScene.fxml");
    }

    @FXML
    private void saveInSwiimingHashMap(ActionEvent event) throws Exception
    {
       Integer x=Integer.parseInt(swimmimgInputText.getText());
       if(user.getSwimming().containsKey(date))
        {
         x=user.getSwimming().get(date)+x;
        }
       user.getSwimming().put(date,x);
       System.out.println(x);
       
       Utility.changeRightScene(Utility.mainBorderPane, getClass(), "/healthapp/Activities/activitiesSideScene.fxml");
    }

    @FXML
    private void saveInExeciseHashMap(ActionEvent event) throws Exception 
    {
       Integer x=Integer.parseInt(excerciseInputText.getText());
       if(user.getExercise().containsKey(date))
       {
         x=user.getExercise().get(date)+x;
       }
       user.getExercise().put(date,x);
       System.out.println("change"+x);
       
       Utility.changeRightScene(Utility.mainBorderPane, getClass(), "/healthapp/Activities/activitiesSideScene.fxml");
    }
    
}
