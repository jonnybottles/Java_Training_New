package com.jonathan.supercalculator.datamodel;

public class Calculator {

    private float numberOneFloat;
    private float numberTwoFloat;

    public Calculator() {
    }

    public String add() {
        return String.format("%.2f", numberOneFloat + numberTwoFloat);
    }

    public String subtract() {
        return String.format("%.2f", numberOneFloat - numberTwoFloat);
    }

    public String multiply() {
        return String.format("%.2f", numberOneFloat * numberTwoFloat);
    }

    public String divide() {
        return String.format("%.2f", numberOneFloat / numberTwoFloat);
    }

    public void clear() {
        this.numberOneFloat = 0;
        this.numberTwoFloat = 0;
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
