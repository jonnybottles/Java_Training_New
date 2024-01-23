module dev.lpa.layouts {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.lpa.layouts to javafx.fxml;
    exports dev.lpa.layouts;
}