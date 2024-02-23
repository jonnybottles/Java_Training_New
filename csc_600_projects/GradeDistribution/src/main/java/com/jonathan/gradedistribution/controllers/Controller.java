package com.jonathan.gradedistribution.controllers;

import com.jonathan.gradedistribution.datamodel.Grade;
import com.jonathan.gradedistribution.services.FileHandler;
import com.jonathan.gradedistribution.services.GradeService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.util.Map;

public class Controller {

    private FileHandler theFileHandler;

    private GradeService theGradeService;

    @FXML
    private TextArea gradeDistributionTextArea;

    @FXML
    private TextField filenameTextField;

    @FXML
    private ListView<Grade> gradesListView;

    @FXML
    private Label meanLabel;

    @FXML
    private Label stdDevLabel;

    @FXML
    private ListView<String> letterGradeListView;

    private boolean hasGradesBeenLoaded;

    private boolean hasMeanStdDevBeenCalculated;

    private boolean hasLetterGradeBeenAssigned;

    public void initialize() {
        theGradeService = new GradeService();

    }

    @FXML
    public void onShowDistributionClicked() {
        if (!hasGradesBeenLoaded) {
            displayInformationalAlert("Grades Not Loaded", "Grades Not Loaded",
                    "Please load grades and calculate mean / standard deviation first.");
            return;
        }

        if (!hasMeanStdDevBeenCalculated) {
            displayInformationalAlert("Calculation Not Completed", "Calculation Not Completed.",
                    "Please calculate mean / standard deviation to display letter grades first.");
            return;
        }

        if (!hasLetterGradeBeenAssigned) {
            displayInformationalAlert("Letter Grades Not Assigned", "Letter Grades Not Assigned",
                    "Please load grades, calculate mean / standard deviation, and assign letter grades first.");
            return;
        }

        gradeDistributionTextArea.appendText("GRADE DISTRIBUTION:\n\n");
        Map<String, Integer> gradeCounts = theGradeService.getGradeData().getGradeCounts();

        System.out.println(gradeCounts.toString());


        // Ensure the order of grades when displayed
        String[] gradeLetters = {"A", "B", "C", "D", "F"};

        for(String grade : gradeLetters) {
            Integer count = gradeCounts.getOrDefault(grade, 0);
            gradeDistributionTextArea.appendText(grade + ": " + generateStars(count) + "\n");
        }
    }

    // Helper method to generate a series of aserisks based on the count
    private String generateStars(int count) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stars.append("*");
        }
        return stars.toString();
    }

    @FXML void onLoadGradesButtonClicked() {

        try {
            String fileName = filenameTextField.getText().trim();
            theFileHandler = new FileHandler(fileName, theGradeService);
            theFileHandler.readGrades();
            gradesListView.setItems(theGradeService.getGradeData().getGrades());
            hasGradesBeenLoaded = true;

        } catch (FileNotFoundException e) {
            displayInformationalAlert("File Not Found", "File Not Found",
                    "Please enter a valid file name.");
        } catch (NumberFormatException e) {
            displayInformationalAlert("Invalid Grade", "Invalid Grade",
                    e.getMessage());
        }
    }

    public void onCalcMeanStdDevClicked() {
        if (!hasGradesBeenLoaded) {
            displayInformationalAlert("Grades Not Loaded", "Grades Not Loaded",
                    "Please load grades to calculate mean / standard deviation.");
            return;
        }

        theGradeService.mean();
        meanLabel.setText(String.format("%.2f", theGradeService.getMean()));

        theGradeService.standardDeviation();
        stdDevLabel.setText(String.format("%.2f", theGradeService.getStandardDeviation()));
        hasMeanStdDevBeenCalculated = true;
    }

    public void onAssignLetterGradesClicked() {
        if (!hasGradesBeenLoaded) {
            displayInformationalAlert("Grades Not Loaded", "Grades Not Loaded",
                    "Please load grades and calculate mean / standard deviation first.");
            return;
        }

        if (!hasMeanStdDevBeenCalculated) {
            displayInformationalAlert("Calculation Not Completed", "Calculation Not Completed.",
                    "Please calculate mean / standard deviation to display letter grades first.");
            return;
        }

        theGradeService.populateGradesWithLetters();
        letterGradeListView.setItems(theGradeService.getGradeData().getGradesWithLetters());
        hasLetterGradeBeenAssigned = true;

    }

    // Displays informational popup.
    public void displayInformationalAlert(String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}