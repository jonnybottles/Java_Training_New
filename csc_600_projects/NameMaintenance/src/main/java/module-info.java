module com.jonathan.namemaintenance {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.namemaintenance to javafx.fxml;
    exports com.jonathan.namemaintenance;
}