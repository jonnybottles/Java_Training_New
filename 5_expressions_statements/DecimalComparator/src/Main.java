// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        if (areEqualByThreeDecimalPlaces(-3.1756, -3.175)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        String num1String = createStartPoint(num1);
        String num2String = createStartPoint(num2);

        int maxIter = Math.max(3, num1String.length());

        for (int i = 0; i < maxIter; i ++ ) {
            if (num1String.charAt(i) != num2String.charAt(i)) {
                return false;
            }
        }
        return true;

    }

    public static String createStartPoint(double num) {
        String numString = String.format("%6f", num);

        int index = numString.indexOf(".");

        return numString.substring(index);

    }



}