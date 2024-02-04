package com.jonathan.gradesgui;

import com.jonathan.gradesgui.datamodel.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private Button readGradesFileButton;

    @FXML
    private TextField fileNameField;

    @FXML
    private Button calculateGPAButton;

    @FXML
    private ComboBox<String> gradeComboBox;

    @FXML
    private Label GPALabel;

    @FXML
    private Label readFileNotificationLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button minimizeButton;

    private FileHandler theFileHandler;


    public void initialize() {
        theFileHandler = new FileHandler();
    }

    @FXML
    public void onReadGradesFileClicked() {
        String fileName = fileNameField.getText().trim();
        theFileHandler.setReadFile(fileName);
        if (!theFileHandler.openReadFile()) {
            readFileNotificationLabel.setText("File does not exist.");
            gradeComboBox.getItems().clear();
            GPALabel.setText("GPA is: ...");

        } else if (theFileHandler.openReadFile()) {
            theFileHandler.readGrades();
            if (!theFileHandler.getGrades().isEmpty()) {
                gradeComboBox.getItems().clear();
                gradeComboBox.getItems().addAll(theFileHandler.getGrades());
                readFileNotificationLabel.setText("Read file successful");

            } else {
                readFileNotificationLabel.setText("No grades found in file");
                gradeComboBox.getItems().clear();
                GPALabel.setText("GPA is: ...");
            }
            theFileHandler.closeFile();
        }

    }

    @FXML
    public void onCalculateGPAClicked() {
        if (gradeComboBox.getItems().isEmpty()) {
            readFileNotificationLabel.setText("Please load grades file first");
            return;
        }
        String selectedGrade = gradeComboBox.getValue();
        GPALabel.setText("GPA is: " + theFileHandler.getGPA(selectedGrade));
    }

    @FXML
    public void onOKClicked() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onMinimizeClicked() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.setIconified(true);
    }


}