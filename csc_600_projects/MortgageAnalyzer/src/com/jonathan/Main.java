package com.jonathan;

public class Main {

    // Running the test input data here as per the requirements to see
    // if the appropriate output data is generated.
    // For actual tests, run MortgageAnalyzerTest in the test folder.
    // See my notes in the MortgageAnalyzerTestClass regarding the one failed test.
    public static void main(String[] args) {
        MortgageAnalyzer analyzer = new MortgageAnalyzer();
        analyzer.setLoanAmount(10000);
        analyzer.setAnnualInterestRate(8.00);
        analyzer.setLoanDuration(360);
        System.out.println(analyzer.calculateMortgageDetails());
    }
}