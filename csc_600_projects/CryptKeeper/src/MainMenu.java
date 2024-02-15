
// Menu class that provides the attributes and methods for the Main Menu of Crypt Keeper
public class MainMenu extends Menu {

    protected CryptKeeper theCryptKeeper;

    public MainMenu() {
    }

    public MainMenu(String programName, String menuName, CryptKeeper theCryptKeeper) {
        super(programName, menuName);
        this.theCryptKeeper = theCryptKeeper;

    }

    // Prompts user for file name and sets the attribute appropriately in CryptKeeper object
    public boolean getFileNamePrompt() {
        while (true) {
            String filePath = getString("Please enter path of file to read: ");
            if (!theCryptKeeper.openReadFile(filePath)) {
                System.out.println("File '" + filePath + "' not found.");
                pauseMenu(5000);
                continue;
            } else {
                theCryptKeeper.setFilePath(filePath);
                return true;
            }
        }
    }

    // Executes all methods required for the Main Menu
    @Override
    public void start() {
        makeASelection("Please Make a Selection");
    }


}
