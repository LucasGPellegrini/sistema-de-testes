module com.grupo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.grupo to javafx.fxml;
    exports com.grupo;
}
