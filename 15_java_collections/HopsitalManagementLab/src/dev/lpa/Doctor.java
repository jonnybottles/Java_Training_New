package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{
    private Specialty specialty;
    private List<Patient> patients;

    public enum Specialty {GENERAL_MEDICINE, CARDIOLOGY, NEUROLOGY, DERMATOLOGY}

    public Doctor(String name, String contactInfo, Specialty specialty) {
        this(name, contactInfo);
        this.specialty = specialty;
    }

    public Doctor(String name, String contactInfo) {
        super(name, contactInfo);
        this.patients = new ArrayList<>();
        this.specialty = Specialty.GENERAL_MEDICINE;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public List<Patient> getPatients() {
        return patients;
    }


    public boolean addPatient(Patient patient) {
        if (findPatient(patient)) {
            System.out.println("Patient already exists.");
            return false;
        }

        patients.add(patient);
        return true;
    }

    private boolean findPatient(Patient patient) {
        return patients.contains(patient);
    }



}
