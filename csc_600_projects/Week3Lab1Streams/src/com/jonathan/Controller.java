package com.jonathan;

public class Controller {

    private MainMenu theMainMenu;
    private ReadFileMenu theReadFileMenu;
    private EncodeStringMenu theEncodeStringMenu;
    private DecodeStringMenu theDecodeStringMenu;
    private ExitMenu theExitMenu;

    public Controller() {
        this.theMainMenu = new MainMenu("CRYPT KEEPER", "Main Menu");
        this.theReadFileMenu = new ReadFileMenu(theMainMenu, "Read File");
        this.theEncodeStringMenu = new EncodeStringMenu(theMainMenu, "Encode String");
        this.theDecodeStringMenu = new DecodeStringMenu(theMainMenu, "Decode String");
        this.theExitMenu = new ExitMenu(theMainMenu, "");

        theMainMenu.addMenuOption("1", theReadFileMenu);
        theMainMenu.addMenuOption("2", theEncodeStringMenu);
        theMainMenu.addMenuOption("3", theDecodeStringMenu);
        theMainMenu.addMenuOption("4", theExitMenu);

        theReadFileMenu.setMenuOptionDescription("Read File");
        theEncodeStringMenu.setMenuOptionDescription("Encode String");
        theDecodeStringMenu.setMenuOptionDescription("Decode String");
        theExitMenu.setMenuOptionDescription("Exit Program");
    }

    public void start() {
        theMainMenu.start();
    }


}
