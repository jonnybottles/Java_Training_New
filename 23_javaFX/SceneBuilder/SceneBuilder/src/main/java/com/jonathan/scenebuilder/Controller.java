package com.jonathan.scenebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label label;

    @FXML
    protected void handleAction() {
        label.setText("Lorenzo's getting in the mood.");
    }
}