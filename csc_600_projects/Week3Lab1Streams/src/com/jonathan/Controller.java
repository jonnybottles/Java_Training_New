package com.jonathan;

import com.jonathan.datamodel.CryptKeeper;

public class Controller {

    private CryptKeeper theCryptKeeper;

    private MainMenu theMainMenu;
    private ReadFileMenu theReadFileMenu;
    private EncodeStringMenu theEncodeStringMenu;
    private DecodeStringMenu theDecodeStringMenu;
    private ExitMenu theExitMenu;

    public Controller() {
        this.theCryptKeeper = new CryptKeeper();
        this.theMainMenu = new MainMenu("CRYPT KEEPER", "Main Menu", theCryptKeeper);
        this.theReadFileMenu = new ReadFileMenu(theMainMenu, "Read File Menu", theCryptKeeper);
        this.theEncodeStringMenu = new EncodeStringMenu(theMainMenu, "Encode String Menu", theCryptKeeper);
        this.theDecodeStringMenu = new DecodeStringMenu(theMainMenu, "Decode String Menu", theCryptKeeper);
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
