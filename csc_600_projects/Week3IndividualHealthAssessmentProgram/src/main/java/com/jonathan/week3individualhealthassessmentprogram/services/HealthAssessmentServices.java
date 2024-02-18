package com.jonathan.week3individualhealthassessmentprogram.services;

import com.jonathan.week3individualhealthassessmentprogram.datamodel.*;

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

    private static final List<String> GLUCOSE_CATEGORIES = Arrays.asList(
            "Excellent",
            "Good",
            "Marginal",
            "Poor",
            "Out of control"
    );

    private static final List<String> CHOLESTEROL_CATEGORIES = Arrays.asList(
            "Excellent", // Total Cholesterol < 200
            "Borderline", // Total Cholesterol 200-239
            "High" // Total Cholesterol >= 240
    );

    private static final List<String> TRIGLYCERIDE_CATEGORIES = Arrays.asList(
            "Normal", // Triglycerides < 150
            "Borderline", // Triglycerides 150-199
            "High", // Triglycerides 200-499
            "Very High" // Triglycerides >= 500
    );

    private static final List<String> HDL_CATEGORIES = Arrays.asList(
            "Poor", // HDL < 40
            "Good" // HDL >= 40
    );

    private static final List<String> LDL_CATEGORIES = Arrays.asList(
            "Optimal", // LDL < 100
            "Near Optimal", // LDL 100-129
            "Borderline", // LDL 130-159
            "High", // LDL 160-189
            "Very High" // LDL >= 190
    );

    public HealthAssessmentServices() {
        this.adviceNotification = new StringBuilder();
    }

    public String generateHealthEvaluationReport(PatientData thePatientData) {
        StringBuilder healthEvaluationReport = new StringBuilder();

        // Obtain patient data
        String firstName = thePatientData.getFirstName();
        String lastName = thePatientData.getLastName();
        long patientID = thePatientData.getPatientID();

        // Obtain BMI data
        float height = thePatientData.getBMIData().getHeight();
        float weight = thePatientData.getBMIData().getWeight();
        float BMI = thePatientData.getBMIData().getBMI();
        String BMICategory = thePatientData.getBMIData().getBMICategory();

        // Obtain blood pressure data
        int bloodPressure = thePatientData.getTheBloodPressureData().getBloodPressure();
        String bloodPressureCategory = thePatientData.getTheBloodPressureData().getBloodPressureCategory();

        // Obtain glucose data
        int glucose = thePatientData.getTheGlucoseData().getGlucose();
        String glucoseCategory = thePatientData.getTheGlucoseData().getGlucoseCategory();

        // Obtain cholesterol data
        CholesterolData theCholesterolData = thePatientData.getTheCholesterolData();
        int totalCholesterol = theCholesterolData.getCholesterol();
        String cholesterolCategory = theCholesterolData.getCholesterolCategory();
        int hdl = theCholesterolData.getHdl();
        String hdlCategory = theCholesterolData.getHdlCategory();
        int ldl = theCholesterolData.getLdl();
        String ldlCategory = theCholesterolData.getLdlCategory();
        int triglycerides = theCholesterolData.getTriglycerides();
        String triglyceridesCategory = theCholesterolData.getTriglyceridesCategory();

        healthEvaluationReport.append(" =============================================================\n");
        healthEvaluationReport.append("                                                    HEALTH EVALUATION REPORT\n");
        healthEvaluationReport.append(" =============================================================\n\n");
        healthEvaluationReport.append("> PATIENT NAME: \t\t\t" + firstName + " " + lastName +"\n");
        healthEvaluationReport.append("> PATIENT ID: \t\t\t\t" + patientID + "\n");
        healthEvaluationReport.append("> HEIGHT (m): \t\t\t" + height + "\n");
        healthEvaluationReport.append("> WEIGHT (kg):\t\t\t" + weight + "\n");
        healthEvaluationReport.append("> BMI: \t\t\t\t\t" + String.format("%.2f", BMI) + " ("+ BMICategory + ")\n");
        healthEvaluationReport.append("> BLOOD PRESSURE:\t\t" + bloodPressure + " ("+ bloodPressureCategory + ")\n");
        healthEvaluationReport.append("> BLOOD GLUCOSE:\t\t" + glucose + " ("+ glucoseCategory + ")\n");
        healthEvaluationReport.append("> HDL (Good):\t\t\t\t" + hdl + " ("+ hdlCategory + ")\n");
        healthEvaluationReport.append("> LDL (Bad):\t\t\t\t" + ldl + " ("+ ldlCategory + ")\n");
        healthEvaluationReport.append("> TRIGLYCERIDES:\t\t\t" + triglycerides + " ("+ triglyceridesCategory + ")\n");
        healthEvaluationReport.append("> TOTAL CHOLESTEROL:\t\t" + totalCholesterol + " ("+ cholesterolCategory + ")");

        return healthEvaluationReport.toString();

    }

    public void calculateAllHealthMetrics(PatientData patientData) {
        // Set any previous messages to zero / nothing.
        adviceNotification.setLength(0);
        calculateBMICategory(patientData.getBMIData());
        calculateBloodPressureCategory(patientData.getTheBloodPressureData());
        calculateGlucoseCategory(patientData.getTheGlucoseData());

        CholesterolData theCholesterolData = patientData.getTheCholesterolData();

        calculateTotalCholesterol(theCholesterolData);
        calculateHDLCategory(theCholesterolData);
        calculateLDLCategory(theCholesterolData);
        calculateTriglyceridesCategory(theCholesterolData);
        calculateCholesterolCategory(theCholesterolData);

    }

    public void calculateTotalCholesterol(CholesterolData theCholesterolData) {
        int ldl = theCholesterolData.getLdl();
        int hdl = theCholesterolData.getHdl();
        int triglycerides = theCholesterolData.getTriglycerides();

        int totalCholesterol = ldl + hdl + (triglycerides / 5);
        theCholesterolData.setCholesterol(totalCholesterol);

    }

    public void calculateCholesterolCategory(CholesterolData theCholesterolData) {
        int cholesterol = theCholesterolData.getCholesterol();
        String category;

        if (cholesterol < 200) {
            category = CHOLESTEROL_CATEGORIES.get(0);
        } else if (cholesterol <= 239) {
            category = CHOLESTEROL_CATEGORIES.get(1);
        } else {
            category = CHOLESTEROL_CATEGORIES.get(2);
            adviceNotification.append("Your total cholesterol is " + cholesterol + "("+ category + ").\n");
        }

        theCholesterolData.setCholesterolCategory(category);
    }

    public void calculateTriglyceridesCategory(CholesterolData theCholesterolData) {
        int triglycerides = theCholesterolData.getTriglycerides();
        String category;

        if (triglycerides < 150) {
            category = TRIGLYCERIDE_CATEGORIES.get(0);
        } else if (triglycerides <= 199) {
            category = TRIGLYCERIDE_CATEGORIES.get(1);
        } else if (triglycerides <= 499) {
            category = TRIGLYCERIDE_CATEGORIES.get(2);
        } else {
            category = TRIGLYCERIDE_CATEGORIES.get(3);
            adviceNotification.append("Your triglycerides are " + triglycerides + "("+ category + ").\n");
        }

        theCholesterolData.setTriglyceridesCategory(category);
    }

    public void calculateHDLCategory(CholesterolData theCholesterolData) {
        int hdl = theCholesterolData.getHdl();
        String category;

        if (hdl >= 40) {
            category = HDL_CATEGORIES.get(1);
        } else {
            category = HDL_CATEGORIES.get(0);
            adviceNotification.append("Your HDL is " + hdl + "("+ category + ").\n");
        }

        theCholesterolData.setHdlCategory(category);
    }

    public void calculateLDLCategory(CholesterolData theCholesterolData) {
        int ldl = theCholesterolData.getLdl();
        String category;

        if (ldl < 100) {
            category = LDL_CATEGORIES.get(0);
        } else if (ldl <= 129) {
            category = LDL_CATEGORIES.get(1);
        } else if (ldl <= 159) {
            category = LDL_CATEGORIES.get(2);
        } else if (ldl <= 189) {
            category = LDL_CATEGORIES.get(3);
        } else {
            category = LDL_CATEGORIES.get(4);
            adviceNotification.append("Your LDL is " + ldl + "("+ category + ").\n");
        }

        theCholesterolData.setLdlCategory(category);
    }


    public void calculateGlucoseCategory(GlucoseData theGlucoseData) {
        int glucoseLevel = theGlucoseData.getGlucose();
        String category = "";

        if (glucoseLevel >= 340) {
            category = GLUCOSE_CATEGORIES.get(4); // Out of control
            adviceNotification.append("Your blood glucose level is " + glucoseLevel + " (out of control).\n");
        } else if (glucoseLevel >= 270) {
            category = GLUCOSE_CATEGORIES.get(3); // Poor
        } else if (glucoseLevel >= 210) {
            category = GLUCOSE_CATEGORIES.get(2); // Marginal
        } else if (glucoseLevel >= 150) {
            category = GLUCOSE_CATEGORIES.get(1); // Good
        } else if (glucoseLevel >= 80) {
            category = GLUCOSE_CATEGORIES.get(0); // Excellent
        }

        System.out.println("Blood Glucose Category: " + category);
        theGlucoseData.setGlucoseCategory(category); // Assuming there's a method setGlucoseCategory() to save the category
    }


    public void calculateBloodPressureCategory(BloodPressureData theBloodPressureData) {
        int systolicBP = theBloodPressureData.getBloodPressure();
        String category = "";

        if (systolicBP >= 210) {
            category = BLOOD_PRESSURE_CATEGORIES.get(5); // Very Severe
            adviceNotification.append("Your blood pressure is above 210 (very severe).\n");
        } else if (systolicBP >= 180) {
            category = BLOOD_PRESSURE_CATEGORIES.get(4); // Severe
        } else if (systolicBP >= 160) {
            category = BLOOD_PRESSURE_CATEGORIES.get(3); // Moderate
        } else if (systolicBP >= 140) {
            category = BLOOD_PRESSURE_CATEGORIES.get(2); // Mild
        } else if (systolicBP >= 90) {
            category = BLOOD_PRESSURE_CATEGORIES.get(1); // Normal
        } else if (systolicBP >= 50) {
            category = BLOOD_PRESSURE_CATEGORIES.get(0); // Low
            adviceNotification.append("Your blood pressure is below 50 (low).\n");
        }

        System.out.println("Blood Pressure Category: " + category);
        theBloodPressureData.setBloodPressureCategory(category); // Assuming there's a method setBloodPressureCategory() to save the category
    }


    public void calculateBMICategory(BMIData theBMIData) {
        float bmiValue = calculateBMI(theBMIData.getWeight(), theBMIData.getHeight());
        theBMIData.setBMI(bmiValue);

        String category;

        if (bmiValue < 18.5) {
            category = BMI_CATEGORIES.get(0);
            adviceNotification.append("Your BMI is below 18.5 (underweight).\n");
        } else if (bmiValue <= 24.9) {
            category = BMI_CATEGORIES.get(1);
        } else if (bmiValue <= 29.9) {
            category = BMI_CATEGORIES.get(2);
        } else { // BMI > 30 is considered Obese
            category = BMI_CATEGORIES.get(3);
            adviceNotification.append("Your BMI is above 30 (obese).\n");
        }

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
