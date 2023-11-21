public class Main {
    public static void main(String[] args) {
        SalariedEmployee jon = new SalariedEmployee("Jonathan", "07/21/1986",
                "08/04/2025", 9999999, "08/04/2004", 129000.00, false);

        System.out.println("Jonathan age: " + jon.getAge());
        System.out.println("Jonathan pay: " + jon.collectPay());
        jon.retire();

    }
}