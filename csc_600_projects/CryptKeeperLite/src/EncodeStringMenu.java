

public class EncodeStringMenu extends MainMenu {

    public EncodeStringMenu(MainMenu parentMenu, String menuName, CryptKeeper theCryptKeeper) {
        this.parentMenu = parentMenu;
        this.menuName = menuName;
        this.theCryptKeeper = theCryptKeeper;
    }

    public void writeEncryptedStringPrompt() {
        String fileName = getString("Please enter a file name to save your encoded string to");
        String theStringToEncrypt = getString("Please enter a string to encode and write to file: ");
        theCryptKeeper.setUserData(theStringToEncrypt);

        if (!theCryptKeeper.writeDataToXMLFile(fileName, true)) {
            System.out.println("Error writing encrypted string to file.");
            System.out.println("Returning to main menu...");

        } else {
            System.out.println("String encrypted and successfully written to " + fileName);

        }
    }

    @Override
    public void start() {
        writeEncryptedStringPrompt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
        this.parentMenu.start();
    }


}