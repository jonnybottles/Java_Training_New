

// Menu class that provides the attributes and methods for decoding a users string.
public class DecodeStringMenu extends MainMenu {

    public DecodeStringMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }

    // Presents prompt for file name and decrypts user data from file.
    public void writeDecryptedStringPrompt() {
        getFileNamePrompt();

        // Gets file path set in getFileNamePrompt()
        String fileName = theCryptKeeper.getFilePath();
        CryptKeeper theTempCryptKeeper = CryptKeeper.readDataFromXMLFile(fileName);

        // If CryptKeeper is Null, unmarshalling failed for some reason.
        if (theTempCryptKeeper == null) {
            System.out.println("Error reading encrypted string from file.");
            System.out.println("Returning to main menu...");
        } else {
            // Checks to make sure the file specified actually has encrypted before reading it in to decrypt
            if (!theTempCryptKeeper.getIsEncrypted()) {
                System.out.println("File: " + fileName + " does not contain encrypted data.");
            } else {
                // If the data in the file is encrypted, it is decrypted and written back to disk unencrypted
                theTempCryptKeeper.writeDataToXMLFile(fileName, false);
                System.out.println("String decrypted and successfully written back to " + fileName);
            }


        }
    }


    // Executes all methods required for decodeString menu
    @Override
    public void start() {
        writeDecryptedStringPrompt();
        // Pauses the menu to allow the user to read the response back from the writeDecryptedStringPrompt
        // prior to returning to MainMenu.
        pauseMenu(5000);
        this.parentMenu.start();
    }


}