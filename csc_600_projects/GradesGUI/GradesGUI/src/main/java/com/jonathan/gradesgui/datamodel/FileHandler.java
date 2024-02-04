package com.jonathan.gradesgui.datamodel;

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

    public FileHandler(String readFile, String writeFile) {
        this.readFile = readFile;
        this.writeFile = writeFile;

    }


    public boolean openReadFile() {
        try {
            fileReader = new Scanner(new File(readFile));
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File: " + readFile + " not found.");
            return false;
        }
    }

    public boolean openWriteFile() {
        try {
            fileWriter = new Formatter(writeFile);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File " + writeFile + " could not be created or opened for writing.");
            return false;
        }
    }

    public boolean writeGrades(List<String> grades) {

        if (fileWriter == null) {
            System.out.println("File writer was not initialized");
            return false;
        }

        try {
            for (String grade : grades) {
                fileWriter.format("%s%n", grade);
            }

            fileWriter.flush();
            return true;
        } catch (Exception e) {
            System.out.println("Error occurred while writing grades to file");
            return false;
        }

    }

    public boolean readGrades(List<String> grades) {
        if (fileReader == null) {
            System.out.println("File reader was not initialized");
            return false;
        }

        while (fileReader.hasNext()) {
            grades.add(fileReader.nextLine().trim());
        }

        System.out.println("The grades read from the file are:");
        for (String grade : grades) {
            System.out.println(grade);
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

}
