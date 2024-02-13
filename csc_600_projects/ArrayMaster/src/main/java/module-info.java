module org.example.arraymaster {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.arraymaster to javafx.fxml;
    exports com.jonathan.arraymaster;
}