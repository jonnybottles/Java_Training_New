package com.jonathan.gradedistribution.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeData {

    private ObservableList<Grade> grades;
    private ObservableList<String> gradesWithLetters;
    private Map<String, Integer> gradeCounts;

    public GradeData() {
        this.grades = FXCollections.observableArrayList();
        this.gradesWithLetters = FXCollections.observableArrayList();
        this.gradeCounts = new HashMap<>();
        initializeGradeCounts();

    }

    public ObservableList<Grade> getGrades() {
        return grades;
    }

    public ObservableList<String> getGradesWithLetters() {
        return gradesWithLetters;
    }

    public void updateGradesWithLetters(ObservableList<String> formattedGrades) {
        this.gradesWithLetters.setAll(formattedGrades);
    }

    public Map<String, Integer> getGradeCounts() {
        return gradeCounts;
    }

    // Increments the count for each letter grade.
    public void incrementGradeCount(String letterGrade) {
        gradeCounts.merge(letterGrade, 1, Integer::sum);
    }

    public void initializeGradeCounts() {
        gradeCounts.put("A", 0);
        gradeCounts.put("B", 0);
        gradeCounts.put("C", 0);
        gradeCounts.put("D", 0);
        gradeCounts.put("F", 0);
    }

}
