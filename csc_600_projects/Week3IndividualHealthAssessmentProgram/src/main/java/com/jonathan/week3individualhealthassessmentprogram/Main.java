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
//        testSaveLoadData();
        stage.setTitle("Individual Health Assessment");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
//TODO GETT RIDDDDD OFFFFFFFFFFFFFFFFFFFFFFFFF THISSSSSSSSSSSSSSSSSSSSSSSSSSSSS
//    public void testSaveLoadData() {
//        PatientRecordManager manager = new PatientRecordManager();
//
//        // Create a new PatientData object
//        PatientData patientData = new PatientData("Doe", "John");
//
//        String filename = "patientDataFile"; // You can make this more dynamic or user-defined
//
//        manager.savePatientData(patientData, filename);
//
//        try {
//            PatientData loadedPatientData = manager.loadPatientData(filename);
//            if (loadedPatientData != null) {
//                System.out.println("Patient data loaded successfully for patient ID: " + loadedPatientData.getPatientID());
//            } else {
//                System.out.println("No data found for file: " + filename);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Attempt to load a non-existent patient data
//        try {
//            String nonExistentFilename = "nonExistentFile";
//            PatientData nonExistentPatientData = manager.loadPatientData(nonExistentFilename);
//            if (nonExistentPatientData != null) {
//                System.out.println("Loaded data for a non-existent file, this should not happen.");
//            } else {
//                System.out.println("No data found for file: " + nonExistentFilename + ", as expected.");
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


}