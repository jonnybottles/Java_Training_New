public class HybridCar extends Car{

    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("Hybrid engine quietly starts up");
    }

    @Override
    public void drive() {
        System.out.println("Hybrid car struts down the road");
        runEngine();
    }

    @Override
    protected void runEngine() {
        System.out.println("This vehicle is a " + this.getClass().getSimpleName() + " object");
        System.out.println("Hybrid engine is quietly running");
    }



}
