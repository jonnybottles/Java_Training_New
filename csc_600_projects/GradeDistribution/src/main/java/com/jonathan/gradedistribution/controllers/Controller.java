package com.jonathan.gradedistribution.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private TextArea gradeDistributionTextArea;


    public void initialize() {
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

}