/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Contacts;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author tosha
 */
public class ContactsCentralSceneController implements Initializable
{

    @FXML
    private Label selectLabel;
    @FXML
    private ListView<String> listView;
    String[] hospital=HospitalList.HOSPITAL_INFO;
    String select;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        listView.getItems().addAll(hospital);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {  
            @Override
	    public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2)
            {
		select = listView.getSelectionModel().getSelectedItem();
		selectLabel.setText(select);
	    }	
	});
        
    }    
    
}
