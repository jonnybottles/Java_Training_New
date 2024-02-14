
public class ReadFileMenu extends MainMenu {

    public ReadFileMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }


    public void displayFileContents() {
        theCryptKeeper.readFile();
        printMenuName();
        System.out.println("File " + "'" + theCryptKeeper.getFilePath() + "'" + " contents:\n");
        System.out.println(theCryptKeeper.getFileData());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
        }

    }

    @Override
    public void start() {

        getFileNamePrompt();
        displayFileContents();
        this.parentMenu.start();
    }


}