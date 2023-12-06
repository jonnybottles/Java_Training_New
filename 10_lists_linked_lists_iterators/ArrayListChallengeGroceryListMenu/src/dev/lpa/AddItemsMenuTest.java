package dev.lpa;

public class AddItemsMenuTest extends Menu {

    private static final int ADD_FRUIT = 1;
    private static final int ADD_VEGETABLES = 2;
    private static final int ADD_MEAT = 3;
    private static final int ADD_DRINKS = 4;
    private static final int RETURN_TO_MAIN_MENU = 5;
    private static final int EXIT_PROGRAM = 6;


    public AddItemsMenuTest(Menu parentMenu, String menuName, String... menuItems) {
        super(parentMenu, menuName, menuItems);

    }

    public void addItemsToMenu() {
        while (true) {
            int userSelection = makeASelection();

            if (userSelection == ADD_FRUIT) {
                System.out.println("Would call add fruit");
                break;

            } else if (userSelection == ADD_VEGETABLES) {
                System.out.println("Would call add vegetables");
                break;
            } else if (userSelection == ADD_MEAT) {
                System.out.println("Would call add meat");
                break;
            } else if (userSelection == ADD_DRINKS) {
                System.out.println("Would call add drinks");
                break;
            } else if (userSelection == RETURN_TO_MAIN_MENU) {
                break;
            } else if (userSelection == EXIT_PROGRAM) {
                exitProgram();
            }

        }
    }

    public void start() {
        addItemsToMenu();
    }

}
