package com.jonathan.individualhealthassessmentprogram;

import com.jonathan.individualhealthassessmentprogram.DataModel.BMICalculator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

//        testBMICalculator();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 140);
        stage.setTitle("Individual Health Assessment");
        stage.setScene(scene);
        stage.show();
    }


    private void testBMICalculator() {
        List<float[]> testCases = new ArrayList<>();
        // Add test cases as {weight, height} pairs
        testCases.add(new float[]{45f, 1.75f}); // Seriously Underweight
        testCases.add(new float[]{56.5f, 1.75f}); // Underweight
        testCases.add(new float[]{68f, 1.75f}); // Normal Weight
        testCases.add(new float[]{80f, 1.75f}); // Overweight
        testCases.add(new float[]{100f, 1.75f}); // Obese

        for (float[] testCase : testCases) {
            BMICalculator calculator = new BMICalculator();
            calculator.setHeight(testCase[1]);
            calculator.setWeight(testCase[0]);
            calculator.calculateBMI();
            System.out.println("For weight " + testCase[0] + "kg and height " + testCase[1] + "m, BMI is: " +
                    calculator.getBMIString() + " BMI Category is: " + calculator.getBMICategory());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}