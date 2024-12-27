/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Activities;

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
 * @author tosha
 */
public class ActivitiesSideSceneController implements Initializable {

    
    User user=HealthApp.user;
    @FXML
    private TableView<DataRow> walkinngTable;
    @FXML
    private TableColumn<?, ?> walkDateCol;
    @FXML
    private TableColumn<?, ?> walkCol;
    @FXML
    private TableView<DataRow> runningTable;
    @FXML
    private TableColumn<?, ?> runDateCol;
    @FXML
    private TableColumn<?, ?> runCol;
    @FXML
    private TableView<DataRow> swimmingTable;
    @FXML
    private TableColumn<?, ?> swimDateCol;
    @FXML
    private TableColumn<?, ?> swimCol;
    @FXML
    private TableView<DataRow> exersiceTable;
    @FXML
    private TableColumn<?, ?> exerciseDateCol;
    @FXML
    private TableColumn<?, ?> exerciseCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ////////////table1
        ObservableList<DataRow> data = FXCollections.observableArrayList();
        user.getWalking().forEach((date, value) -> data.add(new DataRow(date, value)));
        
        walkDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        walkCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        walkinngTable.setItems(data);
        walkinngTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        //////////table2
        ObservableList<DataRow> data2 = FXCollections.observableArrayList();
        user.getRunning().forEach((date, value) -> data2.add(new DataRow(date, value)));
        
        runDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        runCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        runningTable.setItems(data2);
        runningTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ////////////////table3
        ObservableList<DataRow> data3 = FXCollections.observableArrayList();
        user.getSwimming().forEach((date, value) -> data3.add(new DataRow(date, value)));
        
        swimDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        swimCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        swimmingTable.setItems(data3);
        swimmingTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ///////////////table4
        ObservableList<DataRow> data4 = FXCollections.observableArrayList();
        user.getExercise().forEach((date, value) -> data4.add(new DataRow(date, value)));
        
        exerciseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        exerciseCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        exersiceTable.setItems(data4);
        exersiceTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }    
    
}
