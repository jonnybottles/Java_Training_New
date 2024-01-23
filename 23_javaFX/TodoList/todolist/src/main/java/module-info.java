module com.jonathan.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.todolist to javafx.fxml;
    exports com.jonathan.todolist;
}