

public class DecodeStringMenu extends MainMenu {

    public DecodeStringMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }

    public void writeDecryptedStringPrompt() {
        String fileName = theCryptKeeper.getFilePath();
        CryptKeeper theTempCryptKeeper = CryptKeeper.readDataFromXMLFile(fileName);

        if (theTempCryptKeeper == null) {
            System.out.println("Error reading encrypted string from file.");
            System.out.println("Returning to main menu...");
        } else {
            if (!theTempCryptKeeper.getIsEncrypted()) {
                System.out.println("File: " + fileName + " does not contain encrypted data.");
            } else {
                theTempCryptKeeper.writeDataToXMLFile(fileName, false);
                System.out.println("String decrypted and successfully written back to " + fileName);
            }


        }
    }


    @Override
    public void start() {
        getFileNamePrompt();
        writeDecryptedStringPrompt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
        this.parentMenu.start();
    }


}