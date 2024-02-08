package com.jonathan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MortgageAnalyzerTest {

    private MortgageAnalyzer analyzer;

    @BeforeEach
    public void setUp() {
        analyzer = new MortgageAnalyzer();
    }

    // Tests valid data on all setters
    @Test
    public void testValidData() {
        analyzer.setLoanAmount(200000);
        analyzer.setAnnualInterestRate(5);
        analyzer.setLoanDuration(360);
        assertTrue(analyzer.verify(), "The input data should be valid.");
    }

    // Tests an invalid loan amount.
    @Test
    public void testInvalidLoanAmount(){
        analyzer.setLoanAmount(40000);
        analyzer.setAnnualInterestRate(5);
        analyzer.setLoanDuration(360);
        assertFalse(analyzer.verify(), "The input data should be invalid," +
                "as valid loan are loan amounts are between 50,000 and 1,000,000");
    }


    // Tests an invalid annual interest rate.
    @Test
    void testInvalidAnnualInterestRate() {
        analyzer.setLoanAmount(200000);
        analyzer.setAnnualInterestRate(1);
        analyzer.setLoanDuration(360);
        assertFalse(analyzer.verify(), "The input data should be invalid," +
                "as valid loan interest rates are between 2% and 20%");
    }

    // Tests an invalid loan duration.
    @Test
    void testInvalidLoanDuration() {
        analyzer.setLoanAmount(200000);
        analyzer.setAnnualInterestRate(5);
        analyzer.setLoanDuration(100);
        assertFalse(analyzer.verify(), "The input data should be invalid," +
                "as valid loan durations are between 120 and 480 months");
    }

    // ***** INSTRUCTOR NOTE *****
    // This test fails because the Total Interest Paid is returned as $229,817.35
    // when it should be $229,817.20, as per the lab test input / output data.
    // I tried to trouble shoot my formula several times, to no avail.
    // When input smaller loan / durations my tests run jut fine.
    // To see the actual input, run my code in main().
    @Test
    void testCalculateMortgageDetails() {
        analyzer.setLoanAmount(140000);
        analyzer.setAnnualInterestRate(8.00);
        analyzer.setLoanDuration(360);

        String expectedResults = "Amount of Loan: - $140,000\n" +
                "Annual Interest Rate: - 8.00%\n" +
                "Duration of Loan in Months: - 360\n" +
                "Monthly Payment: - $1,027.27\n" +
                "Total Interest Paid: - $229,817.20";

        String actualResults = analyzer.calculateMortgageDetails();

        assertEquals(expectedResults, actualResults, "The mortgage details should match the test results.");
    }

}
