package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

// Data class for blood pressure related information
public class BloodPressureData implements Serializable {

    private static final long serialVersionUID = 1L;
    private int bloodPressure;
    private String bloodPressureCategory;

    public BloodPressureData() {

    }

    // Getters / setters
    public int getBloodPressure() {
        return bloodPressure;
    }

    public String getBloodPressureCategory() {
        return bloodPressureCategory;
    }

    public void setBloodPressureCategory(String bloodPressureCategory) {
        this.bloodPressureCategory = bloodPressureCategory;
    }

    // Checks to make sure blood pressure is within reasonable range
    public boolean setBloodPressure(int bloodPressure) {
        if (bloodPressure > 0 && bloodPressure < 250) {
            this.bloodPressure = bloodPressure;
            return true;
        } else {
            return false;
        }
    }
}
