package dev.lpa;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {



        Menu theMainMenu = new Menu("Minecraft Server", "Main Menu");

        theMainMenu.addMenuOption("A", new Menu(theMainMenu, "Login"));
        theMainMenu.addMenuOption("B", new Menu(theMainMenu, "Create New Server"));
        theMainMenu.addMenuOption("C", new Menu(theMainMenu, "Delete Server"));

        theMainMenu.makeASelection("Please make a selection: ");





    }
}
