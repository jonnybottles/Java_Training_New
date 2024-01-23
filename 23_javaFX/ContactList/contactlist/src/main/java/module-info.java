module com.jonathan.contactlist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens com.jonathan.contactlist to javafx.fxml;
    opens com.jonathan.contactlist.datamodel to javafx.base;
    exports com.jonathan.contactlist;
}
