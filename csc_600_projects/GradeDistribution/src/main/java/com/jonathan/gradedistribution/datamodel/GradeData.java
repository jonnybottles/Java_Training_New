package com.jonathan.gradedistribution.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class GradeData {

    private ObservableList<Grade> grades;

    public GradeData() {
        this.grades = FXCollections.observableArrayList();
    }

    public ObservableList<Grade> getGrades() {
        return grades;
    }
}
