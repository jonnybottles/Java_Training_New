package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

public class BloodPressureData implements Serializable {

    private static final long serialVersionUID = 1L;
    private int bloodPressure;
    private String bloodPressureCategory;

    public BloodPressureData() {

    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public String getBloodPressureCategory() {
        return bloodPressureCategory;
    }

    public void setBloodPressureCategory(String bloodPressureCategory) {
        this.bloodPressureCategory = bloodPressureCategory;
    }

    // Setter for blood pressure
    public boolean setBloodPressure(int bloodPressure) {
        if (bloodPressure > 0 && bloodPressure < 250) {
            this.bloodPressure = bloodPressure;
            return true;
        } else {
            return false;
        }
    }
}
