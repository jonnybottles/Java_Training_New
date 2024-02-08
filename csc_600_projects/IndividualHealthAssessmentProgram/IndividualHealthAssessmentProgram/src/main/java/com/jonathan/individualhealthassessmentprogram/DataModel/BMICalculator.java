package com.jonathan.individualhealthassessmentprogram.DataModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Class that contains the properties and methods for calculating a users BMI
public class BMICalculator {

    private float weight;
    private float height;
    private float BMI;
    private List<String> BMIStrings;

    // Constructor that initializes the BMIStrings arrays list and sets the values
    // for the BMI Categories
    public BMICalculator() {
        this.BMIStrings = new ArrayList<>(Arrays.asList(
                "Seriously Underweight",
                "Underweight",
                "Normal Weight",
                "Overweight",
                "Obese"));
    }


    public float getBMIFloat() {
        return BMI;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    // Returns string formatted version of the users BMI value.
    public String getBMIString() {
        if (BMI == 0) {
            calculateBMI();
            if (BMI == 0) {
                return "N/A";
            }
        }
        return String.format("%.2f", BMI);
    }

    // Calculates BMI value.
    public void calculateBMI() {

        if (height != 0 && weight != 0) {
            BMI = weight / (height * height);
        } else {
            System.out.println("Height and weight must be set prior to calculating BMI.");
        }
    }

    // Returns BMI string category based upon BMI value.
    public String getBMICategory() {
        int listIndex = -1;
        if (BMI == 0) {
            System.out.println("BMI was never calculated and is set to zero.");
            return "N/A";
        } else if (BMI < 18) {
            listIndex = 0;
        } else if (BMI < 18.5) {
            listIndex = 1;
        } else if (BMI <= 24.9) {
            listIndex = 2;
        } else if (BMI <= 29.9) {
            listIndex = 3;
        } else {
            listIndex = 4;
        }

        return BMIStrings.get(listIndex);
    }



}
