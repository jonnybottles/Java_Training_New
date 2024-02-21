module com.jonathan.gradedistribution {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.gradedistribution to javafx.fxml;
    exports com.jonathan.gradedistribution;
    exports com.jonathan.gradedistribution.controllers;
    opens com.jonathan.gradedistribution.controllers to javafx.fxml;
}