

public class MainMenu extends Menu {


    protected CryptKeeper theCryptKeeper;

    public MainMenu() {
    }

    public MainMenu(String programName, String menuName, CryptKeeper theCryptKeeper) {
        super(programName, menuName);
        this.theCryptKeeper = theCryptKeeper;

    }

    public boolean getFileNamePrompt() {
        while (true) {
            String filePath = getString("Please enter path of file to read: ");
            if (!theCryptKeeper.openReadFile(filePath)) {
                System.out.println("File '" + filePath + "' not found.");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.err.println("Sleep interrupted: " + e.getMessage());
                }
                continue;
            } else {
                theCryptKeeper.setFilePath(filePath);
                return true;
            }
        }
    }

    @Override
    public void start() {
        makeASelection("Please Make a Selection");
    }


}
