package dev.lpa;

public class Appointment {

    Person patient;
    Person doctor;
    String time;
    AppointmentStatus status;

    public enum AppointmentStatus {SCHEDULED, COMPLETED, CANCELLED}

    public Appointment(Person patient, Person doctor, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public Person getPatient() {
        return patient;
    }

    public Person getDoctor() {
        return doctor;
    }

    public String getTime() {
        return time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setAppointmentStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getDetails() {
        return "Appointment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", time='" + time + '\'' +
                ", status=" + status +
                '}';
    }
}
