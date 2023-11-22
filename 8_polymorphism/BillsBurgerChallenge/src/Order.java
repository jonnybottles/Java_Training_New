

public class Order {

    Item side;
    Item drink;
    Burger burger;
    private static final double BURGER_BASE_COST = 5.00;
    private static final double DRINK_BASE_COST = 1.00;
    private static final double FRIES_BASE_COST = 2.00;





    public Order() {
        this.burger = new Burger("Basic Burger", BURGER_BASE_COST);
        this.drink = new Item("Drink", DRINK_BASE_COST, 'M');
        this.side = new Item("Fries", FRIES_BASE_COST);
    }

    public void orderMeal(String burgerType, String item1, String item2) {
        this.burger = new Burger(burgerType, BURGER_BASE_COST);
        this.drink = new Item(item1, DRINK_BASE_COST);
        this.side = new Item(item2, FRIES_BASE_COST);
    }

    public void setDrinkSize(char drinkSize) {
        if (drinkSize != 'S' && drinkSize!= 'M' && drinkSize != 'L') {
            System.out.println("Invalid drink size");
        } else {
            this.drink.setSize(drinkSize);
        }
    }

    public void printItemizedList() {
        System.out.println(this.burger.printItem());
        System.out.println(this.side.printItem());
        System.out.println(this.drink.printItem());
    }



    public void printMealTotal() {
        double totalMealCost = this.burger.getAdjustedPrice() + this.drink.getAdjustedPrice() + this.side.getAdjustedPrice();
        System.out.println("MEAL TOTAL: $" + String.format("%.2f", totalMealCost));
    }





}
