package com.jonathan.gradesgui;

import com.jonathan.gradesgui.datamodel.FileHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Grades GUI");
        stage.setScene(scene);
        stage.show();
//        testFileHandler();

    }

    public static void main(String[] args) {
        launch();
    }

    public static void testFileHandler() {
        FileHandler theFileHandler = new FileHandler("test.txt", "test.txt");
        List<String> theGradesList = new ArrayList<String>(Arrays.asList("72.0", "100.0", "65.8", "88.0"));
        theFileHandler.openWriteFile();
        theFileHandler.writeGrades(theGradesList);

        List<String> theEmptyGradesList = new ArrayList<>();
        theFileHandler.openReadFile();
        theFileHandler.readGrades(theEmptyGradesList);

    }
}