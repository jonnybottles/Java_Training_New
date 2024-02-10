package com.jonathan.arraymaster.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ArrayManager {

    // Using ObservableLists as to avoid having to manually update the GUI
    // every time a change is made the arrays.
    ObservableList<Integer> theOriginalArray;
    ObservableList<Integer> theSortableArray;

    public ArrayManager() {
        this.theOriginalArray = FXCollections.observableArrayList();
        this.theSortableArray = FXCollections.observableArrayList();
        setupArrays();
    }

    public ObservableList<Integer> getTheOriginalArray() {
        return theOriginalArray;
    }

    public ObservableList<Integer> getTheSortableArray() {
        return theSortableArray;
    }

    public void setupArrays() {
        Random theRandom = new Random();
        for (int i = 0; i < 20; i++) {
            int randInt = theRandom.nextInt(1, 100);
            theOriginalArray.add(randInt);
            theSortableArray.add(randInt);
        }

    }

    // Sorts theSortableArray by numerical order from smallest to largest
    public void sortSortableArray() {
        FXCollections.sort(theSortableArray, Comparator.naturalOrder());
    }

    // Obtains array size and returns formatted string representation.
    public String getArraySizeMessage() {
        return "Array Size: " + String.valueOf(theOriginalArray.size() + ".");
    }

    public int getArraySize() {
        return theOriginalArray.size();
    }

    public boolean addNumbers(String index, String... numbers) {

        int indexInt = Integer.parseInt(index);

        try {
            for (String numbersWithCommas : numbers) {
                String[] numbersWithoutCommas = numbersWithCommas.split(",");

                for (String number : numbersWithoutCommas) {
                    String trimmedNumber = number.trim();
                    theOriginalArray.add(indexInt, Integer.valueOf(trimmedNumber));
                    theSortableArray.add(indexInt, Integer.valueOf(trimmedNumber));
                    indexInt++;
                }

            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }


    }

    public boolean isValidIndex(String index) {
        int indexInt = 0;
        try {
            indexInt = Integer.parseInt(index);
            if (indexInt >= 0 && indexInt <= theOriginalArray.size()) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean deleteNumbers(String idnex) {
        return true;

    }

    public boolean searchNumber() {
        return true;
    }

    public String formatMessage(String msg, String logLevel) {

        String logLevelIcon = logLevel.equals("info") ? "[+]" : "[-]";

        return logLevelIcon + " " + msg;

    }


}
