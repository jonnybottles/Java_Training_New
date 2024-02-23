package com.jonathan.gradedistribution.controllers;

import com.jonathan.gradedistribution.datamodel.Grade;
import com.jonathan.gradedistribution.services.FileHandler;
import com.jonathan.gradedistribution.services.GradeService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileNotFoundException;

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

    public void initialize() {
        theGradeService = new GradeService();
        gradeDistributionTextArea.appendText("GRADE DISTRIBUTION:\n\n");
        gradeDistributionTextArea.appendText("A: *****\n");
        gradeDistributionTextArea.appendText("B: *******\n");
        gradeDistributionTextArea.appendText("C: *********\n");
        gradeDistributionTextArea.appendText("D: ****\n");
        gradeDistributionTextArea.appendText("F: **\n");
    }

    @FXML
    public void onShowDistributionClicked() {

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
        meanLabel.setText(String.valueOf(theGradeService.getMean()));

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