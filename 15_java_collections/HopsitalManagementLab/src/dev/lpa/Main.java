package dev.lpa;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create Doctors
        Doctor doctor1 = new Doctor("Dr. Smith", "123456789", Doctor.Specialty.CARDIOLOGY);
        Doctor doctor2 = new Doctor("Dr. Johnson", "987654321", Doctor.Specialty.NEUROLOGY);
        Doctor doctor3 = new Doctor("Dr. Williams",  "222333444", Doctor.Specialty.DERMATOLOGY);
        Doctor doctor4 = new Doctor("Dr. Brown", "555666777", Doctor.Specialty.CARDIOLOGY);
        Doctor doctor5 = new Doctor("Dr. Davis", "888999000", Doctor.Specialty.NEUROLOGY);

        Patient patient4 = new Patient("John",  "111333555");
        patient4.addCondition(Patient.HealthCondition.CHRONES_DISEASE);

        // Create Patients
        Patient patient1 = new Patient("John",  "1112223333");
        patient1.addCondition(Patient.HealthCondition.DIABETES);
        patient1.addCondition(Patient.HealthCondition.CANCER);

        Patient patient2 = new Patient("John",  "4445556666");
        patient2.addCondition(Patient.HealthCondition.ANXIETY);

        Patient patient3 = new Patient("John", "777888999");
        patient3.addCondition(Patient.HealthCondition.BAD_HEARING);


        // Create Appointments
        Appointment appointment1 = new Appointment(patient1, doctor1, "2023-12-25 10:00");
        Appointment appointment2 = new Appointment(patient2, doctor2, "2023-12-26 11:00");
        Appointment appointment3 = new Appointment(patient3, doctor3, "2023-12-27 09:30");
        Appointment appointment4 = new Appointment(patient4, doctor4, "2023-12-28 14:00");

        // Create Departments
        Department cardiology = new Department("Cardiology", Arrays.asList(doctor1, doctor4), Arrays.asList(patient1, patient4), Arrays.asList(appointment1, appointment4));
        Department neurology = new Department("Neurology", Arrays.asList(doctor2, doctor5), Arrays.asList(patient2, patient3), Arrays.asList(appointment2, appointment3));
        Department dermatology = new Department("Dermatology", Arrays.asList(doctor3), Arrays.asList(), Arrays.asList());

        // Hospital Management
        HospitalManagement hospitalManagement = new HospitalManagement();
        hospitalManagement.addDepartment(cardiology);
        hospitalManagement.addDepartment(neurology);
        hospitalManagement.addDepartment(dermatology);

        // Display Department Details
        System.out.println(hospitalManagement.getDepartmentInfo("Cardiology"));
        System.out.println(hospitalManagement.getDepartmentInfo("Neurology"));
        System.out.println(hospitalManagement.getDepartmentInfo("Dermatology"));

        // Display All Departments Details
        System.out.println("All Departments Details:");
        System.out.println(hospitalManagement.getAllDepartmentsDetails());
    }
}
