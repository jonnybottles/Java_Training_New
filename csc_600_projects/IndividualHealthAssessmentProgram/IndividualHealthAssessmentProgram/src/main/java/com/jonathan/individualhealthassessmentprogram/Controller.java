package com.jonathan.individualhealthassessmentprogram;

import com.jonathan.individualhealthassessmentprogram.DataModel.BMICalculator;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class Controller {

    private BMICalculator theCalculator;

    @FXML
    AnchorPane mainAnchorPane;

    @FXML
    TextField heightField;

    @FXML
    TextField weightField;

    @FXML
    Button calcBMIButton;

    @FXML
    Label BMILabel;

    @FXML
    Label categoryLabel;


    // Initializes a BMI calculator object.
    public void initialize() {
        theCalculator = new BMICalculator();
    }


    // Handles event for the Calculate button being clicked.
    @FXML
    protected void onCalcBMIButtonClicked() {
        // Obtains user entered height from heightField and validates it.
        String height = heightField.getText().trim();
        float heightFloat = validateHeightWeight(height, "height");

        // Obtains user entered weight from weightField and validates it.
        String weight = weightField.getText().trim();
        float weightFloat = validateHeightWeight(weight, "weight");

        // Makes sure values are above zero, if so sets height / weight in calculator object
        // and calculates BMI, then setting BMI label to BMI number and category label to
        // BMI category.
        if (heightFloat >= 0 && weightFloat >= 0) {
            theCalculator.setHeight(heightFloat);
            theCalculator.setWeight(weightFloat);
            theCalculator.calculateBMI();
            BMILabel.setText("BMI: " + theCalculator.getBMIString());
            categoryLabel.setText("BMI Category: " + theCalculator.getBMICategory());

            // Checks to see if BMI is below / above BMI threshold as defined in requirements
            // if so, displays a pop=up with a health advisory.
            float bmiFloat = theCalculator.getBMIFloat();
            if (bmiFloat < 18.5) {
                displayHealthAdvisory("Your BMI is below 18.5. Please consult a doctor immediately.");
            } else if (bmiFloat > 35.0) {
                displayHealthAdvisory("Your BMI is above 35.0. Please consult a doctor immediately.");
            }
        }


    }

    // Method to validate height / weight input from user.
    private float validateHeightWeight(String input, String type) {
        try {
            float parsedValue = Float.parseFloat(input);
            if (parsedValue <= 0) {
                displayErrorAlert("Invalid Input", "Please enter a valid " + type +".");
                return -1;
            }
            return parsedValue;
        } catch (NumberFormatException e) {
            displayErrorAlert("Invalid Input", "Please enter a valid " + type +".");
            return -1;
        }

    }

    // Display informational popup for bad input.
    public void displayErrorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Displays health advisory pop up to user if outside BMI thresholds.
    public void displayHealthAdvisory(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Health Advisory");
        alert.setHeaderText("Doctor Consultation Recommended");
        alert.setContentText(msg);

        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(ok);

        alert.showAndWait();


    }
}