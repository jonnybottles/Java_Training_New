module org.example.mortgageanalyzerwithgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jonathan.mortgageanalyzerwithgui to javafx.fxml;
    exports com.jonathan.mortgageanalyzerwithgui;
}