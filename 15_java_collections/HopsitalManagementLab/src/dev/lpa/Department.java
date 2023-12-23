package dev.lpa;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Department {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;
    List<Appointment> appointments;

    public Department(String name, List<Doctor> doctors, List<Patient> patients, List<Appointment> appointments) {
        this.name = name;
        this.doctors = doctors;
        this.patients = patients;
        this.appointments = appointments;
        this.doctors.sort(sortDoctorsBySpeciality());
        this.patients.sort(sortPatientsByNameThenID());
    }

    public String getName() {
        return name;
    }

    private Comparator<Doctor> sortDoctorsBySpeciality() {
        return Comparator.comparing(Doctor::getSpecialty);
    }

    private Comparator<Patient> sortPatientsByNameThenID() {
        return Comparator.comparing(Patient::getName).thenComparing(Patient::getID);
    }

    public String getDepartmentDetails() {
        StringBuilder deptDetails = new StringBuilder("Department Name " + name + "\n");
        deptDetails.append("\tDoctors: \n");
        for (Doctor doctor : doctors) {
            deptDetails.append("\t\t Name: ").append(doctor.getName()).append("\n");
            deptDetails.append("\t\t Speciality: ").append(doctor.getSpecialty()).append("\n");
        }
        deptDetails.append("\tPatients: \n");
        for (Patient patient: patients) {
            deptDetails.append("\t\t Name: ").append(patient.getName()).append("\n");
            deptDetails.append("\t\t ID: ").append(patient.getID()).append("\n");

        }
        deptDetails.append("\n");
        return deptDetails.toString();

    }

    public boolean scheduleAppointment(Appointment appointment) {
        // Additional logic can be implemented here, e.g., checking doctor availability
        this.appointments.add(appointment);
        return true; // Return value can indicate success of scheduling
    }
}
