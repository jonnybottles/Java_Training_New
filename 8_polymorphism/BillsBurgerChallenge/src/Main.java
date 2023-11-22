public class Main {
    public static void main(String[] args) {
        Order defaultMeal = new Order();
        defaultMeal.printItemizedList();
        defaultMeal.printMealTotal();



        Order customMeal = new Order();
        customMeal.orderMeal("Burger", "Drink", "Fries");
        customMeal.burger.addToppings("Bacon");
        customMeal.burger.addToppings("Lettuce");
        customMeal.burger.addToppings("Mayo");
        customMeal.setDrinkSize('L');
        customMeal.printItemizedList();
        customMeal.printMealTotal();

        Order deluxeMeal = new Order();
        deluxeMeal.orderMeal("Deluxe Burger", "Drink", "Fries");
        deluxeMeal.burger.addToppings("Bacon");
        deluxeMeal.burger.addToppings("Lettuce");
        deluxeMeal.burger.addToppings("Mayo");
        deluxeMeal.burger.addToppings("Onion");
        deluxeMeal.setDrinkSize('L');
        deluxeMeal.printItemizedList();
        deluxeMeal.printMealTotal();


    }
}