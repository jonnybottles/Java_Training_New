package com.jonathan.gradedistribution.datamodel;

import java.util.ArrayList;
import java.util.List;

public class GradeData {

    private List<Grade> grades;

    public GradeData() {
        this.grades = new ArrayList<>();
    }

    public List<Grade> getGrades() {
        return grades;
    }
}
