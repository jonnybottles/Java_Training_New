public class Main {
    public static void main(String[] args) {
        Car thePontiacGrandAm = new Car("Pontiac Grand Am");
        thePontiacGrandAm.startEngine();
        thePontiacGrandAm.drive();

        System.out.println("\n*****************\n");

        GasPoweredCar theChevySuburban = new GasPoweredCar("Chevy Suburban", 30, 8);
        theChevySuburban.startEngine();
        theChevySuburban.drive();

        System.out.println("\n*****************\n");

        ElectricCar theTesla = new ElectricCar("Tesla", 100, 12);
        theTesla.startEngine();
        theTesla.drive();

        System.out.println("\n*****************\n");

        HybridCar thePrius = new HybridCar("Prius", 50, 6, 4);
        thePrius.startEngine();
        thePrius.drive();


    }
}