
// The controller class includes all the attributes and methods for
// controlling the Menus within CryptKeeper
class Controller {

    private CryptKeeper theCryptKeeper;

    private MainMenu theMainMenu;
    private ReadFileMenu theReadFileMenu;
    private EncodeStringMenu theEncodeStringMenu;
    private DecodeStringMenu theDecodeStringMenu;
    private ExitMenu theExitMenu;

    // Controller constructor initializes the controller and theCryptKeeper
    public Controller() {
        this.theCryptKeeper = new CryptKeeper();
    }

    // Initializes all menus
    public void initializeMenus() {
        this.theMainMenu = new MainMenu("CRYPT KEEPER", "Main Menu", theCryptKeeper);
        this.theReadFileMenu = new ReadFileMenu(theMainMenu, "Read File Menu", theCryptKeeper);
        this.theEncodeStringMenu = new EncodeStringMenu(theMainMenu, "Encode String Menu", theCryptKeeper);
        this.theDecodeStringMenu = new DecodeStringMenu(theMainMenu, "Decode String Menu", theCryptKeeper);
        this.theExitMenu = new ExitMenu(theMainMenu, "");
    }

    // Adds menu options to all menus
    public void addMenuOptions() {
        theMainMenu.addMenuOption("1", theReadFileMenu, "Read File");
        theMainMenu.addMenuOption("2", theEncodeStringMenu, "Encode String");
        theMainMenu.addMenuOption("3", theDecodeStringMenu, "Decode String");
        theMainMenu.addMenuOption("4", theExitMenu, "Exit Program");
    }

//    // Sets menu option descriptions for all menus.
//    public void setMenuOptionDescriptions() {
//        theReadFileMenu.setMenuOptionDescription("Read File");
//        theEncodeStringMenu.setMenuOptionDescription("Encode String");
//        theDecodeStringMenu.setMenuOptionDescription("Decode String");
//        theExitMenu.setMenuOptionDescription("Exit Program");
//    }

    public void start() {
        initializeMenus();
        addMenuOptions();
//        setMenuOptionDescriptions();
        theMainMenu.start();
    }


}
