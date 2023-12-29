public class MenuController {

    private RoadMenu roadMenu;
    private HillMenu hillMenu;
    private WellHouseMenu wellHouseMenu;
    private ValleyMenu valleyMenu;
    private ForestMenu forestMenu;
    private LakeMenu lakeMenu;
    private StreamMenu streamMenu;

    public MenuController() {
        roadMenu = new RoadMenu();
        hillMenu = new HillMenu();
        wellHouseMenu = new WellHouseMenu();
        valleyMenu = new ValleyMenu();
        forestMenu = new ForestMenu();
        lakeMenu = new LakeMenu();
        streamMenu = new StreamMenu();

        roadMenu.addMenuOption("W", hillMenu);
        roadMenu.addMenuOption("E", wellHouseMenu);
        roadMenu.addMenuOption("S", valleyMenu);
        roadMenu.addMenuOption("N", forestMenu);

        hillMenu.addMenuOption("N", forestMenu);
        hillMenu.addMenuOption("E", roadMenu);

        wellHouseMenu.addMenuOption("W", roadMenu);
        wellHouseMenu.addMenuOption("N", lakeMenu);
        wellHouseMenu.addMenuOption("S", streamMenu);

        valleyMenu.addMenuOption("N", roadMenu);
        valleyMenu.addMenuOption("W", hillMenu);
        valleyMenu.addMenuOption("E", streamMenu);

        forestMenu.addMenuOption("S", roadMenu);
        forestMenu.addMenuOption("E", lakeMenu);

        lakeMenu.addMenuOption("W", forestMenu);
        lakeMenu.addMenuOption("S", wellHouseMenu);

        streamMenu.addMenuOption("W", valleyMenu);
        streamMenu.addMenuOption("N", wellHouseMenu);

    }

    public void startGame() {
        roadMenu.start();
    }


}
