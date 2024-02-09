package com.jonathan.arraymaster.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayManager {

    ObservableList<Integer> theOriginalArray;
    ObservableList<Integer> theModifiedArray;

    public ArrayManager() {
        this.theOriginalArray = FXCollections.observableArrayList();
        this.theModifiedArray = FXCollections.observableArrayList();
        setupArray();
    }

    public ObservableList<Integer> getTheOriginalArray() {
        return theOriginalArray;
    }

    public ObservableList<Integer> getTheModifiedArray() {
        return theModifiedArray;
    }

    public void setupArray() {
        Random theRandom = new Random();
        for (int i = 0; i < 20; i++) {
            theOriginalArray.add(theRandom.nextInt(1, 100));
        }
    }


}
