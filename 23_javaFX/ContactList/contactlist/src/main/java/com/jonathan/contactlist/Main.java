package com.jonathan.contactlist;

import com.jonathan.contactlist.datamodel.ContactData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 400);
        stage.setTitle("My Contacts");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        ContactData.getInstance().saveContacts();
    }

    @Override
    public void init() throws Exception {
        ContactData.getInstance().loadContacts();

    }

    public static void main(String[] args) {
        launch();
    }
}