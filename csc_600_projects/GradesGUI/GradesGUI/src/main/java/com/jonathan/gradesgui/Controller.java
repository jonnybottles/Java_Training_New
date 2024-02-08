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
    private TextField fileNameField;

    @FXML
    private ComboBox<String> gradeComboBox;

    @FXML
    private Label GPALabel;

    @FXML
    private Label readFileNotificationLabel;

    @FXML
    private Button okButton;

    private FileHandler theFileHandler;

    // Initializes a FileHandler object.
    public void initialize() {
        theFileHandler = new FileHandler();
    }

    // Handles event for when Read Grades button is clicked.
    @FXML
    public void onReadGradesFileClicked() {
        // Obtains filename from file name text field.
        String fileName = fileNameField.getText().trim();
        theFileHandler.setReadFile(fileName);

        // Attempts to read file, if its doesn't exist, clear the combo box and rest GPAlabel
        if (!theFileHandler.openReadFile()) {
            readFileNotificationLabel.setText("File does not exist.");
            gradeComboBox.getItems().clear();
            GPALabel.setText("GPA is: ...");

        // If the file exits attempt to read the grades file and add all grade values from file to the combo box.
        } else if (theFileHandler.openReadFile()) {
            theFileHandler.readGrades();
            // If the file had grades, add all grades to combo box.
            if (!theFileHandler.getGrades().isEmpty()) {
                gradeComboBox.getItems().clear();
                gradeComboBox.getItems().addAll(theFileHandler.getGrades());
                readFileNotificationLabel.setText("Read file successful");
            // If no grades are in the file, clear the combo box.
            } else {
                readFileNotificationLabel.setText("No grades found in file");
                gradeComboBox.getItems().clear();
                GPALabel.setText("GPA is: ...");
            }
            // Close the file handler.
            theFileHandler.closeFile();
        }

    }

    // Handles event for calculate GPA being clicked.
    @FXML
    public void onCalculateGPAClicked() {
        // If there are no items in the combo box to calcualte the GPA
        // notify the user.
        if (gradeComboBox.getItems().isEmpty()) {
            readFileNotificationLabel.setText("Please load grades file first");
            return;
        }

        // If there are items in the combo box, get the value selected and set the GPA label text.
        String selectedGrade = gradeComboBox.getValue();
        GPALabel.setText("GPA is: " + theFileHandler.getGPA(selectedGrade));
    }

    // Handles OK button event being clicked, which closes the program
    @FXML
    public void onOKClicked() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    // Handles minimize button being clicked and minimizes the program window.
    @FXML
    public void onMinimizeClicked() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.setIconified(true);
    }


}