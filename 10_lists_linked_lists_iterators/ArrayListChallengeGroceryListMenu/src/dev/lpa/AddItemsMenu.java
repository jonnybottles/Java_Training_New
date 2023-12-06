package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddItemsMenu extends MainMenu{

    ArrayList<String> additionalItemsList;

    public AddItemsMenu(Menu parentMenu, String menuName, String... menuItems) {
        super(parentMenu, menuName, menuItems);
        this.additionalItemsList =  new ArrayList<>();

    }

    public void addItems() {
        String additionalItemsString = getString("Please enter groceries to add (separated by commas");
        convertCommaStringToArrayList(additionalItemsString);


    }

    private  void convertCommaStringToArrayList(String additionalItemsString) {

        this.additionalItemsList = Arrays.asList(additionalItemsString.split(",");
    }

    public static void addItems(ArrayList<String> itemsToAdd, ArrayList<String> groceryList) {
        for (String item : this.additionalItemsList) {
//            getPar.add(item);

        }
    }



    public void start() {
        addItems();

    }



}
