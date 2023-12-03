package dev.lpa;

//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        MainMenu theMainMenu = new MainMenu("Grocery Shopper", "Main Menu", "Add Groceries",
                "Remove Groceries");

        theMainMenu.start();
    }


//        ArrayList<String> groceryList = new ArrayList<>();
//
//        ArrayList<String> itemsList;
//        while (true) {
//            int selection = getSelection();
//            switch (selection) {
//                case 0:
//                    System.out.println("exit program");
//                    System.exit(0);
//                    break;
//                case 1:
//                    System.out.println("Call Add Items");
//                    itemsList = getItems("Please type items to add.");
//                    if (isAlreadyInList(itemsList, groceryList)) {
//                        System.out.println("Cannot add duplicate items to list.");
//                        continue;
//                    }
//                    addItems(itemsList, groceryList);
//                    break;
//                case 2:
//                    System.out.println("Call Remove Items");
//                    itemsList = getItems("Please type items to remove.");
//                    removeItems(itemsList, groceryList);
//                    break;
//            }
//
//            printGroceryList(groceryList);
//        }
//
//
//    }
//
//    public static void displayMenu() {
//        System.out.println("Please make a selection: ");
//        System.out.println("0) - Shutdown");
//        System.out.println("1) - Add Item(s)");
//        System.out.println("2) - Remove Item(s)");
//    }
//
//    public static int getSelection() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            displayMenu();
//            try {
//                int userInt = Integer.parseInt(scanner.nextLine());
//                if (isValidInt(userInt)) {
//                    return userInt;
//                } else {
//                    System.err.println("Please enter a value between 0 and 2.");
//                }
//            } catch (IllegalArgumentException e) {
//                System.err.println("Please enter a digit value.");
//            }
//        }
//
//    }
//
//    public static void printGroceryList(ArrayList<String> groceryList) {
//        Collections.sort(groceryList);
//        for (String item : groceryList) {
//            System.out.println(item);
//        }
//
//    }
//
//    public static void addItems(ArrayList<String> itemsToAdd, ArrayList<String> groceryList) {
//        for (String item : itemsToAdd) {
//            groceryList.add(item);
//        }
//    }
//
//    public static void removeItems(ArrayList<String> itemsToRemove, ArrayList<String> groceryList) {
//        for (String item : itemsToRemove) {
//            groceryList.remove(item);
//        }
//    }
//
//    public static ArrayList<String> getItems(String msg) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(msg);
//        String items = scanner.nextLine();
//        ArrayList<String> itemsList = new ArrayList<>(Arrays.asList(items.split(",")));
//        return itemsList;
//    }
//
//    public static boolean isValidInt(int theInt) {
//        return theInt >= 0 && theInt <= 2;
//    }
//
//    public static boolean isAlreadyInList(ArrayList<String> itemsToAdd, ArrayList<String> groceryList) {
//        for (String item : itemsToAdd) {
//            if (groceryList.contains(item)) {
//                return true;
//            }
//        }
//        return false;
//    }

}