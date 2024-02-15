module com.jonathan.week3individualhealthassessmentprogram {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.week3individualhealthassessmentprogram to javafx.fxml;
    exports com.jonathan.week3individualhealthassessmentprogram;
    exports com.jonathan.week3individualhealthassessmentprogram.controllers;
    opens com.jonathan.week3individualhealthassessmentprogram.controllers to javafx.fxml;
}