package healthapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author SHAMIM
 * @Created On December 2024
 * Partners:
 * @Ratul Arefin
 * @Torik Rahman
 * 
 */
public class HealthApp extends Application implements Serializable  {
    
    
    public static User user;  //Every Other Class Will Use This Varible To Access The Current User
    public static ArrayList<User> users = new ArrayList<>();  //For Storing Every User Instance
    private static final String USER_FILE = "usersRecords.dat"; 

    //For Saving The User Informations In The File
    public static void saveUsers()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE)))
        {
            oos.writeObject(users);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    //for loading User Instances From File to the Programm
    public static void loadUsers()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE)))
        {
            users = (ArrayList<User>) ois.readObject();
            
            //for debugging
            /*for (User user : users)
            {
            //System.out.println("Loaded user: " + user.getUserId()+"Password "+user.getPassword());
            }*/
        } 
        catch (FileNotFoundException e)
        {
          users = new ArrayList<>(); //if No File Exist,It will create a new User ArrayList and load it in the programm
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
    
     
     
    //Entry Point To The Stage
    @Override
    public void start(Stage stage) throws Exception 
    {
        loadUsers();
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        stage.setTitle("CalcuFit");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("rsz_logo2.png")));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    //Invoked Just Before The Programm Ends, To Save Information In the File
    @Override
    public void stop()
    {
       //System.out.println("Saving user data before exiting...");  //for debuging
       HealthApp.saveUsers();
    }
    
    //This Method will set the Current User From The Login Class
    public static void setUSER(User x)
    {
        user=x;
    }
    
    //Main Method
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
