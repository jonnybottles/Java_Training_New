public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Car Engine Started");
    }

    public void drive() {
        System.out.println("Driving Car");
        runEngine();
    }

    protected void runEngine() {
        System.out.println("Engine is running");
    }

    public String getDescription() {
        return description;
    }
}
