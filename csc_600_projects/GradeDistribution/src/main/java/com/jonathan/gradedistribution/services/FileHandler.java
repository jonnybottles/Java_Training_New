package com.jonathan.gradedistribution.services;

import com.jonathan.gradedistribution.datamodel.Grade;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private String readFile;
    private GradeService gradeService;


    // This constructor is an artifact from part one of the program
    // I left it here to show that I completed it.
    public FileHandler(String readFile) {
        this.readFile = readFile;
        this.gradeService = new GradeService();

    }


    // Another artifact from the first portion of the program
    // Not sure if I should leave artifacts from previous requirements in the program
    public String getReadFile() {
        return readFile;
    }

    public void setReadFile(String readFile) {
        this.readFile = readFile;
    }

    // Reads grades from a flat file
    public List<Grade> readGrades() throws FileNotFoundException {
        List<Grade> grades = new ArrayList<>();

        // Using try with resources as not to have to manage file closing
        // manually
        try (Scanner fileReader = new Scanner(new File(readFile))) {

            while (fileReader.hasNextLine()) {
                String scoreString = fileReader.nextLine().trim();

                if (gradeService.isValidGrade(scoreString)) {
                    int score = Integer.parseInt(scoreString);

                    gradeService.addGrade(score);
                }
            }
        }
        return grades;
    }


}
