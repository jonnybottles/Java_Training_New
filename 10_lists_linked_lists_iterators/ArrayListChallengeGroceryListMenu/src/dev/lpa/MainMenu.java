package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainMenu extends Menu {

    private static final int ADD_GROCERIES = 1;
    private static final int REMOVE_GROCERIES = 2;
    private static final int EXIT_PROGRAM = 3;

    private ArrayList<String> groceryList;

    public MainMenu(String programName, String menuName, String... menuItems) {
        super(programName, menuName, menuItems);
        this.groceryList = new ArrayList<>();
    }

    // Constructor for SubMenu objects in MainMenu
    public MainMenu(MainMenu parentMenu, String menuName, String... menuItems) {
        super(parentMenu, menuName, menuItems);
        this.groceryList = new ArrayList<>();
    }



    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void addOrRemoveGroceries() {

        while (true) {
            //TODO modfiy make a selection to allow for printing a custom message off before clearing screen.
            // TODO may need to do this for all other loops that get data from user
            int userSelection = makeASelection();


            if (userSelection == ADD_GROCERIES) {
                AddItemsMenu theAddItemsMenu = new AddItemsMenu(this, groceryList, "add items Menu");
                theAddItemsMenu.start();
//                System.out.println("Would call add groceries");
//                AddItemsMenuTest theAddItemsMenuTest = new AddItemsMenuTest(this, "Add Items", "Add Fruit", "Add Veggies", "Add Meat", "Add Drinks");
//                theAddItemsMenuTest.start();

            } else if (userSelection == REMOVE_GROCERIES) {
                System.out.println("Would call remove groceries");
                break;
            } else if (userSelection == EXIT_PROGRAM) {
                exitProgram();
            }


        }
    }

    @Override
    protected void displayCustomContent() {
        printGroceryList(); // Call your method to print the grocery list
    }

    private void printGroceryList() {
        Collections.sort(groceryList);
        System.out.println("*** Grocery List ***");
        if (groceryList.isEmpty()) {
            System.out.println("No Items in Grocery List");
        }
        for (String item : groceryList) {
            System.out.println(item);
        }
        System.out.println();

    }

//    public static void addItems(ArrayList<String> itemsToAdd, ArrayList<String> groceryList) {
//        for (String item : itemsToAdd) {
//            groceryList.add(item);
//        }
//    }

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
