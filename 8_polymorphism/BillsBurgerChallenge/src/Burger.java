import java.util.ArrayList;
import java.util.List;

public class Burger extends Item{

    private List<Item> toppings;
    private boolean deluxeBurger;
    public static final double DELUXE_BURGER_ADDED_COST = 1.00;

    public Burger(String type, double basePrice) {
        super(type, basePrice);
        this.toppings = new ArrayList<>();
        if (type.equalsIgnoreCase("Deluxe Burger")) {
            this.deluxeBurger = true;
            this.adjustedPrice = this.basePrice + DELUXE_BURGER_ADDED_COST;
        } else {
            this.adjustedPrice = basePrice; // Only set this for non-deluxe burgers
        }
    }

    public void addToppings(String type) {
        Item topping;
        if (!deluxeBurger) {
            if (toppings.size() < 3) {
                topping = new Item(type);
            } else {
                System.out.println("Regular burger can only have three toppings");
                return;
            }
        } else {
            topping = new Item(type);
        }

        this.toppings.add(topping);

        if (!deluxeBurger) {
            this.adjustPriceForToppings(topping.getAdjustedPrice());

        }
    }


    private void adjustPriceForToppings(double cost) {
        this.adjustedPrice += cost;
    }

    @Override
    public String printItem() {
        StringBuilder sb = new StringBuilder();
        sb.append(type); // Assuming 'type' is the type of the burger like "Deluxe Burger"

        if (!toppings.isEmpty()) {
            sb.append(" with ");
            for (int i = 0; i < toppings.size(); i++) {
                sb.append(toppings.get(i).getType());
                if (i < toppings.size() - 1) {
                    sb.append(", "); // Add comma between toppings, but not after the last one
                }
            }

        }

        sb.append(" $");
        sb.append(String.format("%.2f", getAdjustedPrice())); // Format the price to two decimal places

        return sb.toString();
    }

}
