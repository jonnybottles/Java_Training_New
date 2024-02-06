package com.jonathan.supercalculator.datamodel;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculator {

    private float numberOneFloat;
    private float numberTwoFloat;

    public Calculator() {
    }

    public String add() {
        return formatResult(numberOneFloat + numberTwoFloat);
    }

    public String subtract() {
        return formatResult(numberOneFloat - numberTwoFloat);
    }

    public String multiply() {
        return formatResult(numberOneFloat * numberTwoFloat);
    }

    public String divide() {
        return formatResult(numberOneFloat / numberTwoFloat);
    }

    public void clear() {
        this.numberOneFloat = 0;
        this.numberTwoFloat = 0;
    }

    // Helper method for formatting results appropriately.
    private String formatResult(float result) {
        // Formats numbers with commas as thousands separators.
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);

        // Rounds number up if 5 or above.
        formatter.setRoundingMode(RoundingMode.HALF_UP);

        // Sets it so only decimal places are shown if required.
        formatter.setMinimumFractionDigits(0);

        // Sets the maximum number of digits shown after the decimal point to 2.
        formatter.setMaximumFractionDigits(2);

        // Format the given float result as a String, casting the float to a double.
        return formatter.format((double) result);
    }

    public boolean isValidInput(String numberOne, String numberTwo) {
        try {
            this.numberOneFloat = Float.parseFloat(numberOne);
            this.numberTwoFloat = Float.parseFloat(numberTwo);

            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public boolean isSecondNumberZero() {
        return numberTwoFloat == 0;
    }






}
