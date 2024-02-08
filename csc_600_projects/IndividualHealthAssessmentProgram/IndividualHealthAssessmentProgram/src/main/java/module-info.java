module com.jonathan.individualhealthassessmentprogram {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.individualhealthassessmentprogram to javafx.fxml;
    exports com.jonathan.individualhealthassessmentprogram;
}