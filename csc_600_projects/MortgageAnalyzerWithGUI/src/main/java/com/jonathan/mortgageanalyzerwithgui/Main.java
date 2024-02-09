package com.jonathan.mortgageanalyzerwithgui;

import com.jonathan.mortgageanalyzerwithgui.datamodel.MortgageAnalyzer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        testCalculateMortgage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 400);
        stage.setTitle("Mortgage Analyzer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void testCalculateMortgage() {
        MortgageAnalyzer analyzer = new MortgageAnalyzer();
        analyzer.setLoanAmount("140000");
        analyzer.setAnnualInterestRate("8");
        analyzer.setLoanDuration("360");

        analyzer.calculateMortgageDetails();

        System.out.println("Amount of Loan: - $" + analyzer.getFormattedLoanAmount());
        System.out.println("Annual Interest Rate: - " + analyzer.getFormattedAnnualInterestRate());
        System.out.println("Duration of Loan in Months: - " + analyzer.getFormattedLoanDuration());
        System.out.println("Monthly Payment: - $" + analyzer.getFormattedMonthlyPayment());
        System.out.println("Total Interest Paid: - $" + analyzer.getFormattedTotalInterestPaid());
    }

}