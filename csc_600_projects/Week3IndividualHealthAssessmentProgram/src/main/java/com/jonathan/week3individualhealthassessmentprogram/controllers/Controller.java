package com.jonathan.week3individualhealthassessmentprogram.controllers;

import com.jonathan.week3individualhealthassessmentprogram.datamodel.*;
import com.jonathan.week3individualhealthassessmentprogram.services.HealthAssessmentServices;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private HealthAssessmentServices theHealthAssessmentServices;
    private PatientData thePatientData;

    private StringBuilder theInformationalAlertMsg;

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField weightTextField;

    @FXML
    private Label BMILabel;

//    @FXML
//    private TextField bloodPressureTextField;
//    @FXML
//    private TextField bloodGlucoseTextField;
//    @FXML
//    private TextField triglyceridesTextField;
//    @FXML
//    private TextField hdlTextField;
//    @FXML
//    private TextField ldlTextField;
//    @FXML
//    private TextField filenameTextField;

    @FXML
    private Button evaluateHealthMetricsButton;


    public void initialize() {
        this.theHealthAssessmentServices = new HealthAssessmentServices();

        this.thePatientData = new PatientData(new BMIData(), new BloodPressureData(),
                new CholesterolData(), new GlucoseData());

        this.theInformationalAlertMsg = new StringBuilder();

    }


    public void onEvaluateHealthMetricsClicked() {
        // Clear previous AlertMSg messages
        theInformationalAlertMsg.setLength(0);

        boolean isAllDataValid = isAllInputValid();

        // Check if all inputs are valid and if any error messages were generated
        if (!isAllDataValid || !theInformationalAlertMsg.isEmpty()) {
            displayInformationalAlert("Invalid Input", theInformationalAlertMsg.toString());
            return;
        }


        // Proceed with calculating health metrics since all data is valid
        theHealthAssessmentServices.calculateAllHealthMetrics(thePatientData);
        setLabels();

        // Only display the health advisory if there is advice to show
        String advice = theHealthAssessmentServices.getAdviceNotification();
        if (!advice.isEmpty()) {
            displayHealthAdvisory(advice);
        }

    }

    private void setLabels() {
        BMILabel.setText(thePatientData.getBMIData().getBMICategory());
    }

    private boolean isAllInputValid() {
        return isValidNameInputs() && isValidBMIInputs();
    }

    private boolean isValidNameInputs() {

        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();

        boolean isValid = true;
        if (!thePatientData.setFirstName(firstName)) {
            theInformationalAlertMsg.append("Invalid first name.\n");
            isValid = false;
        }
        if (!thePatientData.setLastName(lastName)) {
            theInformationalAlertMsg.append("Invalid last name.\n");
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidBMIInputs() {
        boolean isValid = true;
        String weight = weightTextField.getText().trim();
        String height = heightTextField.getText().trim();

        if (!isValidFloat(weight)) {
            theInformationalAlertMsg.append("Invalid weight.\n");
            isValid = false;
        }

        if (!isValidFloat(height)) {
            theInformationalAlertMsg.append("Invalid height.\n");
            isValid = false;
        }

        if (isValid) {
            float weightFloat = Float.parseFloat(weight);
            float heightFloat = Float.parseFloat(height);
            BMIData bmiData = thePatientData.getBMIData();

            if (!bmiData.setWeight(weightFloat)) {
                theInformationalAlertMsg.append("Weight must be greater than 0.\n");
                isValid = false;
            }

            if (!bmiData.setHeight(heightFloat)) {
                theInformationalAlertMsg.append("Height must be greater than 0.\n");
                isValid = false;
            }
        }

        return isValid;
    }


    public boolean isValidFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Display informational popup for bad input.
    public void displayInformationalAlert(String header, String msg) {
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