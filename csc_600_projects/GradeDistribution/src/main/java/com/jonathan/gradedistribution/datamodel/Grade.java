package com.jonathan.gradedistribution.datamodel;

// The record class for a Grade
public record Grade(int score, String letterGrade) {

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}
