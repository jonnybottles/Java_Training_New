module dev.lpa.helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.lpa.helloworldfx to javafx.fxml;
    exports dev.lpa.helloworldfx;
}