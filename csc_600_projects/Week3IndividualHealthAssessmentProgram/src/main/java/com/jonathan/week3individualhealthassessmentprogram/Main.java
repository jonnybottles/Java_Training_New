package com.jonathan.week3individualhealthassessmentprogram;

import com.jonathan.week3individualhealthassessmentprogram.datamodel.PatientData;
import com.jonathan.week3individualhealthassessmentprogram.datamodel.PatientRecordManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        testSaveLoadData();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void testSaveLoadData() {
        // Initialize your PatientRecordManager
        PatientRecordManager manager = new PatientRecordManager();

        // Create a new PatientData object
        PatientData patientData = new PatientData("Doe", "John");
        // For demonstration purposes, we're assuming you have appropriate getters and setters to manipulate patientData

        // The filename for saving and loading the patient data
        String filename = "patientDataFile"; // You can make this more dynamic or user-defined

        // Save the patient data
        manager.savePatientData(patientData, filename);

        // Load the patient data
        try {
            PatientData loadedPatientData = manager.loadPatientData(filename);
            if (loadedPatientData != null) {
                System.out.println("Patient data loaded successfully for patient ID: " + loadedPatientData.getPatientID());
                // Further code to verify the loaded data would go here.
            } else {
                System.out.println("No data found for file: " + filename);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Attempt to load a non-existent patient data
        try {
            String nonExistentFilename = "nonExistentFile";
            PatientData nonExistentPatientData = manager.loadPatientData(nonExistentFilename); // Assuming this file doesn't exist
            if (nonExistentPatientData != null) {
                System.out.println("Loaded data for a non-existent file, this should not happen.");
            } else {
                System.out.println("No data found for file: " + nonExistentFilename + ", as expected.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}