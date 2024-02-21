package com.jonathan.gradedistribution.services;

public class GradeService {

    public GradeService() {
    }

    public boolean isValidGrade(String gradeStr) {
        try {
            int score = Integer.parseInt(gradeStr);
            return score >= 0 && score <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // You can add methods to calculate the letter grade based on the numerical score here
    public String calculateLetterGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }

    }
}
