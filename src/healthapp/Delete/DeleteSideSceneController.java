/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Delete;

import healthapp.Core.Utility;
import healthapp.User;
import healthapp.HealthApp;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author tosha
 */
public class DeleteSideSceneController implements Initializable {

    @FXML
    private ListView<String> userList;
    private String[] usersInfo=new String[HealthApp.users.size()];
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       setUsers();
       userList.getItems().addAll(usersInfo);
    }    

    @FXML
    private void handleRemove(ActionEvent event) throws Exception
    {
        Alert alert=new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete An Account");
        alert.setHeaderText("You Are Going To Delete Your Account");
        alert.setContentText("Are You Sure??");
        
        if(alert.showAndWait().get()==ButtonType.OK){
            HealthApp.users.remove(HealthApp.user);
            Utility.changeToScene (getClass(), event, "/healthapp/loginScene.fxml");
        }
    }

    @FXML
    private void handleLogout(ActionEvent event) throws Exception
    {
         Utility.changeToScene (getClass(), event, "/healthapp/loginScene.fxml");
    }
    
    public void setUsers()
    {
        int index=0;
        for(User user:HealthApp.users)
        {
            usersInfo[index]=user.toString();
            index++;
        }
    }
}
