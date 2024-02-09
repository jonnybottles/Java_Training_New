package com.jonathan.datamodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private Scanner fileReader;
    private Formatter fileWriter;
    private String readFile;
    private String writeFile;

    // This constructor is an artifact from part one of the program
    // I left it here to show that I completed it.
    public FileHandler(String readFile, String writeFile) {
        this.readFile = readFile;
        this.writeFile = writeFile;

    }

    public FileHandler() {
    }


    // Another artifact from the first portion of the program
    // Not sure if I should leave artifacts from previous requirements in the program
    public String getReadFile() {
        return readFile;
    }

    public void setReadFile(String readFile) {
        this.readFile = readFile;
    }

    // Method for opening a file.
    public boolean openReadFile() {
        try {
            fileReader = new Scanner(new File(readFile));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    // Another artifact from the first portion of the program
    // Not sure if I should leave artifacts from previous requirements in the program
    public boolean openWriteFile() {
        try {
            fileWriter = new Formatter(writeFile);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    // Method used to close any open files for file reader and file writer.
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
}

//    // Another artifact from the first portion of the program
//    // Not sure if I should leave artifacts from previous requirements in the program
//    public boolean writeGrades(List<String> grades) {
//
//        if (fileWriter == null) {
//            return false;
//        }
//
//        try {
//            for (String grade : grades) {
//                fileWriter.format("%s%n", grade);
//            }
//
//            fileWriter.flush();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }

//    // Reads grades from the opened file.
//    public boolean readGrades() {
//        if (fileReader == null) {
//            return false;
//        }
//
//        while (fileReader.hasNext()) {
//            grades.add(fileReader.nextLine().trim());
//        }
//
//        return true;
//
//    }

