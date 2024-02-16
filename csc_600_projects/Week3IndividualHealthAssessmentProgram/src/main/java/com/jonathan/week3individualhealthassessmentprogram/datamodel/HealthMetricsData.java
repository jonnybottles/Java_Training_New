package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

public class HealthMetricsData implements Serializable {

    private static final long serialVersionUID = 1L;

    private BloodPressureData theBloodPressureData;
    private BMIData theBMIData;
    private CholesterolData theCholesterolData;
    private GlucoseData theGlucoseData;

    public HealthMetricsData(BMIData bmiData) {
        theBloodPressureData = new BloodPressureData();
        theBMIData = bmiData;
        theCholesterolData = new CholesterolData();
        theGlucoseData = new GlucoseData();
    }

    public BMIData getBMIData() {
        return theBMIData;
    }
}
