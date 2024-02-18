package com.jonathan.week3individualhealthassessmentprogram.controllers;

import com.jonathan.week3individualhealthassessmentprogram.datamodel.*;
import com.jonathan.week3individualhealthassessmentprogram.services.HealthAssessmentServices;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

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
    private TextField bloodPressureTextField;
    @FXML
    private TextField bloodGlucoseTextField;
    @FXML
    private TextField triglyceridesTextField;
    @FXML
    private TextField hdlTextField;
    @FXML
    private TextField ldlTextField;
    @FXML
    private TextField filenameTextField;
    @FXML
    private Button saveReportButton;
    @FXML
    private Button loadReportButton;



    @FXML
    private TextArea evaluationTextArea;

    @FXML
    private Button evaluateHealthMetricsButton;

    private boolean evaluateHealthMetricsButtonWasClicked;

    PatientRecordManager thePatientRecordManager;


    public void initialize() {
        this.theHealthAssessmentServices = new HealthAssessmentServices();

        this.thePatientData = new PatientData(new BMIData(), new BloodPressureData(),
                new CholesterolData(), new GlucoseData());

        this.theInformationalAlertMsg = new StringBuilder();

        this.thePatientRecordManager = new PatientRecordManager();

    }

    public void onSaveReportButtonClicked() {


        if (!evaluateHealthMetricsButtonWasClicked) {
            displayInformationalAlert("Metrics Not Calculated",
                    "Health metrics must calculated before report can be saved.\n");
            return;
        }
        String fileName = filenameTextField.getText().trim();

        if (!isValidFileName(fileName)) {
            displayInformationalAlert("Invalid File Name", "File name cannot be blank.");
            return;
        }

        if (!thePatientRecordManager.savePatientData(thePatientData, fileName)) {
            displayInformationalAlert("File Save Failed","Failed to save patient report.\n");
        } else {
            displayInformationalAlert("File Save Success", "Saved patient report to: " + "'" +
                    fileName + ".ser" + "'\n");
        }

    }

    public boolean isValidFileName(String fileName) {
        if (fileName.isEmpty()) {
            return false;
        }
        return true;
    }

    public void onLoadReportButtonClicked() {
        String fileName = filenameTextField.getText().trim();

        if (!isValidFileName(fileName)) {
            displayInformationalAlert("Invalid File Name", "File name cannot be blank.");
            return;
        }

        try {
            thePatientData = thePatientRecordManager.loadPatientData(fileName);
            onEvaluateHealthMetricsClicked(true);
        } catch (IOException | ClassNotFoundException e) {
            displayErrorAlert("Report Load Failed", "Failed to load health assessment report.");
        }

        clearTextFields();

    }

    public void clearTextFields() {
        firstNameTextField.clear();
        lastNameTextField.clear();
        heightTextField.clear();
        weightTextField.clear();
        bloodPressureTextField.clear();
        bloodGlucoseTextField.clear();
        triglyceridesTextField.clear();
        hdlTextField.clear();
        ldlTextField.clear();
    }

    // Overloaded version of this method to allow for discerning between the user
    // actually clicking the button or calling this method internally
    public void onEvaluateHealthMetricsClicked() {
        onEvaluateHealthMetricsClicked(false);
    }


    public void onEvaluateHealthMetricsClicked(boolean wasCalledInternally) {
        // Clear previous AlertMSg messages
        theInformationalAlertMsg.setLength(0);

        if (!wasCalledInternally) {
            boolean isAllDataValid = isAllInputValid();

            // Check if all inputs are valid and if any error messages were generated
            if (!isAllDataValid || !theInformationalAlertMsg.isEmpty()) {
                displayInformationalAlert("Invalid Input", theInformationalAlertMsg.toString());
                return;
            }
        }


        // Proceed with calculating health metrics since all data is valid
        theHealthAssessmentServices.calculateAllHealthMetrics(thePatientData);
        fillEvaluationTextArea(thePatientData);

        // Only display the health advisory if there is advice to show
        String advice = theHealthAssessmentServices.getAdviceNotification();
        if (!advice.isEmpty()) {
            displayHealthAdvisory(advice);
        }

        evaluateHealthMetricsButtonWasClicked = true;

    }

    private void fillEvaluationTextArea(PatientData thePatientData) {
        evaluationTextArea.clear();
        evaluationTextArea.appendText(theHealthAssessmentServices.generateHealthEvaluationReport(thePatientData));
        // Scrolls the text area to the bottom, removing the users from having to do so each time
        // a new log is generated
        evaluationTextArea.setScrollTop(Double.MAX_VALUE);
    }

    private boolean isAllInputValid() {
        boolean namesValid = isValidNameInputs();
        boolean BMIValid = isValidBMIInputs();
        boolean bloodPressureValid = isValidBloodPressureInput();
        boolean bloodGlucoseValid = isValidBloodGlucoseInput();
        boolean cholesteroldInputsValid = isValidCholesterolInputs();

        return namesValid && BMIValid && bloodPressureValid && bloodGlucoseValid && cholesteroldInputsValid;
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

    private boolean isValidCholesterolInputs() {
        boolean isValid = true;

        String triglycerides = triglyceridesTextField.getText().trim();
        String hdl = hdlTextField.getText().trim();
        String ldl = ldlTextField.getText().trim();

        CholesterolData cholesterolData = thePatientData.getTheCholesterolData();

        // Attempt to set Triglycerides and validate
        if (!isValidInt(triglycerides) || !cholesterolData.setTriglycerides(Integer.parseInt(triglycerides))) {
            theInformationalAlertMsg.append("Invalid triglycerides level. Must be between 0 and 999.\n");
            isValid = false;
        }

        // Attempt to set HDL and validate
        if (!isValidInt(hdl) || !cholesterolData.setHDL(Integer.parseInt(hdl))) {
            theInformationalAlertMsg.append("Invalid HDL level. Must be between 0 and 100.\n");
            isValid = false;
        }

        // Attempt to set LDL and validate
        if (!isValidInt(ldl) || !cholesterolData.setLDL(Integer.parseInt(ldl))) {
            theInformationalAlertMsg.append("Invalid LDL level. Must be between 0 and 199.\n");
            isValid = false;
        }

        return isValid;
    }


    private boolean isValidBloodGlucoseInput() {
        boolean isValid = true;
        String glucose = bloodGlucoseTextField.getText().trim();

        if (!isValidInt(glucose)) {
            theInformationalAlertMsg.append("Invalid blood glucose level.\n");
            isValid = false;
        }

        if (isValid) {
            int glucoseInt = Integer.parseInt(glucose);
            GlucoseData glucoseData = thePatientData.getTheGlucoseData();
            if(!glucoseData.setGlucose(glucoseInt)) {
                theInformationalAlertMsg.append("Blood glucose must be between 1 and 399.");
                isValid = false;
            }
        }
        return isValid;
    }


    private boolean isValidBloodPressureInput() {
        boolean isValid = true;
        String bloodPressure = bloodPressureTextField.getText().trim();

        if (!isValidInt(bloodPressure)) {
            theInformationalAlertMsg.append("Invalid blood pressure.\n");
            isValid = false;
        }

        if (isValid) {
            int bloodPressureInt = Integer.parseInt(bloodPressure);
            BloodPressureData bloodPressureData = thePatientData.getTheBloodPressureData();
            if(!bloodPressureData.setBloodPressure(bloodPressureInt)) {
                theInformationalAlertMsg.append("Blood pressure must be between 1 and 251");
                isValid = false;
            }

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

    // Display error popup.
    public void displayErrorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
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

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setPrefWidth(400);

        alert.showAndWait();

    }



}