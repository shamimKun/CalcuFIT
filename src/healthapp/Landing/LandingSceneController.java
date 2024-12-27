package healthapp.Landing;


import healthapp.Core.Utility;
import healthapp.HealthApp;
import healthapp.User;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author SHAMIM
 */
public class LandingSceneController implements Initializable 
{

    User user=HealthApp.user;
    @FXML
    private BorderPane mainBorderPane;
    
    private static Node originalCenter;
    private static Node originalRight;
    private static Node originalLeft;
    private static Node originalTop;
   // private static Node originalBottom;

    @FXML
    private AnchorPane UpperPane;
    @FXML
    private ImageView helthlogo;
    @FXML
    private Label helloLabel;
    @FXML
    private Label taglineLabel;
    @FXML
    private Label dateILabel;
    @FXML
    private ImageView dateIcon;
    @FXML
    private AnchorPane leftSidePane;
    @FXML
    private VBox leftMenuBox;
    @FXML
    private Button homeButton;
    @FXML
    private Button activitesButton;
    @FXML
    private Button foodButton;
    @FXML
    private Button recordsButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button contactsButton;
    @FXML
    private Button indexButton;
    @FXML
    private AnchorPane centralPane;
    @FXML
    private HBox centralHbox;
    @FXML
    private Pane caloriesTakenPane;
    @FXML
    private Label takenMessageLabel;
    @FXML
    private Label caloriesTakenOutputLabel;
    @FXML
    private Pane caloriesBurnPane;
    @FXML
    private Label burnLabel;
    @FXML
    private Label caloriesBurnOutputLabel;
    @FXML
    private Pane caloriesRemainPane;
    @FXML
    private Label remainLabel;
    @FXML
    private Label caloriesRemainOutputLabel;
    @FXML
    private AnchorPane rightSidePane;
    @FXML
    private VBox rightSideHbox;
    @FXML
    private Pane agePane;
    @FXML
    private Label AgeLAbel;
    @FXML
    private Label ageOutputLabel;
    @FXML
    private Pane weightPane;
    @FXML
    private Label weightLabel;
    @FXML
    private Label weightOutputLabel;
    @FXML
    private Pane heightPane;
    @FXML
    private Label heightLabel;
    @FXML
    private Label heightOutputLabel;
    @FXML
    private Label weekLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button sugerLevel;
    @FXML
    private Label sugerValue;
    @FXML
    private Button pressureLevel;
    @FXML
    private Label pressureValue;
    @FXML
    private Button burnLevel;
    @FXML
    private Label burnValue;
    @FXML
    private Button intakeLevel;
    @FXML
    private Label intakeValue;
    @FXML
    private Label extraInfo;
    @FXML
    private Button editButton;
    @FXML
    private ImageView imageBox;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       setValues();                 //for Inital Value For The Labels
       extraInfo.setOpacity(0.9);   //the Opacity Of Dialogue label
       //Summery.setUser(user);
       
       //For Storing The Original Home BorderPane, So That I dont Have To Load The FXML Again
       originalCenter = mainBorderPane.getCenter();
       originalRight = mainBorderPane.getRight();
       originalLeft = mainBorderPane.getLeft();
       originalTop = mainBorderPane.getTop();
     //originalBottom = mainBorderPane.getBottom();
       
        Utility.mainBorderPane=this.mainBorderPane;
        setActiveButton(homeButton);
    }    

    @FXML
    private void handleHome(ActionEvent event) throws Exception
    {   
        mainBorderPane.setCenter(originalCenter);
        mainBorderPane.setRight(originalRight);
        mainBorderPane.setLeft(originalLeft);
        mainBorderPane.setTop(originalTop);
       // mainBorderPane.setBottom(originalBottom);
       setValues();
       setActiveButton(homeButton);
    }

    @FXML
    private void handleActivities(ActionEvent event) throws Exception
    {
        Utility.changeCenterScene(mainBorderPane, getClass(), "/healthapp/Activities/activitiesCentralScene.fxml");
        Utility.changeRightScene(mainBorderPane, getClass(), "/healthapp/Activities/activitiesSideScene.fxml");
        Image newImage = new Image(getClass().getResource("image/saitama.png").toExternalForm());
        imageBox.setImage(newImage);
        applyTypewriterEffect(taglineLabel,"100 Push Ups, 100 Sit Ups, 100 Squats, Run 10km, Every Single Day",15);
        setActiveButton(activitesButton);
 
    }

    @FXML
    private void handleFood(ActionEvent event) throws Exception 
    {
        Utility.changeCenterScene(mainBorderPane, getClass(), "/healthapp/Food/FoodTracker.fxml");
        Utility.changeRightScene(mainBorderPane, getClass(), "/healthapp/Food/foodSideScene.fxml");
        Image newImage = new Image(getClass().getResource("image/luffy.png").toExternalForm());
        imageBox.setImage(newImage);
        applyTypewriterEffect(taglineLabel,"If You Are Hungry, Just EAT!!!",20);
        setActiveButton(foodButton);
    }

    @FXML
    private void handleRecords(ActionEvent event) throws Exception
    {
        Utility.changeCenterScene(mainBorderPane, getClass(), "/healthapp/Records/records.fxml");
        Utility.changeRightScene(mainBorderPane, getClass(), "/healthapp/Records/recordsSideScene.fxml");
        Image newImage = new Image(getClass().getResource("image/gintoki.png").toExternalForm());
        imageBox.setImage(newImage);
        applyTypewriterEffect(taglineLabel,"Diabetes??So What, I Will Live A Thick,Rich,Creamy and Sweet Life,Even If It's Short",20);
        setActiveButton(recordsButton);
    }

    @FXML
    private void handleProfile(ActionEvent event) throws Exception
    {
        Utility.changeCenterScene(mainBorderPane, getClass(), "/healthapp/Profile/profileCentralScene.fxml");
        Utility.changeRightScene(mainBorderPane, getClass(), "/healthapp/Profile/profileSideScene.fxml");
        Image newImage = new Image(getClass().getResource("image/mitsuha.png").toExternalForm());
        imageBox.setImage(newImage);
        applyTypewriterEffect(taglineLabel,"Even If You Forget Someone's Name,Their Feelings Will Always Remain In Your Hearth",20);
        setActiveButton(profileButton);
    }

    @FXML
    private void handleContacts(ActionEvent event) throws Exception
    {
        Utility.changeCenterScene(mainBorderPane, getClass(), "/healthapp/Contacts/contactsCentralScene.fxml");
        Utility.changeRightScene(mainBorderPane, getClass(), "/healthapp/Contacts/contactSideScene.fxml");
        Image newImage = new Image(getClass().getResource("image/tenma.png").toExternalForm());
        imageBox.setImage(newImage);
        applyTypewriterEffect(taglineLabel,"A Doctor's Job Is To Save Lives. All Lives Are Equal",25);
        setActiveButton(contactsButton);
    }

    @FXML
    private void handleIndex(ActionEvent event) throws Exception
    {
        Utility.changeCenterScene(mainBorderPane, getClass(), "/healthapp/Index/indexCentralScene.fxml");
        Utility.changeRightScene(mainBorderPane, getClass(), "/healthapp/Index/indexSideScene.fxml");
        Image newImage = new Image(getClass().getResource("image/LL.png").toExternalForm());
        imageBox.setImage(newImage);
        applyTypewriterEffect(taglineLabel,"If You Use Your Head,You Won't Get Fat,Even If You Eat Sweets",20);
        setActiveButton(indexButton);
    }
    
    @FXML
    private void handleEdit(ActionEvent event) throws Exception
    {
        Utility.changeCenterScene(mainBorderPane, getClass(), "/healthapp/Delete/deleteScene.fxml");
        Utility.changeRightScene(mainBorderPane, getClass(), "/healthapp/Delete/deleteSideScene.fxml");
        Image newImage = new Image(getClass().getResource("image/himmel.png").toExternalForm());
        imageBox.setImage(newImage);
        applyTypewriterEffect(taglineLabel,"I Had Been Looking Forward To The Day When We All Be Together,Again ",30);
        setActiveButton(editButton);
    }

    //I dont know Why But If I delete This Method,Programm Crash,even after deleting the misc from fxml file
    @FXML
    private void handleMisc(MouseEvent event){
    }
    
    //For Initial Values
    private void setValues()
    {
       String x= Integer.toString(user.getTodayCaloriesBurned());
       caloriesBurnOutputLabel.setText(x);
       
       String y= Integer.toString(user.getTodayCaloriesTaken());
       caloriesTakenOutputLabel.setText(y);
       
       String z= Integer.toString(user.getTodayCaloriesTaken()-user.getTodayCaloriesBurned());
       caloriesRemainOutputLabel.setText(z);
       
       
       ageOutputLabel.setText(Integer.toString(user.getAge()));
       weightOutputLabel.setText(Integer.toString(user.getWeight()));
       heightOutputLabel.setText(Integer.toString(user.getHeight()));
       
       datePicker.setValue(LocalDate.now());
       String weekdayName = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
       weekLabel.setText(weekdayName);
       helloLabel.setText(user.getName());
       
       sugerValue.setText(Summery.getAvgSugerLevel());
       pressureValue.setText(Summery.getAvgPressureLevel());
       burnValue.setText(Summery.getAvgBurning());
       intakeValue.setText(Summery.getAvgIntake());
       applyTypewriterEffect(taglineLabel,"Welcome To CalcuFIT, Your Daily Health Tracker",15);
       
       Image newImage = new Image(getClass().getResource("image/haru.png").toExternalForm());
       imageBox.setImage(newImage);
         
    }
    
    //For The Menu Button Color Change Effect
    private void setActiveButton(Button activeButton) 
    {
        // Remove "active" class from all buttons
        homeButton.getStyleClass().remove("active");
        activitesButton.getStyleClass().remove("active");
        foodButton.getStyleClass().remove("active");
        recordsButton.getStyleClass().remove("active");
        indexButton.getStyleClass().remove("active");
        contactsButton.getStyleClass().remove("active");
        profileButton.getStyleClass().remove("active");
        editButton.getStyleClass().remove("active");
       
        // Add "active" class to the clicked button
        activeButton.getStyleClass().add("active");
    }

    @FXML
    private void handleSuger(ActionEvent event) {
        applyTypewriterEffect(extraInfo, Summery.getSugerWarning(),25);
    }

    @FXML
    private void handlePressure(ActionEvent event) {
        applyTypewriterEffect(extraInfo, Summery.getSystolicBloodPressureWarning(), 25);
    }

    @FXML
    private void handleBurning(ActionEvent event) {
         applyTypewriterEffect(extraInfo, Summery.getActivityLevel(), 25);
    }

    @FXML
    private void handleIntake(ActionEvent event) {
        applyTypewriterEffect(extraInfo, Summery.getDailyCalorieIntakeWarning(), 25);
    }
    
    //This Method Apply The Type Writter Effect For The Dialoge Box
    //applyTypewriterEffect(Label,String,delayMillis);
    public void applyTypewriterEffect(Label label, String text, int delayMillis) {
        final int[] index = {0}; // To track the current character index
        label.setText("");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(delayMillis), event -> {
            if (index[0] < text.length()) {
                label.setText(label.getText() + text.charAt(index[0]));
                index[0]++;
            }
        }));
        
        timeline.setCycleCount(text.length()); // Run once for each character
        timeline.play();
    }

    
    
}
