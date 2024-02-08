package com.jonathan.supercalculator;

import com.jonathan.supercalculator.datamodel.Calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Class to control the main window of the Super Calculator Program
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

    // Handles click events for all math operation buttons.
    @FXML
    public void onMathOperationClicked(ActionEvent e) {
        // Obtains button that is clicked.
        Button clickedButton = (Button) e.getSource();
        // Obtains text from button, used later in the method for other decisions.
        String buttonText = clickedButton.getText();

        // Obtains text from both number fields and trims any leading / trailing whitespace.
        String numberOne = numberOneField.getText().trim();
        String numberTwo = numberTwoField.getText().trim();

        // Checks input, if invalid displays an alert and clears the calculator.
        if (!theCalculator.isValidInput(numberOne, numberTwo)) {
            displayErrorAlert("Invalid input", "Please enter integer values only.");
            clearCalculator();
            return;
        }

        // Checks button text and calls follow on calculator operation based upon text.
        // Also sets statusLabel based upon mathematical operation being performed.
        String answer = "";
        switch (buttonText) {
            case "Add":
                answer = theCalculator.add();
                statusLabel.setText("adding...");
                break;
            case "Subtract":
                answer = theCalculator.subtract();
                statusLabel.setText("subtracting...");
                break;
            case "Multiply":
                answer = theCalculator.multiply();
                statusLabel.setText("multiplying...");
                break;
            case "Divide":
                if (theCalculator.isSecondNumberZero()) {
                    displayErrorAlert("Invalid input", "Cannot divide by zero.");
                    clearCalculator();
                    return;
                }
                answer = theCalculator.divide();
                statusLabel.setText("dividing...");
                break;
        }

        // Sets result field to result obtained from theCalculator
        resultField.setText(answer);
    }


    // Displays error alert for invalid input / divide by zero.
    public void displayErrorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Handles events for clear button being clicked.
    @FXML
    public void onClearClicked() {
        clearCalculator();
    }

    // Performs calculator clearing operations.
    public void clearCalculator() {
        theCalculator.clear();
        numberOneField.setText("");
        numberTwoField.setText("");
        resultField.setText("");
        statusLabel.setText("");

    }

    // Handles event for exit button being clicked.
    @FXML
    public void onExitClicked() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}