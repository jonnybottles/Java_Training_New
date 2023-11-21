public class Main {
    public static void main(String[] args) {
        CoffeeMaker theCoffeeMaker = new CoffeeMaker();
        DishWasher theDishWasher = new DishWasher();
        Refrigerator theRefrigerator = new Refrigerator();

        SmartKitchen theSmartKitchen = new SmartKitchen(theCoffeeMaker, theDishWasher, theRefrigerator);

        theSmartKitchen.setKitchenState(true, true, true);
        theSmartKitchen.doKitchenWork();



    }
}