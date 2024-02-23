package com.jonathan.gradedistribution.datamodel;

public class Grade {
    private int score;
    private String letterGrade;

    public Grade(int score, String letterGrade) {
        this.score = score;
        this.letterGrade = letterGrade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }


    @Override
    public String toString() {
        return String.valueOf(score);
    }
}
