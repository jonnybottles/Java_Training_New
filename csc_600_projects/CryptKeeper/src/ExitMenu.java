

// Simple menu that prints a message when exiting the program
public class ExitMenu extends Menu {

    // Constructor for ExitMenu
    public ExitMenu(Menu parentMenu, String menuName) {
        super(parentMenu.getProgramName(), menuName);
    }

    // Prints an exit message and exits the program
    public void exitProgram() {
        Utilities.clearScreen();
        String capitalizedProgramName = Utilities.capitalize(getProgramName().toLowerCase());
        System.out.println("Exiting " + capitalizedProgramName + " ...");
        System.exit(0);
    }

    // Executes all methods required for exitMenu
    @Override
    public void start() {
        exitProgram();
    }
}
