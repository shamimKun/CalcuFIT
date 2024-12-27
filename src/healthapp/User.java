package healthapp;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;

/**
 *@author SHAMIM
 * This "User" Class Handle Every Information Of A User
 */


public class User implements Serializable{
    // Basic User Information
    private String userId;
    private String password;
    private String name;
    private String nickName;
    private int weight;
    private int height;
    private LocalDate dateOfBirth;
    private int age;
    private int neck;
    private int waist;
    private String sex;

    // Daily Metrics
    private int todayCaloriesTaken; //not used
    private int todayCaloriesBurned; //not used

    // Activity Logs
    private HashMap<LocalDate, Integer> walking;
    private HashMap<LocalDate, Integer> running;
    private HashMap<LocalDate, Integer> swimming;
    private HashMap<LocalDate, Integer> exercise;

    // Food Logs
    private HashMap<LocalDate, Integer> caloriesTaken;
    
    //Record Logs
    private HashMap<LocalDate, Integer>sugerLevel;
    private HashMap<LocalDate, Integer>pressureLevel;

    // Constructors
    public User(String userId, String password)
    {
        this.userId = userId;
        this.password = password;
        this.walking = new HashMap<>();
        this.running = new HashMap<>();
        this.swimming = new HashMap<>();
        this.exercise = new HashMap<>();
        this.caloriesTaken = new HashMap<>();
        this.sugerLevel=new HashMap<>();
        this.pressureLevel=new HashMap<>();
    }
    
    //We Use This Constructor One In The Create New User Class To Create A New User
    public User()
    {
        this("", ""); //Declaring The Hashmaps
        
        LocalDate date=LocalDate.now(); //todays date.
        
        //Assigning Zero Value For Initial 
        if(walking.get(date)==null) 
            walking.put(date,0);
        
        if(running.get(date)==null)
            running.put(date,0);
        
        if(swimming.get(date)==null)
            swimming.put(date,0);
        
        if(exercise.get(date)==null)
            exercise.put(date,0);
        
        if(caloriesTaken.get(date)==null)
            caloriesTaken.put(date,0);
        
        
        if(sugerLevel.isEmpty())
            sugerLevel.put(LocalDate.now(),0);
        
        if(pressureLevel.isEmpty())
            pressureLevel.put(LocalDate.now(),0);
            
    }
    
    public User getUser(){
        return this;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //When You First Open The Programm For The Day,It Assign A Default Zero
    public int getTodayCaloriesTaken() {
        if(caloriesTaken.get(LocalDate.now())==null)
           caloriesTaken.put(LocalDate.now(),0);
        
        return caloriesTaken.get(LocalDate.now());
    }

    public void setTodayCaloriesTaken(int todayCaloriesTaken) {
        this.todayCaloriesTaken = todayCaloriesTaken;
        
    }

    public int getTodayCaloriesBurned(){
        LocalDate date=LocalDate.now();
        if(walking.get(date)==null)
            walking.put(date, 0);
        if(running.get(date)==null)
            running.put(date, 0);
        if(swimming.get(date)==null)
            swimming.put(date, 0);
        if(exercise.get(date)==null)
            exercise.put(date, 0);
        
        
        return (int)((walking.get(date)*0.04) + (swimming.get(date)*12.0) + (running.get(date)*17.60) +(exercise.get(date)*15.20) );
       
    }

    public void setTodayCaloriesBurned() {
     //  LocalDate date=LocalDate.now();
    }

    public HashMap<LocalDate, Integer> getWalking() {
        return walking;
    }

    public void setWalking(HashMap<LocalDate, Integer> walking) {
        this.walking = walking;
    }

    public HashMap<LocalDate, Integer> getRunning() {
        return running;
    }

    public void setRunning(HashMap<LocalDate, Integer> running) {
        this.running = running;
    }

    public HashMap<LocalDate, Integer> getSwimming() {
        return swimming;
    }

    public void setSwimming(HashMap<LocalDate, Integer> swimming) {
        this.swimming = swimming;
    }

    public HashMap<LocalDate, Integer> getExercise() {
        return exercise;
    }

    public void setExercise(HashMap<LocalDate, Integer> exercise) {
        this.exercise = exercise;
    }

    public HashMap<LocalDate, Integer> getCaloriesTaken() {
        return caloriesTaken;
    }

    public void setCaloriesTaken()
    {
         
    }
    
    public HashMap<LocalDate, Integer> getSugerLevel()
    {
        return sugerLevel;
    }
    
    public HashMap<LocalDate, Integer> getPressureLevel()
    {
        return pressureLevel;
    }
    
    public int getAge(){
        return (int) ChronoUnit.YEARS.between( dateOfBirth,LocalDate.now());
    }
    
    public void setNeck(int neck){
        this.neck=neck;
    }
    
    public int getNeck(){
        return neck;
    }
    
    public int getWaist(){
        return waist;
    }
    public void setWaist(int x){
        this.waist=x;
    }

    @Override
    public String toString() {
        
        return "Name: "+this.getName()+" Date Of Birth: "+this.getDateOfBirth();
                       
    }

}

