package com.jonathan.arraymaster;

import com.jonathan.arraymaster.datamodel.ArrayManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {

    private ArrayManager theArrayManager;

    @FXML
    private ListView<Integer> originalArrayListView;

    @FXML
    private Button displayArrayButton;

    public void initialize() {
        theArrayManager = new ArrayManager();
    }

    @FXML
    public void onDisplayArrayClicked() {
        originalArrayListView.setItems(theArrayManager.getTheOriginalArray());
    }


}