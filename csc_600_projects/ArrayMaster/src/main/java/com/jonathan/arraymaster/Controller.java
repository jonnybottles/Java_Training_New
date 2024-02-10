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
    private TextField deleteNumberTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextField searchNumberTextField;

    // Used to track whether the user has displayed the array
    // If not, no other buttons can be clicked until array is displayed.
    private boolean hasDisplayBeenClicked;

    public void initialize() {
        theArrayManager = new ArrayManager();

        // Sets log to monospace, without this the logs do not align neatly
        // when there is a difference in the [+] or [-] prompt
        // created in append log.
        theLogsTextArea.setStyle("-fx-font-family: monospace;");

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
            if (theArrayManager.isValidAddIndex(index)) {
                String numbersToAdd = addNumbersTextField.getText().trim();
                if (theArrayManager.addNumbers(index, numbersToAdd)) {
                    appendLog("Added numbers to array: [" + numbersToAdd + "].", "info");
                } else {
                    appendLog("List cannot contain duplicate numbers.", "error");
                }
            } else {
                String arraySize = String.valueOf(theArrayManager.getArraySize());
                appendLog("Array index must be between 0 and " + arraySize, "error");

            }
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }
    }

    @FXML
    public void onDeleteButtonClicked() {
        if (hasDisplayBeenClicked) {
            String index = deleteNumberTextField.getText().trim();
            if (theArrayManager.isValidDeleteIndex(index)) {
                int deletedValue = theArrayManager.getValue(index);
                if (theArrayManager.deleteNumber(index)) {
                    appendLog("Deleted " + deletedValue + " at index " + index + ".", "info");
                } else {
                    appendLog("Something went wrong with deleting number.", "error");
                }
            } else {
                String arraySize = String.valueOf(theArrayManager.getArraySize());
                appendLog("Array index must be between 0 and " + arraySize + ".", "error");
            }
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }
    }


    public void onSearchButtonClicked() {
        if (hasDisplayBeenClicked) {
            String searchText = searchNumberTextField.getText().trim();
            Integer searchNumber;

            try {
                searchNumber = Integer.parseInt(searchText);
            } catch (NumberFormatException e) {
                appendLog("Invalid number format for search.", "error");
                return;
            }

            // Check if the number exists in the array
            boolean numberExists = theArrayManager.containsValue(searchNumber);

            // If the number doesn't exist, log a message and do not proceed with highlighting
            if (!numberExists) {
                appendLog("Number " + searchNumber + " does not exist in the array.", "info");
                return;
            }

            // If the number exists, set the cell factory to highlight the number
            highlightNumberInListView(originalArrayListView, searchNumber);
            // Optionally highlight the number in the sortable array ListView as well
            highlightNumberInListView(sortableArrayListView, searchNumber);
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");

        }

    }

    // TODO UPDATE THIS TO USE CODE FROM TEH JAVAFX COURSE!!!
    private void highlightNumberInListView(ListView<Integer> listView, Integer searchNumber) {
        listView.setCellFactory(lv -> new ListCell<Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    if (item.equals(searchNumber)) {
                        setStyle("-fx-background-color: #0095ff;"); // Highlight with blue background
                    } else {
                        setStyle("");
                    }
                }
            }
        });
        // Refresh the ListView to apply the new cell factory
        listView.refresh();
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