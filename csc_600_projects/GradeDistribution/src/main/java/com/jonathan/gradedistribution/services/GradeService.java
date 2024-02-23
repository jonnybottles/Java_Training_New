package com.jonathan.gradedistribution.services;

import com.jonathan.gradedistribution.datamodel.Grade;
import com.jonathan.gradedistribution.datamodel.GradeData;

public class GradeService {

    private GradeData gradeData;

    public GradeService() {
        this.gradeData = new GradeData();
    }

    public GradeData getGradeData() {
        return gradeData;
    }

    public boolean isValidGrade(String gradeStr) {
        try {
            int score = Integer.parseInt(gradeStr);
            return score >= 0 && score <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double mean() {
        double mean = gradeData.getGrades()
                // Convert grade list into a stream of Grades
                .stream()
                // Convert each grade into a score (int)
                .mapToInt(Grade::getScore)
                // Get mean of all scores
                .average()
                // Retrieve the double from the OptionalDouble return by .average()
                .getAsDouble();

        return mean;

    }

    public double standardDeviation() {
        double mean = mean();
        double theStandardDeviation = gradeData.getGrades()
                .stream()
                // Using a lambda expression as per requirements to calculate the standard deviation
                // using maptodouble to convert eachinto a double then preform the calculation for std dev
                .mapToDouble(grade-> Math.pow(grade.getScore() - mean, 2))
                .average()
                .getAsDouble();

        // final portion of the standard deviation calculation
        theStandardDeviation = Math.sqrt(theStandardDeviation);
        return  theStandardDeviation;
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

    public void addGrade(int score) {
        String letterGrade = calculateLetterGrade(score);
        Grade grade = new Grade(score, letterGrade);
        gradeData.getGrades().add(grade);
    }
}
