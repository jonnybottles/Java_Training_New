package com.jonathan.gradedistribution.services;

import com.jonathan.gradedistribution.datamodel.Grade;
import com.jonathan.gradedistribution.datamodel.GradeData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GradeService {

    private GradeData gradeData;
    private double theMean;
    private double theStandardDeviation;

    public GradeService() {
        this.gradeData = new GradeData();
    }

    public GradeData getGradeData() {
        return gradeData;
    }

    public double getMean() {
        return theMean;
    }

    public double getStandardDeviation() {
        return theStandardDeviation;
    }

    public boolean isValidGrade(String gradeStr) {
        try {
            int score = Integer.parseInt(gradeStr);
            return score >= 0 && score <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void mean() {
        this.theMean = gradeData.getGrades()
                // Convert grade list into a stream of Grades
                .stream()
                // Convert each grade into a score (int)
                .mapToInt(Grade::getScore)
                // Get mean of all scores
                .average()
                // Retrieve the double from the OptionalDouble return by .average()
                .getAsDouble();

    }

    public void standardDeviation() {
        double theStandardDeviation = gradeData.getGrades()
                .stream()
                // Using a lambda expression as per requirements to calculate the standard deviation
                // using maptodouble to convert eachinto a double then preform the calculation for std dev
                .mapToDouble(grade-> Math.pow(grade.getScore() - theMean, 2))
                .average()
                .getAsDouble();

        // final portion of the standard deviation calculation
        this.theStandardDeviation = Math.sqrt(theStandardDeviation);
    }

    // You can add methods to calculate the letter grade based on the numerical score here
    public String calculateLetterGrade(int score) {
        String letterGrade;
        if (score >= theMean + 1.2 * theStandardDeviation) {
            letterGrade = "A";
        } else if (score >= theMean + 0.6 * theStandardDeviation) {
            letterGrade = "B";
        } else if (score >= theMean && score < theMean + 0.6 * theStandardDeviation) {
            letterGrade = "C";
        } else if (score < theMean && score >= theMean - 0.6 * theStandardDeviation) {
            letterGrade =  "D";
        } else {
            letterGrade =  "F";
        }

        gradeData.incrementGradeCount(letterGrade);

        return letterGrade;
    }


    // Method to populate and update the formattedGrades list in GradeData
    public void populateGradesWithLetters() {

        // Clear the previous counts if this method can be called multiple times
        gradeData.initializeGradeCounts();

        // Also clear the previous letter grades list
        gradeData.getGradesWithLetters().clear();

        for (Grade grade : gradeData.getGrades()) {
            String letterGrade = calculateLetterGrade(grade.getScore());
            gradeData.getGradesWithLetters().add(grade.getScore() + " - " + letterGrade);
        }
    }

    public void addGrade(int score) {
        String letterGrade = calculateLetterGrade(score);
        Grade grade = new Grade(score, letterGrade);
        gradeData.getGrades().add(grade);
    }
}
