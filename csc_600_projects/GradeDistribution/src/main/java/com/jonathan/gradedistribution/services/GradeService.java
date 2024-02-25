package com.jonathan.gradedistribution.services;

import com.jonathan.gradedistribution.datamodel.Grade;
import com.jonathan.gradedistribution.datamodel.GradeData;

// A class that provides all the properties and methods for operations on Grade / GradeData
public class GradeService {

    private GradeData gradeData;
    private double theMean;
    private double theStandardDeviation;

    public GradeService() {
        this.gradeData = new GradeData();
    }

    // Getters
    public GradeData getGradeData() {
        return gradeData;
    }

    public double getMean() {
        return theMean;
    }

    public double getStandardDeviation() {
        return theStandardDeviation;
    }

    // Validates whether a grade is valid or not
    public boolean isValidGrade(String gradeStr) {
        try {
            int score = Integer.parseInt(gradeStr);
            return score >= 0 && score <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Calculates mean using streams
    public void mean() {
        this.theMean = gradeData.getGrades()
                // Converts grade list into a stream of Grades
                .stream()
                // Converts each grade into a score (int)
                .mapToInt(Grade::score)
                // Gets mean of all scores
                .average()
                // Retrieves the double from the OptionalDouble return by .average()
                .getAsDouble();

    }

    // Calculates standard deviation
    public void standardDeviation() {
        double theStandardDeviation = gradeData.getGrades()
                .stream()
                // Using a lambda expression as per requirements to calculate the standard deviation
                // Calculates standard deviation and convert the result into a double
                .mapToDouble(grade-> Math.pow(grade.score() - theMean, 2))
                .average()
                .getAsDouble();

        // Final portion of the standard deviation calculation
        this.theStandardDeviation = Math.sqrt(theStandardDeviation);
    }

    // Calculates letter grade of a given score based upon the standard deviation and mean
    public String calculateLetterGrade(int score) {
        // Grade multipliers as per the assignment requirements
        double upperGradeMultiplier = 1.5;
        double lowerGradeMultiplier = 0.5;

        String letterGrade;
        // If the score is more than 1.5 std dev above the mean, assigns an A.
        if (score > theMean + upperGradeMultiplier * theStandardDeviation) {
            letterGrade = "A";
        // If the score is more than 0.5 std dev above the mean, but not high enough to be an A, assigns a B.
        } else if (score > theMean + lowerGradeMultiplier * theStandardDeviation) {
            letterGrade = "B";
        // If the score is within 0.5 std dev above or below the mean, assigns a C.
        } else if (score >= theMean - lowerGradeMultiplier * theStandardDeviation && score <= theMean + lowerGradeMultiplier * theStandardDeviation) {
            letterGrade = "C";
        // If the score is below the mean but no more than 1.5 std dev below, assigns a D.
        } else if (score < theMean - lowerGradeMultiplier * theStandardDeviation && score >= theMean - upperGradeMultiplier * theStandardDeviation) {
            letterGrade = "D";
        // Otherwise, assigns an F.
        } else {
            letterGrade = "F";
        }
        // After each letter grade is calculated, increments the count for each letter grade.
        gradeData.incrementGradeCount(letterGrade);

        return letterGrade;
    }

    // Method to populate and update the gradesWithLetters list in GradeData
    public void populateGradesWithLetters() {

        // Clears the previous counts as this was causing a bug by not doing this
        gradeData.initializeGradeCounts();

        // Clears the previous letters grades list as this was causing a bug by not doing so
        gradeData.getGradesWithLetters().clear();

        // Iterates through all grades in the grades list, calculates the letters grade score
        // and stores in the gradesWithLetters list
        for (Grade grade : gradeData.getGrades()) {
            String letterGrade = calculateLetterGrade(grade.score());
            gradeData.getGradesWithLetters().add(grade.score() + " - " + letterGrade);
        }
    }

    // Adds grade to the grades list in GradeData
    public void addGrade(int score) {
        String letterGrade = calculateLetterGrade(score);
        Grade grade = new Grade(score, letterGrade);
        gradeData.getGrades().add(grade);
    }
}
