module com.jonathan.cssapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.jonathan.cssapplication to javafx.fxml;
    exports com.jonathan.cssapplication;
}
