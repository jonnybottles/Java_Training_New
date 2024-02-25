package com.jonathan.gradedistribution.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Class that provides the methods and attributes for reading a file with grades
public class FileHandler {

    private String readFile;
    private GradeService gradeService;

    public FileHandler(String readFile, GradeService gradeService) {
        this.readFile = readFile;
        this.gradeService = gradeService;

    }

    // Reads grades from a flat file and adds to the GradeData grades list
    public void readGrades() throws FileNotFoundException, NumberFormatException  {

        // Using try with resources as not to have to manage file closing manually
        try (Scanner fileReader = new Scanner(new File(readFile))) {

            while (fileReader.hasNextLine()) {
                String scoreString = fileReader.nextLine().trim();

                // Checks if grade is valid prior to adding to list
                if (gradeService.isValidGrade(scoreString)) {
                    int score = Integer.parseInt(scoreString);

                    gradeService.addGrade(score);
                } else {
                    // If grade is invalid, throw an exception
                    throw new NumberFormatException("Invalid grade " + "'" + scoreString + "'.");
                }

            }
        }
    }


}
