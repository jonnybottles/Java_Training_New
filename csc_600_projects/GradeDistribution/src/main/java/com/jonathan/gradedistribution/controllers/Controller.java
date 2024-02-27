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

    // Handles events for Load Grades button being clicked
    @FXML
    public void onLoadGradesButtonClicked() {

        try {
            // Obtains filename, creates filename handle, reads grades, and displays the grades
            // in the gradesListView
            String fileName = filenameTextField.getText().trim();
            theFileHandler = new FileHandler(fileName, theGradeService);
            theFileHandler.readGrades();
            gradesListView.setItems(theGradeService.getGradeData().getGrades());
            hasGradesBeenLoaded = true;

            // If a file is not found or invalid grades are in the file, display an informational alert
        } catch (FileNotFoundException e) {
            displayInformationalAlert("File Not Found", "File Not Found",
                    "Please enter a valid file name.");
        } catch (NumberFormatException e) {
            displayInformationalAlert("Invalid Grade", "Invalid Grade",
                    e.getMessage());
        }
    }

    // Handles events for Calc Mean Std Dev button being clicked
    @FXML
    public void onCalcMeanStdDevClicked() {
        // Checks to see if grades are loaded prior to calculating mean / std
        // if not, display an alert.
        if (!hasGradesBeenLoaded) {
            displayInformationalAlert("Grades Not Loaded", "Grades Not Loaded",
                    "Please load grades to calculate mean / standard deviation.");
            return;
        }

        // Otherwise, calculate the mean / std dev and display in the appropriate GUI labels
        theGradeService.mean();
        meanLabel.setText(String.format("%.2f", theGradeService.getMean()));

        theGradeService.standardDeviation();
        stdDevLabel.setText(String.format("%.2f", theGradeService.getStandardDeviation()));
        hasMeanStdDevBeenCalculated = true;
    }


    // Handles events for Assign Letter Grades button being clicked
    @FXML
    public void onAssignLetterGradesClicked() {

        // Checks to see if grades are loaded prior to calculating mean / std
        // and mean / std dev have been calculated prior to assigning letter grades
        // if not, display an alert.
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

        // If the first two checks pass, add letter grades to leterGradesListView
        theGradeService.populateGradesWithLetters();
        letterGradeListView.setItems(theGradeService.getGradeData().getGradesWithLetters());
        hasLetterGradeBeenAssigned = true;

    }

    // Handles events for Show Distribution button being clicked
    @FXML
    public void onShowDistributionClicked() {
        // Checks to see if grades are loaded prior to calculating mean / std
        // and mean / std dev have been calculated prior to assigning letter grades
        // and letter grades have been assigned if not, display an alert.
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

        // If all checks pass, display grade distribution in gradeDistribution text area
        gradeDistributionTextArea.appendText("GRADE DISTRIBUTION:\n\n");
        Map<String, Integer> gradeCounts = theGradeService.getGradeData().getGradeCounts();

        // Ensures the order of grades when displayed
        String[] gradeLetters = {"A", "B", "C", "D", "F"};

        // Iterate through all grade letters, printing out number of asterisks per grade count
        // to the gradeDistributionTextArea
        for(String grade : gradeLetters) {
            Integer count = gradeCounts.getOrDefault(grade, 0);
            gradeDistributionTextArea.appendText(grade + ": " + generateStars(count) + "\n");
        }
    }

    // Helper method to generate a series of asterisks based on the count.
    private String generateStars(int count) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stars.append("*");
        }
        return stars.toString();
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