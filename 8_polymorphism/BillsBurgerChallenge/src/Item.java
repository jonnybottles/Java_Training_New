public class Item {

    protected String name;
    protected String type;
    protected double basePrice;
    protected double adjustedPrice;
    protected char size;
    private static final double TOMATO_COST = 0.25;
    private static final double BACON_COST = 1.00;
    private static final double MAYO_COST = 0.50;
    private static final double LETTUCE_COST = 0.25;
    private static final double ONION_COST = 0.50;

    public Item() {

    }

    public Item(String type) {
        this.type = type;
        if (!type.equalsIgnoreCase("Basic Burger")
                && (!type.equalsIgnoreCase("Deluxe Burger"))){
            this.adjustedPrice = basePrice + switch (type) {
                case "Tomato" -> TOMATO_COST;
                case "Bacon" -> BACON_COST;
                case "Mayo" -> MAYO_COST;
                case "Lettuce" -> LETTUCE_COST;
                case "Onion" -> ONION_COST;
                default -> 0.00;
            };
        }
    }

    public Item(String type, double basePrice, char size) {
        this(type, basePrice);
        if (type.equalsIgnoreCase("Drink")) {
            this.adjustedPrice = basePrice + switch (size) {
                case 'S' -> 0.50;
                case 'M' -> 1.00;
                case 'L' -> 1.50;
                default -> 0.00;
            };

        }

    }

    public Item(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }


    public String getType() {
        return type;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getAdjustedPrice() {
        if (adjustedPrice == 0) {
            return getBasePrice();
        }
        return adjustedPrice;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        if (type.equalsIgnoreCase("Drink")) {
            this.adjustedPrice = basePrice + switch (size) {
                case 'S' -> 0.50;
                case 'M' -> 1.00;
                case 'L' -> 1.50;
                default -> 0.00;
            };
        }
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setAdjustedPrice(double adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    public String printItem() {
        if (type.equalsIgnoreCase("drink")) {
            String sizeStr = (size != '\u0000') ? String.valueOf(size) + " " : "";
            return sizeStr + type + " $" + String.format("%.2f", getAdjustedPrice());
        } else {
            return type + " $" + String.format("%.2f", getAdjustedPrice());
        }
    }

}
