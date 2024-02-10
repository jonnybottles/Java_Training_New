package com.jonathan.arraymaster.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

// Provides the attributes and methods for managing array objects.
public class ArrayManager {

    // Using ObservableLists as to avoid having to manually update the GUI
    // every time a change is made the arrays.
    ObservableList<Integer> theOriginalArray;
    ObservableList<Integer> theSortableArray;

    // Initializes observable array lists and adds 20 random values to the lists.
    public ArrayManager() {
        this.theOriginalArray = FXCollections.observableArrayList();
        this.theSortableArray = FXCollections.observableArrayList();
        setupArrays();
    }

    // Getter for theOriginalArray
    public ObservableList<Integer> getTheOriginalArray() {
        return theOriginalArray;
    }

    // Getter for theSortableArray
    public ObservableList<Integer> getTheSortableArray() {
        return theSortableArray;
    }

    // Adds 20 of the same random values to each list
    public void setupArrays() {
        Random theRandom = new Random();
        int attempts = 0;
        // While loop set to limit attempts to avoid infinite loop
        while (theOriginalArray.size() < 20 && attempts < 1000) {
            int randInt = theRandom.nextInt(1, 1000);
            if (!theOriginalArray.contains(randInt)) {
                theOriginalArray.add(randInt);
                theSortableArray.add(randInt);
            }
            attempts++;
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

    // Provides array size in int form.
    public int getArraySize() {
        return theOriginalArray.size();
    }

    // Provides array size in int form.
    public Integer getValue(String index) {
        // This call is safe as isValidIndex is called before this method in the controller
        int indexInt = Integer.parseInt(index);
        return theOriginalArray.get(indexInt);
    }

    // Adds number(s) to both arrays lists.
    public boolean addNumbers(String index, String... numbers) {

        // This call is safe as isValidIndex is called before this method in the controller
        int indexInt = Integer.parseInt(index);

        try {
            for (String numbersWithCommas : numbers) {
                // Split numbers passed by user by comma value and adds them to array.
                String[] numbersWithoutCommas = numbersWithCommas.split(",");

                // Iterates through entire numbers array passed by user and adds them to each array at
                // to make sure there are no duplicates
                for (String number : numbersWithoutCommas) {
                    String trimmedNumber = number.trim();
                    int trimmedNumberInt = Integer.parseInt(trimmedNumber);
                    if (containsValue(trimmedNumberInt)) {
                        return false;
                    }

                }

                // Now that there are no duplicates, add numbers to lists.
                for (String number : numbersWithoutCommas) {
                    String trimmedNumber = number.trim();
                    int trimmedNumberInt = Integer.parseInt(trimmedNumber);

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

    public boolean containsValue(Integer value) {
        return theOriginalArray.contains(value);
    }


    // Validates that the index is within bounds and is an int
    public boolean isValidAddIndex(String index) {
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

    // Validates that the index is within bounds and is an int
    public boolean isValidDeleteIndex(String index) {
        int indexInt = 0;
        try {
            indexInt = Integer.parseInt(index);
            // This is where the code differs from isValidAdd index
            // using a minus one to account for starting at the 0th index
            if (indexInt >= 0 && indexInt <= theOriginalArray.size() -1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean deleteNumber(String index) {
        // This call is safe as isValidIndex is called before this method in the controller
        int indexInt = Integer.parseInt(index);

        try {
            // Get the value from the original array to be deleted
            Integer valueToDelete = theOriginalArray.get(indexInt);

            // Remove the item from the original array by index
            theOriginalArray.remove(indexInt);

            // Removes the value from the second array by value, as the indexes would be
            // different if the list was sorted prior to calling delete.
            theSortableArray.remove(valueToDelete);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean searchNumber() {
        return true;
    }

    public String formatMessage(String msg, String logLevel) {

        String logLevelIcon = logLevel.equals("info") ? "[+]" : "[-]";

        return logLevelIcon + " " + msg;

    }



}
