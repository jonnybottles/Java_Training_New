module com.jonathan.scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.scenebuilder to javafx.fxml;
    exports com.jonathan.scenebuilder;
}