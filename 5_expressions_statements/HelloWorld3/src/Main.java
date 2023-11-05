// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        String makeOfCar = "Volkswagon";
        boolean isDomestic = makeOfCar == "Volkswagon" ? false : true;

        if (isDomestic) {
            System.out.println("This car is domestic to our country");
        }

        String s = (isDomestic) ? "This car is domestic " : "This car is not domestic";

        double double1 = 20.00;
        double double2 = 80.00;
        double double3 = (double1 + double2) * 100.00;

        double theRemainder = double3 / 40.00;

        boolean myBool = theRemainder == 0.00 ? false : true;

        System.out.println(myBool);

        if (!myBool) {
            System.out.println("Got some remainder");
        }

    }
}