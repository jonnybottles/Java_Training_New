public class Item {

    protected String name;
    protected String type;
    protected double basePrice;
    protected double adjustedPrice;
    protected char size;

    public Item() {

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
        return adjustedPrice;
    }

    public char getSize() {
        return size;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setAdjustedPrice(double adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    public String printItem() {
        return "Item{" +
                ", type='" + type + '\'' +
                ", basePrice=" + basePrice +
                ", adjustedPrice=" + adjustedPrice +
                ", size=" + size +
                '}';
    }
}
