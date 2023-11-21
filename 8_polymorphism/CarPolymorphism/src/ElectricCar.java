public class ElectricCar extends Car{

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    public double getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public int getBatterySize() {
        return batterySize;
    }
    @Override
    public void startEngine() {
        System.out.println("Electric engine silently starts up");
    }

    @Override
    public void drive() {
        System.out.println("Electric car hummmssss down the road");
        runEngine();
    }

    @Override
    protected void runEngine() {
        System.out.println("Electric engine is silently running");
    }

}
