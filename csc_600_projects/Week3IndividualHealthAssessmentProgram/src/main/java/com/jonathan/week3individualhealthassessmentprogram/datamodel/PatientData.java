package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import com.jonathan.week3individualhealthassessmentprogram.services.HealthAssessmentServices;

import java.io.Serial;
import java.io.Serializable;

public class PatientData implements Serializable {

    private String firstName;
    private String lastName;

    private static final long serialVersionUID = 1L;
    private int patientID;
    private static int lastPatientID = 1;
    private HealthMetricsData theHealthMetricsData;

    public PatientData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        patientID = lastPatientID++;
        theHealthMetricsData = new HealthMetricsData();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPatientID() {
        return patientID;
    }
}
