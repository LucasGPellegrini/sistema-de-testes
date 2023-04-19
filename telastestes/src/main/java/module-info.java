module com.grupo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.grupo to javafx.fxml;
    exports com.grupo;
}
