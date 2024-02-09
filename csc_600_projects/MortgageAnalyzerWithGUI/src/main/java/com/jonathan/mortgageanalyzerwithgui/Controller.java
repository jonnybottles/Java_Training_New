package com.jonathan.mortgageanalyzerwithgui;

import com.jonathan.mortgageanalyzerwithgui.datamodel.MortgageAnalyzer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField loanAmountTextField;

    @FXML
    private TextField annualInterestRateTextField;

    @FXML
    private TextField loanDurationTextField;

    @FXML
    private Button calculateMortgageButton;

    @FXML
    private Label loanAmountLabel;

    @FXML
    private Label annualInterestRateLabel;

    @FXML
    private Label loanDurationLabel;

    @FXML
    private Label monthlyPaymentLabel;

    @FXML
    private Label totalInterestPaidLabel;

    private MortgageAnalyzer theMortgageAnalyzer;

    // Initializes MortgageAnalyzer Object
    public void initialize() {
        theMortgageAnalyzer = new MortgageAnalyzer();
    }

    // Handles event for calculate mortgage button being clicked
    @FXML
    public void onCalculateMortgageClicked() {
        // Obtain all text field data
        String loanAmount = loanAmountTextField.getText().trim();
        String annualInterestRate = annualInterestRateTextField.getText().trim();
        String loanDuration = loanDurationTextField.getText().trim();

        // Set all amounts
        theMortgageAnalyzer.setLoanAmount(loanAmount);
        theMortgageAnalyzer.setAnnualInterestRate(annualInterestRate);
        theMortgageAnalyzer.setLoanDuration(loanDuration);

        // Checks input, if invalid displays an alert and clears the GUI text fields / dynamic lables
        if (!theMortgageAnalyzer.verify()) {
            displayErrorAlert("Invalid input", theMortgageAnalyzer.correctInput());
            clearGUI();
            return;
        }

        theMortgageAnalyzer.calculateMortgageDetails();

        loanAmountLabel.setText(theMortgageAnalyzer.getFormattedLoanAmount());
        annualInterestRateLabel.setText(theMortgageAnalyzer.getFormattedAnnualInterestRate());
        loanDurationLabel.setText(theMortgageAnalyzer.getFormattedLoanDuration());
        monthlyPaymentLabel.setText(theMortgageAnalyzer.getFormattedMonthlyPayment());
        totalInterestPaidLabel.setText(theMortgageAnalyzer.getFormattedTotalInterestPaid());

    }

    // Displays error alert for invalid input.
    public void displayErrorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Clears GUI text fields and dynamic labels when called
    private void clearGUI() {
        // Clear all text fields
        loanAmountTextField.setText("");
        annualInterestRateTextField.setText("");
        loanDurationTextField.setText("");

        // Clears all labels setting hyphen
        loanAmountLabel.setText("-");
        annualInterestRateLabel.setText("-");
        loanDurationLabel.setText("-");
        monthlyPaymentLabel.setText("-");
        totalInterestPaidLabel.setText("-");
    }


}