package com.jonathan.namemaintenance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Obtains controller instance from controller
        Controller controller = fxmlLoader.getController();

        // Sets the event handler for closing the program with the "x" button
        stage.setOnCloseRequest((WindowEvent we) -> {
            controller.onExitButtonClicked();
        });

        stage.setTitle("Name Maintenance Program");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}