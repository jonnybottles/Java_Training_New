module com.jonathan.supercalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.supercalculator to javafx.fxml;
    exports com.jonathan.supercalculator;
}