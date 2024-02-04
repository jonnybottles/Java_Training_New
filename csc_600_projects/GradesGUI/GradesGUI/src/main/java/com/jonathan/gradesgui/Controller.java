package com.jonathan.gradesgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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



    @FXML
    public void onReadGradesFileClicked() {
        System.out.println("Read Grades File Clicked");
    }

    @FXML
    public void onCalculateGPAClicked() {
        System.out.println("Calculate GPA Clicked");
    }

    @FXML
    public void onOKClicked() {
        System.out.println("OK Clicked");
    }

    @FXML
    public void onMinimizeClicked() {
        System.out.println("Minimize Clicked");
    }


}