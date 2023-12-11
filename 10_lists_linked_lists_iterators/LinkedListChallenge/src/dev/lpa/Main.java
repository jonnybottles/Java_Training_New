package dev.lpa;

public class Main {
    public static void main(String[] args) {
        MainMenu theMainMenu = new MainMenu("Itinerary Planner", "Main Menu",
                "F, Forward",
                "B, Backward",
                "L, List places",
                "M, Menu");
        theMainMenu.start();
    }
}