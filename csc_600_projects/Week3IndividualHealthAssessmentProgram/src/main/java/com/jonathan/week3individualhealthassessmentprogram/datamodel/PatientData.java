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

    private BloodPressureData theBloodPressureData;
    private BMIData theBMIData;
    private CholesterolData theCholesterolData;
    private GlucoseData theGlucoseData;


    public PatientData(BMIData BMIData, BloodPressureData bloodPressureData,
                       CholesterolData cholesterolData, GlucoseData glucoseData) {

        this.patientID = lastPatientID++;
        this.theBMIData = BMIData;

        this.theBloodPressureData = bloodPressureData;
        this.theCholesterolData = cholesterolData;
        this.theGlucoseData = glucoseData;


    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            return false;
        }
        this.firstName = firstName;
        return true;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            return false;
        }
        this.lastName = lastName;
        return true;
    }

    public int getPatientID() {
        return patientID;
    }

    public BMIData getBMIData() {
        return theBMIData;
    }

    public BloodPressureData getTheBloodPressureData() {
        return theBloodPressureData;
    }

    public BMIData getTheBMIData() {
        return theBMIData;
    }

    public CholesterolData getTheCholesterolData() {
        return theCholesterolData;
    }

    public GlucoseData getTheGlucoseData() {
        return theGlucoseData;
    }
}
