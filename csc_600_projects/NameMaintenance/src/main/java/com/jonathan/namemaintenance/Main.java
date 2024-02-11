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

        // Get the controller instance from the loader
        Controller controller = fxmlLoader.getController();

        // Set the event handler for the close request
        stage.setOnCloseRequest((WindowEvent we) -> {
            controller.onExitButtonClicked();
            // No need to call Platform.exit() here since it's called inside onExitButtonClicked() method
        });

        stage.setTitle("Name Maintenance Program");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}