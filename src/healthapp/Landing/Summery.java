package healthapp.Landing;
import healthapp.User;
import healthapp.HealthApp;
import java.time.LocalDate;
/**
 *
 * @author Shamim
 * This Class Handle The Message For Gintoki
 */
public class Summery {
    public static User user=HealthApp.user;
    public static Double avgSuger;
    public static Double avgPressure;
    public static Double avgBurning;
    public static Double avgIntake;
    public static LocalDate today=LocalDate.now();
    
    public static void calculateAvgSuger(){
        int total=0;
        int count=0;
        
         for (int i = 0; i < 7; i++)
         {
            user=HealthApp.user;
            LocalDate date = today.minusDays(i);

            // Use the getOrDefault method to handle missing values, default to 0
            Integer value = user.getSugerLevel().getOrDefault(date, 0);

            if (value != 0){
                count++;  // Only count non-zero values for the average
            }
           total += value;
        }
        // Calculate the average (only divide by the count of non-zero values)
        double average = count > 0 ? (double) total / count : 0;
        
        avgSuger=average;
        
    }
    
    public  static void calculateAvgPressure(){
        int total=0;
        int count=0;
        
         for (int i = 0; i < 7; i++)
         {
            LocalDate date = today.minusDays(i);
             user=HealthApp.user;
            // Use the getOrDefault method to handle missing values, default to 0
            Integer value = user.getPressureLevel().getOrDefault(date, 0);

            if (value != 0){
                count++;  // Only count non-zero values for the average
            }
           total += value;
        }
        // Calculate the average (only divide by the count of non-zero values)
        double average = count > 0 ? (double) total / count : 0;
        
        avgPressure=average;
        
    }
    
    public static void calculateAvgBurning(){
        int total=0;
        int count=0;
        int value=0;
        
         for (int i = 0; i < 7; i++)
         {
            LocalDate date = today.minusDays(i);
             user=HealthApp.user;
            // Use the getOrDefault method to handle missing values, default to 0
            Integer value1 = user.getWalking().getOrDefault(date, 0);
            Integer value2 = user.getSwimming().getOrDefault(date, 0);
            Integer value3 = user.getRunning().getOrDefault(date, 0);
            Integer value4 = user.getExercise().getOrDefault(date, 0);

            value= value1+value2+value3+value4;
            total+=value;
            if (value != 0){
                count++;
        }
        // Calculate the average (only divide by the count of non-zero values)
        double average = count > 0 ? (double) total / count : 0;
        
        avgBurning=average;
        
    }
 }
    
    public static void calculateAvgIntake(){
        int total=0;
        int count=0;
        
        
         for (int i = 0; i < 7; i++)
         {
            LocalDate date = today.minusDays(i);
             user=HealthApp.user;
            // Use the getOrDefault method to handle missing values, default to 0
            Integer value1 = user.getCaloriesTaken().getOrDefault(date, 0);
            total += value1;
            
            if (value1!= 0){
                count++;
        }

            
        }
       
       // Calculate the average (only divide by the count of non-zero values)
        double average = count > 0 ? (double) total / count : 0;
        
        avgIntake=average;
        
    }
    
    public static String getAvgSugerLevel(){
        calculateAvgSuger();
        String value = String.format("%.2f", avgSuger);
        return value;
    }
    
    public static String getAvgPressureLevel(){
        calculateAvgPressure();
        String value = String.format("%.2f", avgPressure);
        return value;
    }
    
    public static String getAvgBurning(){
        calculateAvgBurning();
        String value = String.format("%.2f", avgBurning);
        return value;
    }
    
    public static  String getAvgIntake(){
        calculateAvgIntake();
        String value = String.format("%.2f", avgIntake);
        return value;
    }
    
    public static String getSugerWarning() {
        double sugarLevel= avgSuger;
       
                if (sugarLevel < 7) {
            return "Whoa there, buddy! Your sugar level's so low, even a candy can't find it. Time to consult a doctor before you start fainting like a character in one of those sad romance dramas!";
        } else if (sugarLevel >= 7 && sugarLevel <= 10) {
            return "Hey, look at you! Normal blood sugar level! Keep it up, and maybe you can treat yourself to some sweets—just don’t turn into a sugar monster like me!";
        } else if (sugarLevel > 10 && sugarLevel <= 12.5) {
            return "Uh-oh, pre-diabetes, huh? Time to lay off the donuts, my friend. You don’t want to end up like me, juggling sweets while dodging health problems. Get your diet in check and maybe do a few push-ups… or just chase after a few snacks!";
        } else if (sugarLevel > 12.5) {
            return "Yikes! High blood sugar? You’re one step away from turning into a walking dessert! Seriously, consult a healthcare provider before you end up as a human sugar cube. Don’t be like me—try to stay out of trouble!";
        } else {
            return "Invalid sugar level? Come on, are you trying to measure it with a spoon or something? Double-check it, or I might have to send you to the 'How to Measure Sugar Levels 101' class!";
        }

    }
    
    public static String getSystolicBloodPressureWarning() {
    double systolicPressure = avgPressure;  // Assuming avgSystolic is the variable

    if (systolicPressure < 90) {
    return "Low blood pressure (systolic)? You must be floating around like a ghost! Time to consult a doctor before you become a permanent resident in the 'I feel faint' club!";
} 
else if (systolicPressure >= 90 && systolicPressure <= 120) {
    return "Normal blood pressure (systolic)! You're doing great! Keep it up, and maybe reward yourself with some sweets—just don’t overdo it like I do!";
} 
else if (systolicPressure >= 121 && systolicPressure <= 139) {
    return "Prehypertension (systolic), huh? Time to take care of your health before it gets out of hand. Don’t end up like me, juggling sweets and stress!";
} 
else if (systolicPressure >= 140) {
    return "High blood pressure (systolic)? Yikes! Consult a healthcare provider immediately before you start shooting steam like a boiling kettle!";
} 
else {
    return "Invalid blood pressure value? Are you measuring it with a rubber band? Double-check it, or I might have to send you to 'Blood Pressure Measurement 101'!";
}

    
    }
    
    public static String getDailyCalorieIntakeWarning() {
    double dailyCalories = avgIntake;  

    if (dailyCalories < 1200) {
    return "Whoa! Calorie intake is too low. You might turn into a walking skeleton! Consult a nutritionist before you start dreaming about food.";
} else if (dailyCalories >= 1200 && dailyCalories <= 2000) {
    return "Calorie intake is normal! Great job! Just remember, balance is key—don’t go overboard or you might end up like me, surrounded by snacks!";
} else if (dailyCalories > 2000 && dailyCalories <= 2500) {
    return "Calorie intake is high! You might want to manage those portions unless you're planning to enter a food-eating contest. Just don’t forget to move around a bit!";
} else if (dailyCalories > 2500) {
    return "Whoa there! Calorie intake is excessive! Time to review your diet before you end up as a human piñata—full of treats but in trouble!";
} else {
    return "Invalid calorie value? Are you counting calories or playing a game? Double-check it, or I might have to enroll you in 'Calorie Counting 101'!";
}

}
    
    public static String getActivityLevel(){
      double caloriesBurned=avgBurning;
    if (caloriesBurned < 500) {
    return "You’re as sedentary as a cat napping in the sun! Time to get off that couch and add some physical activity to your routine before you become part of the furniture!";
} else if (caloriesBurned >= 500 && caloriesBurned <= 1000) {
    return "You’re lightly active! A good start, but don’t just stop there—let’s crank it up! Maybe run from your problems or at least to the snack bar!";
} else if (caloriesBurned > 1000 && caloriesBurned <= 2000) {
    return "You’re moderately active! Great job! Keep this up, and you might just outpace me when I’m running to grab my favorite sweets!";
} else if (caloriesBurned > 2000) {
    return "You’re highly active! Excellent work! At this rate, you’re basically a fitness superhero! Just don’t forget to reward yourself with some snacks once in a while!";
} else {
    return "Invalid calorie burn value? Did you accidentally use a magic wand instead of a calculator? Double-check it, or I might have to sign you up for 'How to Count Calories 101'!";
}

}
    
}
