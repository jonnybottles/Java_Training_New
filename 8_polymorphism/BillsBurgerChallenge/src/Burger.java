import java.util.ArrayList;
import java.util.List;

public class Burger extends Item{

    private List<Item> toppings;
    private boolean deluxeBurger;

    public Burger(String type, double basePrice) {
        super(type, basePrice);
        double deluxeBurgerAddedCost = 1.00;
        if (type.toUpperCase() == "Deluxe".toUpperCase()) {
            this.deluxeBurger = true;
            this.adjustedPrice += this.basePrice + deluxeBurgerAddedCost;

        }
        this.toppings = new ArrayList<>();
    }

    public void addToppings(String type, double basePrice) {
        Item topping;
        if (!deluxeBurger) {
            if (toppings.size() < 3) {
                topping = new Item(type, basePrice);
            } else {
                System.out.println("Regular burger can only have three toppings");
                return;
            }
        } else {
            topping = new Item(type, basePrice);
        }

        toppings.add(topping);
        adjustPriceForToppings(topping);
    }


    private void adjustPriceForToppings(Item topping) {
        this.adjustedPrice += switch (topping.type) {
            case "Lettuce" -> 0.25;
            case "Tomato" -> 0.15;
            case "Bacon" -> 1.50;
            case "Onions" -> 0.20;
            case "Mushrooms" -> 0.30;
            default -> 0.10;
        };
    }

}
