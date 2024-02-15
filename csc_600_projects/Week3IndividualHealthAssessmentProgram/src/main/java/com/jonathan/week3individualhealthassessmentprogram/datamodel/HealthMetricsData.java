package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

public class HealthMetricsData implements Serializable {

    private BMIData theBMIData;

    private static final long serialVersionUID = 1L;

    public HealthMetricsData() {
        theBMIData = new BMIData();
    }
}
