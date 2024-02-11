package com.jonathan.namemaintenance;

import com.jonathan.namemaintenance.datamodel.NameManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    private NameManager theNameManager;

    @FXML
    private TextField nameTextField;

    @FXML
    private ListView<String> nameListView;



    public void initialize() {
        System.out.println("Initializing Controller");
        theNameManager = new NameManager("names.txt");

        // Check to see if the file exists
        if (theNameManager.openFile("read")) {
            theNameManager.readNames();
            theNameManager.closeFile();
        } else {
            System.out.println("file does not exist");
            if(!theNameManager.createNamesFile()) {
                displayErrorAlert("Error", "Failed to create file.");
            }
        }
    }


    @FXML
    public void onLoadButtonClicked() {
        // Populates the ListView with names from NameManager
        nameListView.setItems(theNameManager.getNames());
    }

    @FXML
    public void onAddButtonClicked() {
        String name = nameTextField.getText().trim();
        if (name.isEmpty()) {
            displayErrorAlert("Invalid Input", "Name cannot be blank.");
            return;
        }
        theNameManager.addName(name);
    }

    @FXML
    public void onRemoveButtonClicked() {
        String name = nameTextField.getText().trim();
        if (name.isEmpty()) {
            displayErrorAlert("Invalid Input", "Name cannot be blank.");
            return;
        }
        theNameManager.removeName(nameTextField.getText().trim());

    }

    @FXML
    public void onResetButtonClicked() {
        theNameManager.readNames();
    }

    @FXML
    public void onExitButtonClicked() {
        theNameManager.openFile("write");
        theNameManager.writeNames();
        Platform.exit();

    }

    // Displays error alert for invalid input.
    public void displayErrorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}