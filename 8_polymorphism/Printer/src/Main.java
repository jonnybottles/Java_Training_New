public class Main {
    public static void main(String[] args) {
        // Test 1: Initializing the Printer
        Printer printer = new Printer(50, false);
        System.out.println("Initial Toner Level: " + printer.getTonerLevel()); // Should be 50
        System.out.println("Initial Pages Printed: " + printer.getPagesPrinted()); // Should be 0
        System.out.println("Is Duplex: " + printer.isDuplex()); // Should be true

        // Test 2: Adding Toner
        System.out.println("Added Toner: " + printer.addToner(25)); // Should return 75
        System.out.println("Added Toner: " + printer.addToner(30)); // Should return -1 as it exceeds 100

        // Test 3: Printing Pages
        System.out.println("Pages Printed: " + printer.printPages(10)); // Should return 5 if duplex, 10 if not
        System.out.println("Total Pages Printed: " + printer.getPagesPrinted()); // Should update accordingly
    }
}
