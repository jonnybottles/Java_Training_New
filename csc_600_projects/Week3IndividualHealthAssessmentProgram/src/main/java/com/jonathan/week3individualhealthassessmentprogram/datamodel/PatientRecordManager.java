package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.*;

public class PatientRecordManager {

    public PatientRecordManager() {
    }

    public void savePatientData(PatientData patientData) {
        try (ObjectOutputStream f = new ObjectOutputStream
                (new FileOutputStream("patient" + patientData.getPatientID() + ".ser"))) {
            f.writeObject(patientData);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing patient object: " + e.getMessage());
        }
    }

    public PatientData loadPatientData(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename + ".ser");
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                return (PatientData) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error reading patient object: " + e.getMessage());
                throw e;
            }
        } else {
            return null;
        }
    }
}
