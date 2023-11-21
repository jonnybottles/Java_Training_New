public class SmartKitchen {

    CoffeeMaker brewMaster;
    DishWasher dishWasher;
    Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    public void setKitchenState(boolean shouldAddWater, boolean shouldLoadDishes, boolean shouldPourMilk) {
        if (shouldAddWater) {
            addWater();
        }

        if (shouldLoadDishes) {
            loadDishwasher();
        }

        if (shouldPourMilk) {
            pourMilk();
        }
    }

    private void addWater() {
        this.brewMaster.assignWork();
    }

    private void pourMilk() {
        this.iceBox.assignWork();
    }

    private void loadDishwasher() {
        this.dishWasher.assignWork();

    }

    public void doKitchenWork() {
        this.brewMaster.brewCoffee();
        this.dishWasher.doDishes();
        this.iceBox.orderFood();
    }


}
