/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.Index;

//import foodtrackerapp.Index.*;

import healthapp.User;


/**
 *
 * @author tosha
 */

    public class HealthMetrics {
    private double weight; // in kilograms
    private double height; // in meters
    private int age;       // in years
    private double neck;   // in centimeters
    private double waist;  // in centimeters
    private String sex;    // "male" or "female"

    // Constructor
    public HealthMetrics(User user) {
        this.weight = (double)user.getWeight();
        this.height = (double)user.getHeight()/100;
        this.age =  user.getAge();
        this.neck =(double) user.getNeck();
        this.waist = (double) user.getWaist();
        this.sex = user.getSex();
    }

    // Getter for BMI
    public double getBMI() {
        return weight / (height * height);
    }

    // Getter for BMR (Basal Metabolic Rate)
    public double getBMR() {
        if (sex.equalsIgnoreCase("Male")) {
            return 88.362 + (13.397 * weight) + (4.799 * (height * 100)) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * (height * 100)) - (4.330 * age);
        }
    }

    // Getter for Ideal Weight (Devine Formula)
    public double getIdealWeight() {
        if (sex.equalsIgnoreCase("Male")) {
            return 50 + 2.3 * ((height * 100) / 2.54 - 60);
        } else {
            return 45.5 + 2.3 * ((height * 100) / 2.54 - 60);
        }
    }

    // Getter for Body Fat Percentage
    /*public double getBodyFat() {
        if (sex.equalsIgnoreCase("Male")) {
            return 495 / (1.0324 - 0.19077 * Math.log10(waist - neck) + 0.15456 * Math.log10(height * 100)) - 450;
        } else {
            //System.out.println(getBodyFat());
            return 495 / (1.29579 - 0.35004 * Math.log10(waist + neck - height * 100) + 0.22100 * Math.log10(height * 100)) - 450;
            //return 0;
        }
    }*/
    
    public double getBodyFat() {
    double bmi = getBMI(); // Use existing getBMI() method
    int sexFactor = sex.equalsIgnoreCase("Male") ? 1 : 0;
    return (1.20 * bmi) + (0.23 * age) - (10.8 * sexFactor) - 5.4;
}

    // Custom message based on BMI
    public String getBMIStatus() {
        double bmi = getBMI();
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Healthy";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    // Custom message based on Body Fat Percentage
    public String getBodyFatStatus() {
        double bodyFat = getBodyFat();
        if (sex.equalsIgnoreCase("Male")) {
            if (bodyFat < 6) return "Essential Fat";
            else if (bodyFat < 14) return "Athletic";
            else if (bodyFat < 18) return "Fit";
            else if (bodyFat < 25) return "Acceptable";
            else return "Obese";
        } else {
            if (bodyFat < 14) return "Essential Fat";
            else if (bodyFat < 21) return "Athletic";
            else if (bodyFat < 25) return "Fit";
            else if (bodyFat < 32) return "Acceptable";
            else return "Obese";
        }
    }

    // Custom message based on waist-to-height ratio
    public String getWHtRStatus() {
        double whtr = waist / (height * 100); // Waist-to-height ratio
        if (whtr < 0.35) return "Low Risk";
        else if (whtr < 0.5) return "Healthy";
        else if (whtr < 0.6) return "Moderate Risk";
        else return "High Risk";
    }

    }
