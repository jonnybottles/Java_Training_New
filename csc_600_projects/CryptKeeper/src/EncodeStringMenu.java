
// Menu class that provides the attributes and methods for encrypting a users string.
public class EncodeStringMenu extends MainMenu {

    public EncodeStringMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }

    // Presents prompt for file name and encrypted user data to file.
    public void writeEncryptedStringPrompt() {
        String fileName = getString("Please enter a file name to save your encoded string to");
        String theStringToEncrypt = getString("Please enter a string to encode and write to file: ");
        theCryptKeeper.setUserData(theStringToEncrypt);

        // Checks to ensure the data was successfully encrypted / written to the file
        if (!theCryptKeeper.writeDataToXMLFile(fileName, true)) {
            System.out.println("Error writing encrypted string to file.");
            System.out.println("Returning to main menu...");

        } else {
            System.out.println("String encrypted and successfully written to " + fileName);

        }
    }

    // Executes all methods required for decodeString menu
    @Override
    public void start() {
        writeEncryptedStringPrompt();
        // Pauses the menu to allow the user to read the response back from the writeEncryptedStringPrompt
        // prior to returning to MainMenu.
        pauseMenu(5000);
        this.parentMenu.start();
    }


}