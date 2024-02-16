package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

public class BMIData implements Serializable {
    private static final long serialVersionUID = 1L;

    private float weight;
    private float height;

    public BMIData(float weight, float height) {
        this.weight = weight;
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

