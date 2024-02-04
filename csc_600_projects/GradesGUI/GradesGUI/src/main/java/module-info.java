module com.jonathan.gradesgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.gradesgui to javafx.fxml;
    exports com.jonathan.gradesgui;
}