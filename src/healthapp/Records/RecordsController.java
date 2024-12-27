/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Records;

import healthapp.HealthApp;
import healthapp.User;
import java.net.URL;
import java.time.LocalDate;
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
public class RecordsController implements Initializable {

    @FXML
    private TableView<DataRow> bloodSugerTable;
    @FXML
    private TableColumn<DataRow,LocalDate> sugerDateColumn;
    @FXML
    private TableColumn<DataRow,Integer> sugerLaelColumn;
    @FXML
    private TableView<DataRow> bloodPressureTable;
    @FXML
    private TableColumn<DataRow,LocalDate> pressureDateColumn;
    @FXML
    private TableColumn<DataRow,LocalDate> pressureLavelColumn;
    User user=HealthApp.user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ObservableList<DataRow> data = FXCollections.observableArrayList();
     user.getSugerLevel().forEach((date, value) -> {
        if (value != -1) { // Filter out
            data.add(new DataRow(date, value));
        }
    });
    sugerDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    sugerLaelColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    bloodSugerTable.setItems(data);
    bloodSugerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    
    ObservableList<DataRow> data2 = FXCollections.observableArrayList();
     user.getPressureLevel().forEach((date, value) -> {
        if (value != -1) { // Filter out
            data2.add(new DataRow(date, value));
        }
    });
    pressureDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    pressureLavelColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    bloodPressureTable.setItems(data2);
    bloodPressureTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    
    bloodSugerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    bloodPressureTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    
    }
    
    
    
}

