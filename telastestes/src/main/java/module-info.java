module com.grupo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.grupo to javafx.fxml;
    exports com.grupo;
}
