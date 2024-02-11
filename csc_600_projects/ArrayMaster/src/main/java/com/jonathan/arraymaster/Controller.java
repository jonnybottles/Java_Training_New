package com.jonathan.arraymaster;

import com.jonathan.arraymaster.datamodel.ArrayManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private ArrayManager theArrayManager;

    @FXML
    private ListView<Integer> originalArrayListView;

    @FXML
    private ListView<Integer> sortableArrayListView;

    @FXML
    private TextArea theLogsTextArea;

    @FXML
    private TextField addNumbersTextField;

    @FXML
    private TextField atPositionTextField;

    @FXML
    private TextField deleteNumberTextField;


    @FXML
    private TextField searchNumberTextField;

    // Used to track whether the user has displayed the array
    // If not, no other buttons can be clicked until array is displayed.
    private boolean hasDisplayBeenClicked;

    // Initializes ArrayManager object and sets font for TextArea.
    public void initialize() {
        theArrayManager = new ArrayManager();

        // Sets log to monospace, without this the logs do not align neatly
        // when there is a difference in the [+] or [-] prompt
        // created in append log.
        theLogsTextArea.setStyle("-fx-font-family: monospace;");

    }

    // Handles Display Array button being clicked, displaying both original / sortable arrays.
    @FXML
    public void onDisplayArrayClicked() {
        originalArrayListView.setItems(theArrayManager.getTheOriginalArray());
        sortableArrayListView.setItems(theArrayManager.getTheSortableArray());

        // Used to track whether the user has displayed the array
        // If not, no other buttons can be clicked until array is displayed.
        hasDisplayBeenClicked = true;
        appendLog("Arrays successfully loaded / displayed.", "info");

    }

    // Handles Sort Array button being clicked, Sorting the SortableArray
    @FXML
    public void onSortArrayButtonClicked() {
        // If Display Array has been clicked, run code
        // otherwise, generate log message to load / display the arrays first
        // All other event handler methods run this same check at the beginning as no actions can be performed
        // until the Display Array button has been clicked.
        if (hasDisplayBeenClicked) {
            theArrayManager.sortSortableArray();
            appendLog("Array successfully sorted.", "info");
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }

    }

    // Handles Sort Array button being clicked, logging this to the TextArea
    @FXML
    public void onDisplaySizeButtonClicked() {
        if (hasDisplayBeenClicked) {
            appendLog(theArrayManager.getArraySizeMessage(), "info");
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }

    }

    // Handles the Add Button being clicked, adding an int to each array.
    @FXML
    public void onAddButtonClicked() {
        if (hasDisplayBeenClicked) {
            String index = atPositionTextField.getText().trim();
            // Verifies a proper index is passed
            if (theArrayManager.isValidAddIndex(index)) {
                // Obtain text from Add Number text field
                String numbersToAdd = addNumbersTextField.getText().trim();
                // Adds number to arrays and logs appropriately, otherwise logs error message
                if (theArrayManager.addNumbers(index, numbersToAdd)) {
                    appendLog("Added numbers to array: [" + numbersToAdd + "].", "info");
                } else {
                    appendLog("Can only add integer values and no duplicates.", "error");
                }
            // If the index is invalid, log error to TextArea
            } else {
                String arraySize = String.valueOf(theArrayManager.getArraySize());
                appendLog("Array index must be between 0 and " + arraySize, "error");

            }
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }
    }

    // Handles the Delete Button being clicked, deleting value from a specified index in each array.
    @FXML
    public void onDeleteButtonClicked() {
        if (hasDisplayBeenClicked) {
            // Obtain index to delete from text field
            String index = deleteNumberTextField.getText().trim();

            // Validates the index, if valid delete, value and log accordingly
            if (theArrayManager.isValidDeleteIndex(index)) {
                int deletedValue = theArrayManager.getValue(index);
                if (theArrayManager.deleteNumber(index)) {
                    appendLog("Deleted " + deletedValue + " at index " + index + ".", "info");
                } else {
                    appendLog("Something went wrong with deleting number.", "error");
                }
                // If the index is invalid, log error to TextArea
            } else {
                String arraySize = String.valueOf(theArrayManager.getArraySize() -1);
                appendLog("Array index must be between 0 and " + arraySize + ".", "error");
            }
        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");
        }
    }


    // Handles all event for when search button is clicked
    // highlighting the value found in the array lists on the ListView
    public void onSearchButtonClicked() {

        if (hasDisplayBeenClicked) {
            // Obtain number to search for from Search text field
            String searchText = searchNumberTextField.getText().trim();
            Integer searchNumber;

            // Try and convert it to an int
            try {
                searchNumber = Integer.parseInt(searchText);
            } catch (NumberFormatException e) {
                appendLog("Invalid number format for search.", "error");
                return;
            }

            // If the number doesn't exist, log a message and do not proceed with highlighting
            if (!theArrayManager.containsValue(searchNumber)) {
                appendLog("Number " + searchNumber + " does not exist in the array.", "info");
                return;
            }

            // If the number exists, set the cell factory to highlight the number in both ListViews
            highlightNumberInListView(originalArrayListView, searchNumber);
            highlightNumberInListView(sortableArrayListView, searchNumber);
            appendLog("Found and highlighted " + searchNumber + ".", "info");

        } else {
            appendLog("Array must be loaded / displayed before performing any other actions.", "error");

        }

    }

    // Highlights a given number in a given list view
    private void highlightNumberInListView(ListView<Integer> listView, Integer searchNumber) {
        // Create a new ListCell using a supplier lambda function
        listView.setCellFactory(lv -> {
            ListCell<Integer> cell = new ListCell<>() {
                // Creates an anonymous subclass of ListCell and overrides the ListCell method updateItem
                // Update item method is used to customize how each cell in a ListViews content is displayed
                @Override
                protected void updateItem(Integer item, boolean isEmpty) {
                    super.updateItem(item, isEmpty);
                    // Checks to see if the given ListCell is null // empty
                    // if so set the text to null and style to ""
                    if (isEmpty || item == null) {
                        setText(null);
                        setStyle("");
                    // otherwise, obtain the string representation of the item / cell value
                    // and hightlight the cell of the number being searched
                    } else {
                        setText(item.toString());
                        if (item.equals(searchNumber)) {
                            // Highlights the cell background color for the searched number in blue.
                            setStyle("-fx-background-color: #0095ff;");
                        } else {
                            setStyle("");
                        }
                    }
                }
            };
            // End of anonymous class
            // Returns the supplier supplied ListCell
            return cell;
        });
        // end of lambda
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