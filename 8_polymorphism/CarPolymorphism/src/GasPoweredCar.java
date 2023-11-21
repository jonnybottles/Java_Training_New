public class GasPoweredCar extends Car{

    private double avgKmPerLitre;
    private int cylinders;
    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("Manly gas powered engine turns over 'HOH HOH HOH' ");
    }

    @Override
    public void drive() {
        System.out.println("Fumes fly from my exhaust as I peel wheels down the road");
        runEngine();
    }

    @Override
    protected void runEngine() {
        System.out.println("Gas engine is running");
    }
}
