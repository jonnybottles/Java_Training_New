package com.jonathan.arraymaster.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayManager {

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

    public void sortArray() {

    }

    public void getArraySize() {

    }

    public boolean addNumbers(String index, String... numbers) {
        return true;
    }

    public boolean deleteNumbers(String idnex) {
        return true;

    }

    public boolean searchNumber() {
        return true;
    }



}
