
package healthapp.Core;


import healthapp.Landing.LandingSceneController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author MichaelO
 */
public class Utility 
{
    public static BorderPane mainBorderPane;
    
// Example use:
    //  Utility.changeToScene (getClass(), event, "myXLM.fxml");
    public static void changeToScene(Class aClass, Event aEvent, String sceneFileStr)  throws Exception
    {
        Parent root = FXMLLoader.load (aClass.getResource(sceneFileStr));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) aEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Calculate center position
        double centerX = (screenBounds.getWidth() - stage.getWidth()) / 2;
        double centerY = (screenBounds.getHeight() - stage.getHeight()) / 2;

        // Set the new position of the stage
        stage.setX(centerX);
        stage.setY(centerY);
        
        
        stage.show();  
       
       
    }
    
    /*public static void changeToScene(Class<?> aClass, Event aEvent, String sceneFileStr) throws Exception {
    // Get the current stage
    Stage stage = (Stage)((Node) aEvent.getSource()).getScene().getWindow();

    // Store the current dimensions
    double previousWidth = stage.getWidth();
    double previousHeight = stage.getHeight();

    // Load the new scene
    Parent root = FXMLLoader.load(aClass.getResource(sceneFileStr));
    Scene scene = new Scene(root);

    // Set the new scene
    stage.setScene(scene);

    // Apply the previous dimensions
    stage.setWidth(previousWidth);
    stage.setHeight(previousHeight);

    stage.show();
}*/
    
    /* public static void changeToScene(Class aClass, Event aEvent, String sceneFileStr) throws Exception {
         // get screensize of monitor
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent root = FXMLLoader.load(aClass.getResource(sceneFileStr));
        Scene scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());
        Stage stage = (Stage) ((Node) aEvent.getSource()).getScene().getWindow();
      
        stage.setScene(scene);
        
        stage.setMaximized(true); // Maximize the stage
        stage.centerOnScreen();  // Center it automatically
    
    
        stage.show();
       /* Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);*/
  //  } 
    
     //  Utility.changeToPopUpScene (getClass(), event, "myXLM.fxml");
    public static void changeToPopUpScene(Class aClass, Event aEvent, String sceneFileStr) throws Exception
    {
        
            FXMLLoader loader = new FXMLLoader(aClass.getResource(sceneFileStr));
        
            Parent root = loader.load();

            // Create a new Stage for the popup
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL); // Block main window
           // popupStage.setTitle("Enter Age");
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait(); // Wait for the popup to close
        
    }
    
    
    //Utility.changeCentreScene(borderPane,getClass(), event, "myXLM.fxml");
    public static void changeCenterScene(BorderPane borderPane, Class<?> aClass, String fxmlPath) throws Exception {
    try {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(aClass.getResource(fxmlPath));
        Node newContent = loader.load();
        
        //send The borderPane 
       // loader.getController().csetMainBorderPane(mainBorderPane);
        
        // Set the loaded content to the center of the BorderPane
        borderPane.setCenter(newContent);

        System.out.println("Center scene successfully updated with: " + fxmlPath);
    } 
    
    catch (Exception e) {
        System.err.println("Error loading the center scene: " + fxmlPath);
        e.printStackTrace();
        throw e; // Re-throw exception for further handling if needed
    }
}
    
    
    public static void changeRightScene(BorderPane borderPane, Class<?> aClass, String fxmlPath) throws Exception {
    try {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(aClass.getResource(fxmlPath));
        Node newContent = loader.load();
        
        // Set the loaded content to the center of the BorderPane
        borderPane.setRight(newContent);

        System.out.println("Center scene successfully updated with: " + fxmlPath);
    } 
    
    catch (Exception e) {
        System.err.println("Error loading the center scene: " + fxmlPath);
        e.printStackTrace();
        throw e; // Re-throw exception for further handling if needed
    }
}
    
    public void setMainBorderPane(BorderPane borderPane){
        this.mainBorderPane=borderPane;
    }

}

