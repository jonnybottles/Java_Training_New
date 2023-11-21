public class Product {

    private String model;
    private String manufactuer;
    private int width;
    private int height;
    private int depth;


    public Product(String model, String manufactuer) {
        this.model = model;
        this.manufactuer = manufactuer;
    }
}

class Monitor extends Product {

    private int size;
    private String resolution;


    public Monitor(String model, String manufactuer) {
        super(model, manufactuer);
    }

    public Monitor(String model, String manufactuer, int size, String resolution) {
        super(model, manufactuer);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println(String.format(
                "Drawing pixel at %d, %d in color %s", x, y, color));
    }

}

class Motherboard extends Product {
    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, String manufactuer) {
        super(model, manufactuer);
    }

    public Motherboard(String model, String manufactuer, int ramSlots, int cardSlots, String bios) {
        super(model, manufactuer);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading...");
    }

}

class ComputerCase extends Product {

    private String powerSupply;

    public ComputerCase(String model, String manufactuer) {
        super(model, manufactuer);
    }

    public ComputerCase(String model, String manufactuer, String powerSupply) {
        super(model, manufactuer);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }
}