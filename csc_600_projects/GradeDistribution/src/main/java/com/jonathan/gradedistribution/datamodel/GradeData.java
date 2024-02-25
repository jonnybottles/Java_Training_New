package com.jonathan.gradedistribution.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class GradeData {

    // ObservableList for Grade objects to be used in ListView
    private ObservableList<Grade> grades;
    // ObservableList for Strings of score to grade letter mapping to be used in ListView
    private ObservableList<String> gradesWithLetters;
    // Map used to associated grades to counts
    private Map<String, Integer> gradeCounts;

    public GradeData() {
        this.grades = FXCollections.observableArrayList();
        this.gradesWithLetters = FXCollections.observableArrayList();
        this.gradeCounts = new HashMap<>();
        initializeGradeCounts();

    }

    // Getters
    public ObservableList<Grade> getGrades() {
        return grades;
    }

    public ObservableList<String> getGradesWithLetters() {
        return gradesWithLetters;
    }


    public Map<String, Integer> getGradeCounts() {
        return gradeCounts;
    }

    // Increments the count for each letter grade
    public void incrementGradeCount(String letterGrade) {
        gradeCounts.merge(letterGrade, 1, Integer::sum);
    }

    // Initializes all grade counts to zero
    public void initializeGradeCounts() {
        gradeCounts.put("A", 0);
        gradeCounts.put("B", 0);
        gradeCounts.put("C", 0);
        gradeCounts.put("D", 0);
        gradeCounts.put("F", 0);
    }

}
