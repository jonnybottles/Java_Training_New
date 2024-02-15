package com.jonathan.week3individualhealthassessmentprogram.datamodel;

public class PatientData {
    private String lastName;
    private String firstName;
    private int patientID;
    static int lastPatientID = 1;

    public PatientData(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        patientID = lastPatientID++;
    }
}
