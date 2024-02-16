package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

public class HealthMetricsData implements Serializable {

    private static final long serialVersionUID = 1L;

    private BloodPressureData theBloodPressureData;
    private BMIData theBMIData;
    private CholesterolData theCholesterolData;
    private GlucoseData theGlucoseData;

    public HealthMetricsData() {
        theBloodPressureData = new BloodPressureData();
        theBMIData = new BMIData();
        theCholesterolData = new CholesterolData();
        theGlucoseData = new GlucoseData();
    }
}
