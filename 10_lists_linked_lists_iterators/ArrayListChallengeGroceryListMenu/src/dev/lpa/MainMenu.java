package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MainMenu extends Menu {

    private static final int ADD_GROCERIES = 1;
    private static final int REMOVE_GROCERIES = 2;
    private static final int EXIT_PROGRAM = 3;

    public MainMenu(String programName, String menuName, String... menuItems) {
        super(programName, menuName, menuItems);
    }

    public void addOrRemoveGroceries() {

        while (true) {
            int userSelection = makeASelection();

            if (userSelection == ADD_GROCERIES) {
                System.out.println("Would call add groceries");
                AddItemsMenu theAddItemsMenu = new AddItemsMenu(this, "Add Items", "Add Fruit", "Add Veggies", "Add Meat", "Add Drinks");
                theAddItemsMenu.start();

            } else if (userSelection == REMOVE_GROCERIES) {
                System.out.println("Would call remove groceries");
                break;
            } else if (userSelection == EXIT_PROGRAM) {
                exitProgram();
            }

        }
    }

    public static void printGroceryList(ArrayList<String> groceryList) {
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }

    }

    public static void addItems(ArrayList<String> itemsToAdd, ArrayList<String> groceryList) {
        for (String item : itemsToAdd) {
            groceryList.add(item);
        }
    }

    public static void removeItems(ArrayList<String> itemsToRemove, ArrayList<String> groceryList) {
        for (String item : itemsToRemove) {
            groceryList.remove(item);
        }
    }


    public static boolean isAlreadyInList(ArrayList<String> itemsToAdd, ArrayList<String> groceryList) {
        for (String item : itemsToAdd) {
            if (groceryList.contains(item)) {
                return true;
            }
        }
        return false;
    }


    public void start() {
        printMenuName();
        addOrRemoveGroceries();

    }

}
