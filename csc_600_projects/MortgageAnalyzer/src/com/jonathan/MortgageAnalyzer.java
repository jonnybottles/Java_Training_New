package com.jonathan;

// ************ Note the instructor ***********
// I hope this meets the requirements of the project, as the requirements were a bit odd to me.
// If I had the choice, I would have implemented the verification within the setters themselves.
// Also, having two separate methods for verify / correctInput also seems redundant
// I would have combined this into one method. However, these were the confines of the requirements
// as you are aware.

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageAnalyzer {

    private double loanAmount;
    private double annualInterestRate;
    private int loanDuration;

    private boolean isValidLoanAmount;
    private boolean isValidAnnualInterestRate;
    private boolean isValidLoanDuration;


    public MortgageAnalyzer() {
    }

    // Setters
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
        this.isValidLoanAmount = true;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
        this.isValidAnnualInterestRate = true;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
        this.isValidLoanDuration = true;
    }

    // Verifies user input is within appropriate bounds.
    public boolean verify() {
        if (loanAmount <= 50000 || loanAmount > 1000000) {
            isValidLoanAmount = false;
        }

        if (annualInterestRate < 2 || annualInterestRate > 20) {
            isValidAnnualInterestRate = false;
        }

        if (loanDuration < 120 || loanDuration > 480) {
            isValidLoanDuration = false;
        }

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

        // Format the given float result as a String, casting the float to a double.
        return formatter.format(result);
    }

    //Calculates all mortgage details.
    public String calculateMortgageDetails() {

        //Calculates monthly interest rate using provided formula (annual rate divided by 12)
        double monthlyInterestRate = (annualInterestRate / 100) / 12;

        // Calculates monthly payment using provided formula payment = p * r * (1 + r)n  / ((1 + r)n – 1)
        double monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -loanDuration));

        // Calculates total payment / total interest rate using provided formulas.
        double totalPayment = monthlyPayment * loanDuration;
        double totalInterestPaid = totalPayment - loanAmount;

        // Use formatResult helper function to format all results in a monetary fashion
        String formattedLoanAmount = formatResult(loanAmount);
        String formattedAnnualInterestRate = String.format("%.2f%%", annualInterestRate);
        String formattedMonthlyPayment = formatResult(monthlyPayment);
        String formattedTotalInterestPaid = formatResult(totalInterestPaid);

        // Return all data in one string as per formatted requirements
        return "Amount of Loan: - $" + formattedLoanAmount + "\n" +
                "Annual Interest Rate: - " + formattedAnnualInterestRate + "\n" +
                "Duration of Loan in Months: - " + loanDuration + "\n" +
                "Monthly Payment: - $" + formattedMonthlyPayment + "\n" +
                "Total Interest Paid: - $" + formattedTotalInterestPaid;
    }



}
