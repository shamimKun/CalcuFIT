package healthapp.Food;

import healthapp.Core.Utility;
import healthapp.HealthApp;
import healthapp.User;
import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FoodTrackerController {
    @FXML
    private TextField searchField;

    @FXML
    private TableView<FoodItem> foodTable;

    @FXML
    private TableView<SelectedFood> selectedFoodTable;

    @FXML
    private TableColumn<FoodItem, String> foodNameColumn;

    @FXML
    private TableColumn<FoodItem, Integer> caloryColumn;

    @FXML
    private TableColumn<SelectedFood, String> selectedFoodNameColumn;

    @FXML
    private TableColumn<SelectedFood, Integer> selectedCaloryColumn;

    @FXML
    private TableColumn<SelectedFood, Integer> servingsColumn;

    @FXML
    private Text totalCaloriesText;

    private  HashMap<String, Integer> foodMap ;
    private final ObservableList<FoodItem> foodList = FXCollections.observableArrayList();
    private final ObservableList<SelectedFood> selectedFoodList = FXCollections.observableArrayList();
    @FXML
    private Button addButton;
    @FXML
    private Button calculateButton;
    User user=HealthApp.user;

    public void initialize() 
    {
        //Geting The Food Map
        foodMap=BengaliFoodCalories.foodCalories;
        
        // Populate foodList with data from foodMap
        foodList.addAll(foodMap.entrySet().stream()
                .map(entry -> new FoodItem(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList()));

        // Bind foodList to foodTable
        foodNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        caloryColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        foodTable.setItems(foodList);

        // Bind selectedFoodList to selectedFoodTable
        selectedFoodNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        selectedCaloryColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        servingsColumn.setCellValueFactory(cellData -> cellData.getValue().servingsProperty().asObject());
        selectedFoodTable.setItems(selectedFoodList);

        // Enable editing on the TableView
        selectedFoodTable.setEditable(true);
        
        // Make servingsColumn editable
        servingsColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        servingsColumn.setOnEditCommit(event -> {
            SelectedFood food = event.getRowValue();
            food.setServings(event.getNewValue());
        });

        // Add search functionality
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            foodList.clear();
            foodMap.entrySet().stream()
                    .filter(entry -> entry.getKey().toLowerCase().contains(newValue.toLowerCase()))
                    .map(entry -> new FoodItem(entry.getKey(), entry.getValue()))
                    .forEach(foodList::add);
        });
        
        //Making Table Resizable
        foodTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        selectedFoodTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void addSelectedFood()
    {
        FoodItem selectedFood = foodTable.getSelectionModel().getSelectedItem();
        if (selectedFood != null)
        {
            selectedFoodList.add(new SelectedFood(selectedFood.getName(), selectedFood.getCalories(), 1));
            //selectedFoodTable.refresh(); // Ensure the table updates
        } 
        else
        {
           //System.out.println("No food selected!"); // Debugging
        }
    }

    @FXML
    private void calculateTotalCalories() throws Exception 
    {
        int totalCalories = selectedFoodList.stream()
                .mapToInt(food -> food.getCalories() * food.getServings())
                .sum();
        totalCaloriesText.setText("Total Calories: " + totalCalories);
        
        int value=user.getCaloriesTaken().get(LocalDate.now())+totalCalories;
        user.getCaloriesTaken().put(LocalDate.now(), value);
        Utility.changeRightScene(Utility.mainBorderPane, getClass(), "/healthapp/Food/foodSideScene.fxml");
   }

    // Inner class for FoodItem
    public static class FoodItem {
        private final String name;
        private final int calories;

        public FoodItem(String name, int calories) {
            this.name = name;
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public int getCalories() {
            return calories;
        }
    }

    // Inner class for SelectedFood
    public static class SelectedFood {
        private final String name;
        private final int calories;
        private final SimpleIntegerProperty servings;

        public SelectedFood(String name, int calories, int servings) {
            this.name = name;
            this.calories = calories;
            this.servings = new SimpleIntegerProperty(servings);
        }

        public String getName() {
            return name;
        }

        public int getCalories() {
            return calories;
        }

        public int getServings() {
            return servings.get();
        }

        public SimpleIntegerProperty servingsProperty() {
            return servings;
        }

        public void setServings(int servings) {
            this.servings.set(servings);
        }
    }
}
