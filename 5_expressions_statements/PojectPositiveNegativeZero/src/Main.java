public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PositiveNegativeZero(0);
        PositiveNegativeZero(-1);
        PositiveNegativeZero(2);

    }

    public static void PositiveNegativeZero(int number ) {
        if (number > 0 ) {
            System.out.println(("Positive"));
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }
}