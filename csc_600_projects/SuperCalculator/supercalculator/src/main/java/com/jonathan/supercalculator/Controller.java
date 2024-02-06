package com.jonathan.supercalculator;

import com.jonathan.supercalculator.datamodel.Calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField numberOneField;

    @FXML
    private TextField numberTwoField;

    @FXML
    private TextField resultField;

    @FXML
    private Button addButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label statusLabel;

    private Calculator theCalculator;

    public void initialize() {
        theCalculator = new Calculator();
    }

    @FXML
    public void onMathOperationClicked(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        String buttonText = clickedButton.getText();

        String numberOne = numberOneField.getText().trim();
        String numberTwo = numberTwoField.getText().trim();

        if (!theCalculator.isValidInput(numberOne, numberTwo)) {
            displayErrorAlert("Invalid input", "Please enter integer values only.");
            theCalculator.clear();
            return;
        }

        String answer;
        switch (buttonText) {
            case "Add":
                answer = theCalculator.add();
                break;
            case "Subtract":
                answer = theCalculator.subtract();
                break;
            case "Multiply":
                answer = theCalculator.multiply();
                break;
            case "Divide":
                if (theCalculator.isSecondNumberZero()) {
                    displayErrorAlert("Invalid input", "Cannot divide by zero.");
                    theCalculator.clear();
                    return;
                }
                theCalculator.divide();
                break;
        }

        // NEED TO SET RESULTS FIELD NOW!!!!!!!!!!!!

    }

    public void displayErrorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void clearCalculator() {
        theCalculator.clear();
        numberOneField.setText("");
        numberTwoField.setText("");
        resultField.setText("");

    }

}