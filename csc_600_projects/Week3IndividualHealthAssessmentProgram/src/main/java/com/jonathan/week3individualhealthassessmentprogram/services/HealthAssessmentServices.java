package com.jonathan.week3individualhealthassessmentprogram.services;

import com.jonathan.week3individualhealthassessmentprogram.datamodel.BMIData;
import com.jonathan.week3individualhealthassessmentprogram.datamodel.BloodPressureData;
import com.jonathan.week3individualhealthassessmentprogram.datamodel.PatientData;

import java.util.Arrays;
import java.util.List;

public class HealthAssessmentServices {

    private StringBuilder adviceNotification;

    private static final List<String> BMI_CATEGORIES = Arrays.asList(
            "Underweight", // BMI < 18.5
            "Normal Weight", // BMI = 18.5 – 24.9
            "Overweight", // BMI = 25.0 -  29.9
            "Obese" // BMI > 30
    );

    private static final List<String> BLOOD_PRESSURE_CATEGORIES = Arrays.asList(
            "Low",
            "Normal",
            "Mild",
            "Moderate",
            "Severe",
            "Very Severe"
    );

    public HealthAssessmentServices() {
        this.adviceNotification = new StringBuilder();
    }

    public void calculateAllHealthMetrics(PatientData patientData) {
        // Set any previous messages to zero / nothing.
        adviceNotification.setLength(0);
        calculateBMICategory(patientData.getBMIData());
        // Include calls to other health metric assessment methods as they are implemented
        // For example:
        // calculateBloodPressureAndAppendAdvice(healthMetricsData.getBloodPressureData());
    }

    public void calculateBloodPressureCategory(BloodPressureData theBloodPressureData) {
        int bloodPressure = theBloodPressureData.getBloodPressure();
        String category;

//        if (bloodPressure <= )

    }

    public void calculateBMICategory(BMIData theBMIData) {
        float bmiValue = calculateBMI(theBMIData.getWeight(), theBMIData.getHeight());
        String category;

        if (bmiValue < 18.5) {
            category = BMI_CATEGORIES.get(0);
            adviceNotification.append("Your BMI is below 18.5, considered underweight. Please consult a doctor. ");
        } else if (bmiValue <= 24.9) {
            category = BMI_CATEGORIES.get(1);
        } else if (bmiValue <= 29.9) {
            category = BMI_CATEGORIES.get(2);
        } else { // BMI > 30 is considered Obese
            category = BMI_CATEGORIES.get(3);
            adviceNotification.append("Your BMI is above 30, considered obese. Please consult a doctor. ");
        }

        // Optionally log or print the category for debugging or UI display
        System.out.println("BMI Category: " + category);
        theBMIData.setBMICategory(category);
    }


    private float calculateBMI(float weight, float height) {
        return weight / (height * height);
    }

    // Method to get the accumulated advice
    public String getAdviceNotification() {
        return adviceNotification.toString();
    }

    // Method to reset the adviceNotification for a new patient or assessment
    public void resetAdviceNotification() {
        adviceNotification.setLength(0);
    }


}
