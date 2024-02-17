package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

public class BloodPressureData implements Serializable {

    private static final long serialVersionUID = 1L;
    private int bloodPressure;

    public BloodPressureData() {

    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    // Setter for blood pressure
    public boolean setSystolic(int bloodPressure) {
        if (bloodPressure > 50 && bloodPressure < 250) {
            this.bloodPressure = bloodPressure;
            return true;
        } else {
            return false;
        }
    }
}
