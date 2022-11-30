module com.example.wazaaaaaaap {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.wazaaaaaaap to javafx.fxml;
    exports com.example.wazaaaaaaap;
}