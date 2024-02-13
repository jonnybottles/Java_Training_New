package com.jonathan.namemaintenance.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;


// Provides the attributes and methods for reading / writing names to disk.
public class NameManager {

    private Scanner fileReader;
    private Formatter fileWriter;
    private String filePath;

    // Using an ObservableList for dynamic updating of the list view
    private ObservableList<String> names;

    // This constructor is an artifact from part one of the program
    // I left it here to show that I completed it.
    public NameManager(String filePath) {
        this.filePath = filePath;
        this.names = FXCollections.observableArrayList();

    }

    // Default constructor
    public NameManager() {
        this.names = FXCollections.observableArrayList();
    }


    public ObservableList<String> getNames() {
        return names;
    }


    // Adds a given name to the names list.
    public void addName(String name) {
        names.add(Utilities.capitalize(name));
    }

    // Removes all occurrences of the given name from the names list
    public boolean removeName(String name) {
        // Check if the list contains the name
        if (names.contains(name)) {
            // Remove all occurrences of the given name
            names.removeIf(n -> n.equals(name));
            return true;
        } else {
            return false;
        }
    }

    // Method for opening a file.
    public boolean openFile(String mode) {
        try {
            if ("read".equalsIgnoreCase(mode)) {
                File file = new File(filePath);
                if (file.exists() && !file.isDirectory()) {
                    fileReader = new Scanner(file);
                    return true;
                } else {
                    return false;
                }
            } else if ("write".equalsIgnoreCase(mode)) {
                fileWriter = new Formatter(filePath);
                return true;
            } else {
                return false;
            }
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



    // Writes all names from the names list to the name filePath
    public boolean writeNames() {
        if (fileWriter == null) {
            return false;
        }

        try {
            for (String name : names) {
                fileWriter.format("%s%n", name);
            }
            fileWriter.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Reads names from the opened file.
    public boolean readNames() {
        if (fileReader == null) {
            return false;
        }

        while (fileReader.hasNext()) {
            names.add(fileReader.nextLine().trim());
        }
        return true;
    }

    // Creates names file and adds a default set of names to the file.
    public boolean createNamesFile() {
        if (!openFile("write") && !writeNames()) {
            return false;
        } else {
            addName("Jonathan");
            addName("Jacob");
            addName("Isabella");
            addName("Sophia");
            addName("Emma");
            addName("Michael");
            addName("Ethan");
            addName("Matthew");
            addName("Olivia");
            addName("Ava");
            writeNames();
            closeFile();
            return true;
        }
    }


}