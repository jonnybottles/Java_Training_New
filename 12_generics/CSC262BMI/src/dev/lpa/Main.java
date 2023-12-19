package dev.lpa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double weightInPounds = getDouble("Please enter your weight in pounds: ");
        double heightInInches = getDouble("Please enter your height in inches: ");


        double weightInKilos = convertPoundsToKilos(weightInPounds);
        double heightInMeters = convertInchesToMeters(heightInInches);


        double BMITotal = calculateBMI(weightInKilos, heightInMeters);
        String BMIClassification = getBMIClassification(BMITotal);
        System.out.printf("Your BMI is: %.4f \n", BMITotal);
        System.out.println("Your BMI classification is: " + BMIClassification);

    }

    public static double getDouble(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return Double.parseDouble(scanner.nextLine());
    }

    public static double convertPoundsToKilos(double pounds) {
        return pounds * 0.4536;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String getBMIClassification(double BMI) {
        String BMIClassification;
        if (BMI >= 18.5 && BMI <= 24.9) {
            BMIClassification = "Normal";
        } else if (BMI >= 25 && BMI <= 29.9) {
            BMIClassification = "Overweight";
        } else if (BMI >= 30 && BMI <= 34.9) {
            BMIClassification = "Obese";
        } else if (BMI >= 35 && BMI <= 39.9) {
            BMIClassification = "Severely Obese";
        } else if(BMI >= 40) {
            BMIClassification = "Morbid Obese";
        } else {
            BMIClassification = "Invalid BMI";
        }

        return BMIClassification;
    }


}