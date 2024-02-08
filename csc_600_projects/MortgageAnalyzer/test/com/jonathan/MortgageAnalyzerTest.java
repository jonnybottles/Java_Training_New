package com.jonathan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MortgageAnalyzerTest {
    private MortgageAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new MortgageAnalyzer();
    }

    @Test
    void testValidData() {
        analyzer.setLoanAmount(200000);
        analyzer.setAnnualInterestRate(5);
        analyzer.setLoanDuration(360);
        assertTrue(analyzer.verify(), "The input data should be valid.");
    }

}
