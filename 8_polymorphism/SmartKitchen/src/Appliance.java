public class Appliance {

    protected boolean hasWorkToDo;

    public Appliance() {
        hasWorkToDo = false;
    }

    public void assignWork() {
        this.hasWorkToDo = true;
    }
}

class Refrigerator extends  Appliance {

    public Refrigerator() {
        super();
    }

    public void orderFood() {
        if (hasWorkToDo) {
            System.out.println("Food is being ordered");
        }
    }

}

class DishWasher extends Appliance {

    public DishWasher() {
        super();
    }

    public void doDishes() {
        if (hasWorkToDo) {
            System.out.println("Dishes are being washed");
        }
    }

}

class CoffeeMaker extends Appliance {

    public CoffeeMaker() {
        super();
    }

    public void brewCoffee() {
        if (hasWorkToDo) {
            System.out.println("Coffee is being brewed");
        }
    }

}


