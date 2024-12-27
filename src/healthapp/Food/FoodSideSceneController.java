
package healthapp.Food;

import healthapp.HealthApp;
import healthapp.User;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Shamim
 */
public class FoodSideSceneController implements Initializable {

    @FXML
    private TableView<DataRow> foodTable;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> caloriesColumn;
    
    User user=HealthApp.user;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //Creating The Table
        ObservableList<DataRow> data = FXCollections.observableArrayList();
        user.getCaloriesTaken().forEach((date, value) -> data.add(new DataRow(date, value)));
        
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        foodTable.setItems(data);
    }    
    
}
