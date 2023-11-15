import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        inputCalculator();
    }

    public static void inputCalculator() {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        long avgRounded = 0;

        while (true) {


            try {
                int userInt = Integer.parseInt(scanner.nextLine());
                sum += userInt;
                count++;
            } catch (NumberFormatException badUserData) {
                avgRounded = Math.round((sum / count));
                break;
            }
        }

        System.out.println("SUM = " + sum + "AVG = " + avgRounded);

    }
}