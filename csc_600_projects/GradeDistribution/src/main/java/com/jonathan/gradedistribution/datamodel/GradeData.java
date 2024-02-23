package com.jonathan.gradedistribution.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class GradeData {

    private ObservableList<Grade> grades;
    private ObservableList<String> gradesWithLetters;

    public GradeData() {
        this.grades = FXCollections.observableArrayList();
        this.gradesWithLetters = FXCollections.observableArrayList();
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
}
