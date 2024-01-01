import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LocationMenu extends Menu {

    protected String locationDescription;
    protected LocationMenu locationMenu;


    public LocationMenu(String programName, String menuName, String locationDescription) {
        super(programName, menuName);
        this.locationDescription = locationDescription;
    }

    @Override
    protected void displayCustomContent() {
        System.out.println("*** You're standing " + locationDescription + " ***");
        System.out.println("From here, you can see: ");
    }

    @Override
    public void start() {
        makeASelection("Select Your Compass Direction");
    }
}
