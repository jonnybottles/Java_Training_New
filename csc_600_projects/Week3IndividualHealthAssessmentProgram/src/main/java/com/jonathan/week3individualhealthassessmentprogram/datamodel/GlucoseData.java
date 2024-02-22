package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

// Data class for glucose related information
public class GlucoseData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String glucoseCategory;
    private int glucose;

    public GlucoseData() {
    }


    // Getters / Setters
    public String getGlucoseCategory() {
        return glucoseCategory;
    }

    public void setGlucoseCategory(String glucoseCategory) {
        this.glucoseCategory = glucoseCategory;
    }

    public int getGlucose() {
        return glucose;
    }

    // Check to make sure glucose level is within reasonable range
    public boolean setGlucose(int glucose) {
        if (glucose > 0 && glucose < 400) {
            this.glucose = glucose;
            return true;
        }
        return false;
    }
}
