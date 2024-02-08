package com.jonathan.supercalculator.datamodel;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

// Class which contains all methods and properties for the calculator class.
public class Calculator {

    private float numberOneFloat;
    private float numberTwoFloat;

    public Calculator() {
    }

    // Performs add operations and returns formatted result.
    public String add() {
        return formatResult(numberOneFloat + numberTwoFloat);
    }

    // Performs subtract operations and returns formatted result.
    public String subtract() {
        return formatResult(numberOneFloat - numberTwoFloat);
    }

    // Performs multiply operations and returns formatted result.
    public String multiply() {
        return formatResult(numberOneFloat * numberTwoFloat);
    }

    // Performs divide operations and returns formatted result.
    public String divide() {
        return formatResult(numberOneFloat / numberTwoFloat);
    }

    // Resets values stored in calculator object.
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

    // Validates that the data being passed via the GUI text fields is a valid number.
    public boolean isValidInput(String numberOne, String numberTwo) {
        try {
            this.numberOneFloat = Float.parseFloat(numberOne);
            this.numberTwoFloat = Float.parseFloat(numberTwo);

            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    // Validates that a digit is a zero or not. Used only when calling divide method.
    public boolean isSecondNumberZero() {
        return numberTwoFloat == 0;
    }






}
