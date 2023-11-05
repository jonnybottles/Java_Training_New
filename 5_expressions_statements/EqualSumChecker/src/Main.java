// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        if (hasEqualSum(1,-1,0)) {
            System.out.println("Has equal sum");
        } else {
            System.out.println("Not equal sum");
        }


    }


    public static boolean hasEqualSum(int num1, int num2, int num3) {
        return num1 + num2 == num3;
    }
}