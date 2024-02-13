package com.jonathan.namemaintenance;

import com.jonathan.namemaintenance.datamodel.NameManager;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private NameManager theNameManager;

    @FXML
    private TextField nameTextField;

    @FXML
    private ListView<String> nameListView;


    // Reads names.txt if it exists, if not, it creates and populates the names.txt
    // file with default values of 10 names
    public void initialize() {
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

        // Sets the nameListView to allow for multiple selections
        nameListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



    }


    // Handles Load Button being clicked, displaying the list of names to the list view.
    @FXML
    public void onLoadButtonClicked() {
        // Populates the ListView with names from NameManager
        nameListView.setItems(theNameManager.getNames());
    }

    // Handles add button events, adding names to the in memory name list of theNameManger
    @FXML
    public void onAddButtonClicked() {
        String name = nameTextField.getText().trim();
        if (name.isEmpty()) {
            displayInformationalAlert("Invalid Input", "Name cannot be blank.");
            return;
        }
        theNameManager.addName(name);
    }

    // Handles remove button events, removing names from the in memory name list of theNameManger
    @FXML
    public void onRemoveButtonClicked() {
        String name = nameTextField.getText().trim();
        if (name.isEmpty()) {
            displayInformationalAlert("Invalid Input", "Name cannot be blank.");
            return;
        }
        if (!theNameManager.removeName(nameTextField.getText().trim())) {
            displayInformationalAlert("Name not present.", name + " is not present in the names list." );
        }

    }

    // Handles select button events, displaying names selected in list view in an informational popup.
    @FXML
    public void onSelectButtonClicked() {
        // Obtain selected items from the list view and save to an observableList
        ObservableList<String> selectedNames = nameListView.getSelectionModel().getSelectedItems();

        // Ensures that a selection was made.
        if (selectedNames.isEmpty()) {
            displayInformationalAlert("No Selection", "No names were selected.");
            return;
        }

        // Iterate through all selected names and append to a stringBuilder object
        StringBuilder names = new StringBuilder();
        for (String name : selectedNames) {
            names.append(name).append("\n");
        }

        // Display informational alert with the names selected
        displayInformationalAlert("Selected Names", names.toString());
    }

    // Handles remove button events, restoring the list view to its initial state
    @FXML
    public void onResetButtonClicked() {
        theNameManager.getNames().clear();
        theNameManager.openFile("read");
        theNameManager.readNames();
        onLoadButtonClicked();
    }

    // Handles exit button events, writing the in memory names to disk and exiting the program.
    @FXML
    public void onExitButtonClicked() {
        theNameManager.openFile("write");
        theNameManager.writeNames();
        Platform.exit();

    }

    // Displays an information alert for a specific header / message
    public void displayInformationalAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informational Alert");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Displays an information alert for a specific header / message
    public void displayErrorAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}