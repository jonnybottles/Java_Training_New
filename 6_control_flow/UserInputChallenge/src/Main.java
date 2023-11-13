import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = getIntsSum();
        System.out.println("The sum is: " + sum);
    }

    public static int getIntsSum() {
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        int sum = 0;
        while (count != 6) {

            System.out.println("Enter number #" + count);
            try {
                String userInput = scanner.nextLine();
                int userInt = Integer.parseInt(userInput);
                sum += userInt;
                count++;

;            } catch (NumberFormatException badUserData) {
                System.out.println("ERROR: Please enter digits only.");
            }
        }

        return sum;

    }


}