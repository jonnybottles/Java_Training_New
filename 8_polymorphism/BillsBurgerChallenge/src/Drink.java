public class Drink extends Item {

    public Drink(String type, double basePrice, char size) {
        super(type, 1.00);
        this.size = size;
        this.adjustedPrice = basePrice + switch (size) {
            case 'S' -> 0.50;
            case 'M' -> 1.00;
            case 'L' -> 1.50;
            default -> 0.00;
        };
    }


    @Override
    public String printItem() {
        return "Drink{" +
                "adjustedPrice=" + adjustedPrice +
                "} ";
    }
}
