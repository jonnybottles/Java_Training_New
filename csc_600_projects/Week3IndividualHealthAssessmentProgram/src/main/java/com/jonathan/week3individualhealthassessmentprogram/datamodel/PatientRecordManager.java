package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.*;

public class PatientRecordManager {

    public PatientRecordManager() {
    }

    public boolean savePatientData(PatientData patientData, String filename) {
        // Ensure the filename ends with .ser
        String serializedFileName = filename.endsWith(".ser") ? filename : filename + ".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializedFileName))) {
            oos.writeObject(patientData);
            return true; // Return true if the operation is successful
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing patient object to " + serializedFileName + ": " + e.getMessage());
            return false; // Return false if an exception occurs
        }
    }

    public PatientData loadPatientData(String filename) throws IOException, ClassNotFoundException {
        // Ensure the filename ends with .ser
        String serializedFileName = filename.endsWith(".ser") ? filename : filename + ".ser";
        File file = new File(serializedFileName);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (PatientData) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error reading patient object from " + serializedFileName + ": " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("File " + serializedFileName + " does not exist.");
            return null;
        }
    }
}

