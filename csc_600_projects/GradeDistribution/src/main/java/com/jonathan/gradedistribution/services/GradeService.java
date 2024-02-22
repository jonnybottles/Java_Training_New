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
