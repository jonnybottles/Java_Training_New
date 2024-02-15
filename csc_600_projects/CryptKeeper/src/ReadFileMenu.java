
// Menu class that provides the attributes and methods for reading a specified user file.
public class ReadFileMenu extends MainMenu {

    public ReadFileMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }


    // Prints file contents to screen after obtaining file name.
    public void displayFileContents() {
        theCryptKeeper.readFile();
        printMenuName();
        System.out.println("File " + "'" + theCryptKeeper.getFilePath() + "'" + " contents:\n");
        System.out.println(theCryptKeeper.getFileData());

        pauseMenu(5000);

    }

    // Executes all methods required for the Read File Menu
    @Override
    public void start() {
        getFileNamePrompt();
        displayFileContents();
        this.parentMenu.start();
    }


}