package com.jonathan;
public class ExitMenu extends Menu {

    // Constructor for ExitMenu
    public ExitMenu(Menu parentMenu, String menuName) {
        super(parentMenu.getProgramName(), menuName);
    }

    @Override
    public void start() {
        Utilities.clearScreen();
        String capitalizedProgramName = Utilities.capitalize(getProgramName().toLowerCase());
        System.out.println("Exiting " + capitalizedProgramName + " ...");
        System.exit(0);
    }
}
