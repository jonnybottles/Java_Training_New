
// Contains the methods / attributes for the Packet class
public class Packet {
    // String member variable representing the packet data.
    private String data;

    public Packet(String data) {
        this.data = data;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Ovride super toString to print off packet data.
    @Override
    public String toString() {
        return "Packet{" +
                "data='" + data + '\'' +
                '}';
    }
}
