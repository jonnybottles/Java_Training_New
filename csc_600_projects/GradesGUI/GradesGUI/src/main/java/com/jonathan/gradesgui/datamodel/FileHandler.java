package com.jonathan.gradesgui.datamodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private Scanner fileReader;
    private Formatter fileWriter;
    private String readFile;
    private String writeFile;

    private List<String> grades;

    public FileHandler(String readFile, String writeFile) {
        this.readFile = readFile;
        this.writeFile = writeFile;
        grades = new ArrayList<>();

    }

    public FileHandler() {
        grades = new ArrayList<>();
    }

    public List<String> getGrades() {
        return grades;
    }

    public String getReadFile() {
        return readFile;
    }

    public void setReadFile(String readFile) {
        this.readFile = readFile;
    }

    public String getWriteFile() {
        return writeFile;
    }

    public void setWriteFile(String writeFile) {
        this.writeFile = writeFile;
    }

    public boolean openReadFile() {
        try {
            fileReader = new Scanner(new File(readFile));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean openWriteFile() {
        try {
            fileWriter = new Formatter(writeFile);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean writeGrades(List<String> grades) {

        if (fileWriter == null) {
            return false;
        }

        try {
            for (String grade : grades) {
                fileWriter.format("%s%n", grade);
            }

            fileWriter.flush();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean readGrades() {
        if (fileReader == null) {
            return false;
        }

        while (fileReader.hasNext()) {
            grades.add(fileReader.nextLine().trim());
        }

        return true;

    }

    public void closeFile() {
        if (fileWriter != null) {
            fileWriter.close();
            fileWriter = null;
        }
        if (fileReader != null) {
            fileReader.close();
            fileReader = null;
        }
    }

    public String getGPA(String grade) {
        switch (grade) {
            case "A":
                return "4.0";
            case "A-":
                return "3.7";
            case "B+":
                return "3.3";
            case "B":
                return "3.0";
            case "B-":
                return "2.7";
            case "C+":
                return "2.3";
            case "C":
                return "2.0";
            case "C-":
                return "1.7";
            case "D+":
                return "1.3";
            case "D":
                return "1.0";
            case "D-":
                return "0.7";
            case "F":
                return "0.0";
            default:
                return "Invalid grade";
        }
    }


}
