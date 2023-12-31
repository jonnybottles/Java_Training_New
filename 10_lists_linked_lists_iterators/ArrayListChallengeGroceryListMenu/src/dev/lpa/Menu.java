package dev.lpa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Menu {

    private String programName; // The program name.
    private Menu parentMenu; // The parent menu object.
    private String menuName; // The menu name
    private List<String> menuItems; // A list of menu items to select from.
    private boolean isMainMenu; // Used to check if the menu is a main or submenu
    private int numSelections; // Size of the menuItems list.
    private static boolean isAnyMenuRunning;


    // Constructor for MainMenu objects
    public Menu(String programName, String menuName, String... menuItems) {
        this.programName = programName.toUpperCase();
        this.menuName = Utilities.capitalize(menuName);
        this.menuItems = new ArrayList<>(Arrays.asList(menuItems));
        this.isMainMenu = true;
        // Add "Exit Program" as the last item for main menu
        this.menuItems.add("Exit Program");
        this.numSelections = this.menuItems.size(); // Set num selections to num items in the MenuItems list
    }

    // Constructor for SubMenu objects
    public Menu(Menu parentMenu, String menuName, String... menuItems) {
        this(parentMenu.programName, menuName, menuItems);
        this.parentMenu = parentMenu;
        this.isMainMenu = false;

        // Identify exit program index and add "Return to [parent menu]" menu item.
        int exitIndex = this.menuItems.indexOf("Exit Program");
        if (exitIndex != -1) {
            this.menuItems.add(exitIndex, "Return to " + parentMenu.getMenuName());
        } else {
            this.menuItems.add("Return to " + parentMenu.getMenuName());
            this.menuItems.add("Exit Program");
        }
        this.numSelections = this.menuItems.size();
    }


    public String getProgramName() {
        return programName;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public List<String> getMenuItems() {
        return menuItems;
    }

    public int getNumSelections() {
        return numSelections;
    }


    // TODO modify code to use printPrompt and inputPrompt from here
    // https://chat.openai.com/c/00075186-1067-462e-b520-9c4a3b58c148

    // Prints menu name centered to the console width with dashes on each side of menu name
    public void printMenuName() {
        Utilities.clearScreen();

        // Obtains the console width
        int consoleWidth = getConsoleWidth();

        // Centers the menu name with dashes
        String formattedMenuName = centerText(menuName, consoleWidth);

        // If this menu is the main menu, prints the program name.
        if (isMainMenu) {
            System.out.println(centerText(programName, consoleWidth));

        }
        // Prints the centered menu name with dashes
        System.out.println(formattedMenuName + "\n");
    }


    // Prints a list of menu options for the user to select from, obtains input and instantiates // calls
    // selected menu.
    public int makeASelection() {
        Scanner scanner = new Scanner(System.in);

        printMenuName();
        while (true) {

            displayCustomContent();
            displayMenuOptions();

            try {
                int userSelection = Integer.parseInt(scanner.nextLine());
                if (isValidSelection(userSelection)) {
                    return userSelection;
                } else {
                    Utilities.clearScreen();
                    printMenuName();
                    System.out.println("Invalid selection, please enter a valid option.\n ");
                }
            } catch (NumberFormatException e) {
                Utilities.clearScreen();
                printMenuName();
                System.out.println("Please enter a valid selection.\n");
            } catch (NoSuchElementException e) {
                exitProgram();
            }


        }

    }

    // Method that can be overridden by subclasses when there is a need to display custom content
    // in makeASelection after clearing the screen, but before displaying menu optons
    protected void displayCustomContent() {
        // Empty by default
    }

    // Iterates through menuItems and prints off corresponding number selection and item name
    private void displayMenuOptions() {
        for (int i = 0; i < getNumSelections(); i++) {
            System.out.println(i + 1 + ") " + menuItems.get(i));

        }
        System.out.println("\nPlease make a selection:");

    }

    // Determines if the users selection is within the bounds of the menuItems selections
    protected boolean isValidSelection(int userSelection) {
        return userSelection >= 1  && userSelection <= getNumSelections();
    }


    //Instantiates an exitMenu object
    public void exitProgram() {
        ExitMenu theExitMenu = new ExitMenu(this, "Exit Menu");
        theExitMenu.start();
    }

    public String getString(String msg) {
        Scanner scanner = new Scanner(System.in);

        printMenuName();
        while (true) {
            System.out.println(msg);
            try {

              String userString = scanner.nextLine();
                if (isValidString(userString)) {
                    return userString;
                } else {
                    System.out.println("Please enter a valid response.");
                    try {
                        // Sleep for 1 second
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        exitProgram();

                    }
                    Utilities.clearScreen();
                    printMenuName();
                }

            } catch (NoSuchElementException e) {
                exitProgram();
            }

        }

    }

    // Obtains multiple strings from a user and returns a list of strings
    public List<String> getStrings(String msg) {
        Scanner scanner = new Scanner(System.in);
        List<String> userStrings = new ArrayList<>();

        while (true) {
            try {
                System.out.println(msg);
                String response = scanner.nextLine();

                if (response.isEmpty()) {
                    break;
                }

                userStrings.add(response);
            } catch (NoSuchElementException e) {
                exitProgram();
            }
        }

        return userStrings;
    }


    public int getInt(String msg) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            } catch (NoSuchElementException e) {
                exitProgram();
            }
        }
    }


    public void start() {
    }

    private static boolean isValidString(String userString) {
        // Trim the string to remove leading and trailing whitespaces to include \n\t\r etc.
        String trimmedString = userString.trim();

        // Check if the trimmed string is empty
        return !trimmedString.isEmpty();
    }


    // TODO figure out how to have handleCtrlD work in both sub and parent menus
    // TODO when Ctrl + D is detected while receiving input (e.g. in make a selection / getString)
    // TODO it currently identifies a parent / sub menu correctly. When pressing ctrld
    // TODO from a MainMenu it will exit appropriately. When doing so from a submenu
    // TODO it returns the previous menu and gets caught in an infinite loop
    public void handleCtrlD() {
        if (isMainMenu) {
            System.out.println("Exiting " + getProgramName());
            System.exit(0);
        }
        getParentMenu().start();


    }

    // Centers text within a specified width by adding padding with dashes '-' on both sides.
    protected String centerText(String text, int width) {
        // Add space around the text for better readability
        text = " " + text + " ";

        // Calculates the lengths for left and right padding
        int[] paddingLengths = calculatePaddingLengths(text.length(), width);

        // Creates the left and right padding strings
        String leftPadding = createPaddingString('-', paddingLengths[0]);
        String rightPadding = createPaddingString('-', paddingLengths[1]);

        // Concatenates the left-padding, text, and right-padding to center the text within the specified width
        return leftPadding + text + rightPadding;
    }

    // Calculates the left and right padding lengths required to center the text
    private int[] calculatePaddingLengths(int textLength, int totalWidth) {
        // Calculates the total padding required
        int padding = (totalWidth - textLength) / 2;
        padding = Math.max(padding, 0); // Ensure padding is not negative

        // Calculates the right padding, taking into account the left padding and text length
        int rightPadding = totalWidth - textLength - padding;

        // Returns an array containing the left and right padding lengths
        return new int[]{padding, rightPadding};
    }

    // Creates a string of a specified length using a given padding character
    private String createPaddingString(char paddingChar, int length) {
        // Creates a string filled with the padding character of the specified length
        return new String(new char[length]).replace('\0', paddingChar);
    }


    // Obtains the console width
    protected static int getConsoleWidth() {
        // Determines the current operating system by querying the system property "os.name" and converting it to
        // lowercase.
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        String command;

        // Check if the operating system contains "win" (indicating it's a Windows system).
        if (operatingSystem.contains("win")) {
            // If it's a Windows system, set the command to "mod con" to obtain console width.
            command = "cmd.exe /c mode con";
        } else {
            // If it's not a Windows system, assume it's a Unix-based system (including Linux and macOS).
            // Set the command to query the console width using the "tput cols" command in a Bash shell.
            // The "2> /dev/tty" part is used to redirect any error output to the terminal.
            command = "bash -c tput cols 2> /dev/tty";
        }
        // Call the method executeCommandToGetConsoleWidth with the determined command and return the result.
        return executeCommandToGetConsoleWidth(command);
    }


    // Executes a system command to obtain the console width.
    protected static int executeCommandToGetConsoleWidth(String command) {
        // Default console width (80 columns)
        int defaultWidth = 80;
        try {
            // Executes the specified command as a system process.
            Process p = Runtime.getRuntime().exec(command);
            // Waits for the process to complete.
            p.waitFor();
            // Creates a reader to read the command's output.
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // If the command is "mode con" (Windows), and the output line contains "Columns," extract the width.
                if (command.contains("mode con") && line.contains("Columns")) {
                    defaultWidth = Integer.parseInt(line.replaceAll("\\D", ""));
                }
                // If it's not a "mode con" command (Unix-based), parse the line as an integer to get the width.
                else if (!command.contains("mode con")) {
                    defaultWidth = Integer.parseInt(line.trim());
                }
            }
        } catch (Exception e) {
            // Handles any exceptions that may occur during command execution.
            // Instead of printing the stack trace, it prints a user-friendly message and uses a default width.
            System.out.println("Error obtaining console width. Using default width: " + defaultWidth);
        }
        // Returns the obtained or default console width.
        return defaultWidth;
    }




}




