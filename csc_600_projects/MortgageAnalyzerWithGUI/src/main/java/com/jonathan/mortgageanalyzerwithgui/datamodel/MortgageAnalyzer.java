package com.jonathan.mortgageanalyzerwithgui.datamodel;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageAnalyzer {

    private double loanAmount;
    private double annualInterestRate;
    private int loanDuration;

    private boolean isValidLoanAmount;
    private boolean isValidAnnualInterestRate;
    private boolean isValidLoanDuration;

    private double monthlyPayment;
    private double totalInterestPaid;


    // Default constructor
    public MortgageAnalyzer() {
    }

    // String formatted getters
    public String getFormattedLoanAmount() {
        return "- $" + formatResult(this.loanAmount);
    }

    public String getFormattedAnnualInterestRate() {
        return String.format("- %.2f%%", this.annualInterestRate);
    }

    public String getFormattedLoanDuration() {
        return "- " + this.loanDuration;
    }

    public String getFormattedMonthlyPayment() {
        return "- $" + formatResult(this.monthlyPayment);
    }

    public String getFormattedTotalInterestPaid() {
        return "- $" + formatResult(this.totalInterestPaid);
    }


    // Validates and sets loan amount
    public void setLoanAmount(String loanAmount) {
        try {
            double parsedLoanAmount = Double.parseDouble(loanAmount);

            if (parsedLoanAmount > 50000 && parsedLoanAmount <= 1000000) {
                this.loanAmount = parsedLoanAmount;
                this.isValidLoanAmount = true;
            } else {
                this.isValidLoanAmount = false;
            }
        } catch (NumberFormatException e) {
            this.isValidLoanAmount = false;
        }
    }

    // Validates and sets annual interest rate
    public void setAnnualInterestRate(String annualInterestRate) {
        try {
            double parsedAnnualInterestRate = Double.parseDouble(annualInterestRate);

            if (parsedAnnualInterestRate >= 2 && parsedAnnualInterestRate <= 20) {
                this.annualInterestRate = parsedAnnualInterestRate;
                this.isValidAnnualInterestRate = true;
            } else {
                this.isValidAnnualInterestRate = false;
            }
        } catch (NumberFormatException e) {
            this.isValidAnnualInterestRate = false;
        }
    }

    // Validates and sets loan duration
    public void setLoanDuration(String loanDuration) {
        try {
            int parsedLoanDuration = Integer.parseInt(loanDuration);

            if (parsedLoanDuration >= 120 && parsedLoanDuration <= 480) {
                this.loanDuration = parsedLoanDuration;
                this.isValidLoanDuration = true;
            } else {
                this.isValidLoanDuration = false;
            }
        } catch (NumberFormatException e) {
            this.isValidLoanDuration = false;
        }
    }


    // Checks all boolean values to determine if all data is correct
    public boolean verify() {
        return isValidLoanAmount && isValidAnnualInterestRate && isValidLoanDuration;
    }

    // Returns appropriate string message based upon bad input provided.
    public String correctInput() {
        StringBuilder sb = new StringBuilder();

        if (verify()) {
            return "All inputs are valid.";
        }

        if (!isValidLoanAmount) {
            sb.append("Loan amount must be between $50,000 and $1,000,000.\n");
        }

        if (!isValidAnnualInterestRate) {
            sb.append("Annual interest rate must be between 2% and 20%\n");
        }

        if (!isValidLoanDuration) {
            sb.append("Loan duration must be between 120 and 480 months.\n");
        }

        return sb.toString();

    }

    // Helper method for formatting results appropriately.
    private String formatResult(double result) {
        // Formats numbers with commas as thousands separators.
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);

        // Sets it so only decimal places are shown if required.
        formatter.setMinimumFractionDigits(0);

        // Sets the maximum number of digits shown after the decimal point to 2.
        formatter.setMaximumFractionDigits(2);

        return formatter.format(result);
    }

    //Calculates all mortgage details.
    public void calculateMortgageDetails() {
        //Calculates monthly interest rate using provided formula (annual rate divided by 12)
        double monthlyInterestRate = (annualInterestRate / 100) / 12;

        // Calculates monthly payment using provided formula payment = p * r * (1 + r)n  / ((1 + r)n – 1)
        this.monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -loanDuration));

        // Calculates total payment / total interest rate using provided formulas.
        double totalPayment = this.monthlyPayment * loanDuration;
        this.totalInterestPaid = totalPayment - loanAmount;

    }



}
