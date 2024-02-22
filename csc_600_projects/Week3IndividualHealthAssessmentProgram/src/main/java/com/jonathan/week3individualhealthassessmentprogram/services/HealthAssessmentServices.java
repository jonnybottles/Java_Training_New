package com.jonathan.week3individualhealthassessmentprogram.services;

import com.jonathan.week3individualhealthassessmentprogram.datamodel.*;

import java.util.Arrays;
import java.util.List;

// Contains all the methods for interacting with datamodel objects and calculating associated
// health metric information
public class HealthAssessmentServices {

    // Used for accumulating health advisory notifications
    private StringBuilder adviceNotification;

    private static final List<String> BMI_CATEGORIES = Arrays.asList(
            "Underweight", //  < 18.5
            "Normal Weight", // 18.5 – 24.9
            "Overweight", // 25.0 -  29.9
            "Obese" // > 30
    );

    private static final List<String> BLOOD_PRESSURE_CATEGORIES = Arrays.asList(
            "Low", // < 50
            "Normal", // 50 - 90
            "Mild", // 91 - 139
            "Moderate", // 140 - 159
            "Severe", // 160 - 179
            "Very Severe" // >= 180
    );

    private static final List<String> GLUCOSE_CATEGORIES = Arrays.asList(
            "Excellent", // < 80
            "Good", // 80 - 149
            "Marginal", // 150 - 209
            "Poor", // 210 - 269
            "Out of control" // >= 270
    );


    private static final List<String> CHOLESTEROL_CATEGORIES = Arrays.asList(
            "Excellent", // < 200
            "Borderline", // 200-239
            "High" // >= 240
    );

    private static final List<String> TRIGLYCERIDE_CATEGORIES = Arrays.asList(
            "Normal", // < 150
            "Borderline", // 150-199
            "High", // 200-499
            "Very High" // >= 500
    );

    private static final List<String> HDL_CATEGORIES = Arrays.asList(
            "Poor", // < 40
            "Good" // >= 40
    );

    private static final List<String> LDL_CATEGORIES = Arrays.asList(
            "Optimal", // < 100
            "Near Optimal", // 100-129
            "Borderline", // 130-159
            "High", // 160-189
            "Very High" // >= 190
    );

    public HealthAssessmentServices() {
        this.adviceNotification = new StringBuilder();
    }

    // Creates a health assessment report using all data entered / calculated.
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

        // Creates report
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
        healthEvaluationReport.append("> HDL:\t\t\t\t\t" + hdl + " ("+ hdlCategory + ")\n");
        healthEvaluationReport.append("> LDL:\t\t\t\t\t" + ldl + " ("+ ldlCategory + ")\n");
        healthEvaluationReport.append("> TRIGLYCERIDES:\t\t\t" + triglycerides + " ("+ triglyceridesCategory + ")\n");
        healthEvaluationReport.append("> TOTAL CHOLESTEROL:\t\t" + totalCholesterol + " ("+ cholesterolCategory + ")");

        return healthEvaluationReport.toString();

    }

    // Calls all health metric calculation methods
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

    // Calculates total cholesterol
    public void calculateTotalCholesterol(CholesterolData theCholesterolData) {
        int ldl = theCholesterolData.getLdl();
        int hdl = theCholesterolData.getHdl();
        int triglycerides = theCholesterolData.getTriglycerides();

        int totalCholesterol = ldl + hdl + (triglycerides / 5);
        theCholesterolData.setCholesterol(totalCholesterol);

    }

    // Assesses cholesterol levels and assigns associated category
    public void calculateCholesterolCategory(CholesterolData theCholesterolData) {
        int cholesterol = theCholesterolData.getCholesterol();
        String category;

        if (cholesterol < 200) {
            category = CHOLESTEROL_CATEGORIES.get(0);
        } else if (cholesterol <= 239) {
            category = CHOLESTEROL_CATEGORIES.get(1);
        } else {
            category = CHOLESTEROL_CATEGORIES.get(2);
            // If levels are very high, append advice notification
            adviceNotification.append("Your total cholesterol is " + cholesterol + "("+ category + ").\n");
        }

        theCholesterolData.setCholesterolCategory(category);
    }

    // Assesses triglyceride levels and assigns associated category
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
            // If levels are very high, append advice notification
            adviceNotification.append("Your triglycerides are " + triglycerides + "("+ category + ").\n");
        }

        theCholesterolData.setTriglyceridesCategory(category);
    }

    // Assesses HDL levels and assigns associated category
    public void calculateHDLCategory(CholesterolData theCholesterolData) {
        int hdl = theCholesterolData.getHdl();
        String category;

        if (hdl >= 40) {
            category = HDL_CATEGORIES.get(1);
        } else {
            category = HDL_CATEGORIES.get(0);
            // If levels are out of range, append advice notification
            adviceNotification.append("Your HDL is " + hdl + "("+ category + ").\n");
        }

        theCholesterolData.setHdlCategory(category);
    }

    // Assesses LDL levels and assigns associated category
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
            // If levels are very high, append advice notification
            adviceNotification.append("Your LDL is " + ldl + "("+ category + ").\n");
        }

        theCholesterolData.setLdlCategory(category);
    }


    // Assesses glucose levels and assigns associated category
    public void calculateGlucoseCategory(GlucoseData theGlucoseData) {
        int glucoseLevel = theGlucoseData.getGlucose();
        String category = "";

        if (glucoseLevel >= 340) {
            category = GLUCOSE_CATEGORIES.get(4);
            // If levels are very high, append advice notification
            adviceNotification.append("Your blood glucose level is " + glucoseLevel + " (out of control).\n");
        } else if (glucoseLevel >= 270) {
            category = GLUCOSE_CATEGORIES.get(3);
        } else if (glucoseLevel >= 210) {
            category = GLUCOSE_CATEGORIES.get(2);
        } else if (glucoseLevel >= 150) {
            category = GLUCOSE_CATEGORIES.get(1);
        } else if (glucoseLevel >= 80) {
            category = GLUCOSE_CATEGORIES.get(0);
        }

        theGlucoseData.setGlucoseCategory(category);
    }

    // Assesses blood pressure and assigns associated category
    public void calculateBloodPressureCategory(BloodPressureData theBloodPressureData) {
        int systolicBP = theBloodPressureData.getBloodPressure();
        String category = "";

        if (systolicBP >= 210) {
            category = BLOOD_PRESSURE_CATEGORIES.get(5);
            // If levels are very high, append advice notification
            adviceNotification.append("Your blood pressure is above 210 (very severe).\n");
        } else if (systolicBP >= 180) {
            category = BLOOD_PRESSURE_CATEGORIES.get(4);
        } else if (systolicBP >= 160) {
            category = BLOOD_PRESSURE_CATEGORIES.get(3);
        } else if (systolicBP >= 140) {
            category = BLOOD_PRESSURE_CATEGORIES.get(2);
        } else if (systolicBP >= 90) {
            category = BLOOD_PRESSURE_CATEGORIES.get(1);
        } else if (systolicBP >= 50) {
            category = BLOOD_PRESSURE_CATEGORIES.get(0);
            // If levels are very low, append advice notification
            adviceNotification.append("Your blood pressure is below 50 (low).\n");
        }

        theBloodPressureData.setBloodPressureCategory(category);
    }


    // Assesses BMI and assigns associated category
    public void calculateBMICategory(BMIData theBMIData) {
        float bmiValue = calculateBMI(theBMIData.getWeight(), theBMIData.getHeight());
        theBMIData.setBMI(bmiValue);

        String category;

        if (bmiValue < 18.5) {
            category = BMI_CATEGORIES.get(0);
            // If BMI is very low, append advice notification
            adviceNotification.append("Your BMI is below 18.5 (underweight).\n");
        } else if (bmiValue <= 24.9) {
            category = BMI_CATEGORIES.get(1);
        } else if (bmiValue <= 29.9) {
            category = BMI_CATEGORIES.get(2);
        } else {
            category = BMI_CATEGORIES.get(3);
            // If BMI is very high, append advice notification
            adviceNotification.append("Your BMI is above 30 (obese).\n");
        }

        theBMIData.setBMICategory(category);
    }


    // Calculates BMI
    private float calculateBMI(float weight, float height) {
        return weight / (height * height);
    }

    // Method to get the accumulated advice
    public String getAdviceNotification() {
        return adviceNotification.toString();
    }


}
