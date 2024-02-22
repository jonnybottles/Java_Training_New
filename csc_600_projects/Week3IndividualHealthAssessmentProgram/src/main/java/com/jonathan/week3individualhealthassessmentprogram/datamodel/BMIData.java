package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

// Data class for BMI related information
public class BMIData implements Serializable {
    private static final long serialVersionUID = 1L;

    private float weight;
    private float height;
    private float BMI;

    private String BMICategory;

    public BMIData() {
        this.weight = weight;
        this.height = height;
    }

    // Getters / setters
    public float getWeight() {
        return weight;
    }

    public boolean setWeight(float weight) {
        if (weight > 0) {
            this.weight = weight;
            return true;
        } else {
            return false;
        }
    }

    public float getHeight() {
        return height;
    }

    public boolean setHeight(float height) {
        if (height > 0) {
            this.height = height;
            return true;
        } else {
            return false;
        }
    }

    public void setBMI(float BMI) {
        this.BMI = BMI;
    }

    public float getBMI() {
        return BMI;
    }

    public void setBMICategory(String BMICategory) {
        this.BMICategory = BMICategory;
    }

    public String getBMICategory() {
        return BMICategory;
    }
}

