module com.jonathan.individualhealthassessmentprogramv2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.individualhealthassessmentprogramv2 to javafx.fxml;
    exports com.jonathan.individualhealthassessmentprogramv2;
}