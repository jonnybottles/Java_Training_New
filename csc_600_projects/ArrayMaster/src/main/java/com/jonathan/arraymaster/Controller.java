package com.jonathan.arraymaster;

import com.jonathan.arraymaster.datamodel.ArrayManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private ArrayManager theArrayManager;

    @FXML
    private ListView<Integer> originalArrayListView;

    @FXML
    private ListView<Integer> sortableArrayListView;

    @FXML
    private Button theSortArrayButton;

    @FXML
    private Button theDisplayArrayButton;

    @FXML
    private Button theDisplaySizeButton;

    @FXML
    private TextArea theLogsTextArea;

    @FXML
    private TextField addNumbersTextField;

    @FXML
    private TextField atPositionTextField;

    @FXML
    private Button addButton;

    // Used to track whether the user has displayed the array
    // If not, no other buttons can be clicked until array is displayed.
    private boolean hasDisplayBeenClicked;

    public void initialize() {
        theArrayManager = new ArrayManager();
    }

    @FXML
    public void onDisplayArrayClicked() {
        originalArrayListView.setItems(theArrayManager.getTheOriginalArray());
        sortableArrayListView.setItems(theArrayManager.getTheSortableArray());
        hasDisplayBeenClicked = true;

    }

    @FXML
    public void onSortArrayButtonClicked() {
        if (hasDisplayBeenClicked) {
            theArrayManager.sortSortableArray();
            appendLog("Array successfully sorted.", "info");
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }

    }

    @FXML
    public void onDisplaySizeButtonClicked() {
        if (hasDisplayBeenClicked) {
            appendLog(theArrayManager.getArraySizeMessage(), "info");
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }

    }

    @FXML
    public void onAddButtonClicked() {
        if (hasDisplayBeenClicked) {
            String index = atPositionTextField.getText().trim();
            if (theArrayManager.isValidIndex(index)) {
                String numbersToAdd = addNumbersTextField.getText().trim();
                if (theArrayManager.addNumbers(index, numbersToAdd)) {
                    appendLog("Added numbers to array: " + numbersToAdd + ".", "info");
                } else {
                    appendLog("Something went wrong with adding numbers.", "error");
                }
            } else {
                String arraySize = String.valueOf(theArrayManager.getArraySize());
                appendLog("Array index must be between 0 and " + arraySize, "error");

            }
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }
    }

    // Appends text area with a given log
    private void appendLog(String msg, String logLevel) {

        // Sets logging icon to [+] if it's an info message, otherwise its considered a user
        // error and the icon it set to [-]
        String logLevelIcon = logLevel.equals("info") ? "[+] " : "[-] ";
        theLogsTextArea.appendText(logLevelIcon + msg + "\n");
        // Scrolls the text area to the bottom, removing the users from having to do so each time
        // a new log is generated
        theLogsTextArea.setScrollTop(Double.MAX_VALUE);
    }

}