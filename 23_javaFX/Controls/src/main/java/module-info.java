module dev.lpa {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.lpa to javafx.fxml;
    exports dev.lpa;
}