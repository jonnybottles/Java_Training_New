package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddItemsMenu extends MainMenu{

    ArrayList<String> additionalItemsList;
    ArrayList<String> groceryList;

    public AddItemsMenu(MainMenu parentMenu, ArrayList<String> groceryList, String menuName, String... menuItems) {
        super(parentMenu, menuName, menuItems);
        this.additionalItemsList = new ArrayList<>();
        this.groceryList = groceryList;
    }



    public void addItemsMenu() {
        String additionalItemsString = getString("Please enter groceries to add (separated by commas)");
        convertCommaStringToArrayList(additionalItemsString);
        addItems();


    }

    private void convertCommaStringToArrayList(String additionalItemsString) {
        this.additionalItemsList = new ArrayList<>(Arrays.asList(additionalItemsString.split(",")));
    }


    private void addItems() {
        for (String item : additionalItemsList) {
            if (groceryList.contains(item)) {
                System.out.println(item + " already in list, continuing list processing");
            } else {
                groceryList.add(item);

            }
        }
    }


    public void start() {
        addItemsMenu();

    }



}
