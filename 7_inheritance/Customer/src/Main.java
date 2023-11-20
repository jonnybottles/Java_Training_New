public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Jon", 450, "jon@gmail.com");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmailAddress());
    }
}