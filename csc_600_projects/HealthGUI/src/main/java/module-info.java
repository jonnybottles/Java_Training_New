module org.example.healthgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.healthgui to javafx.fxml;
    exports org.example.healthgui;
}