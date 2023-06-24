package com.grupo;

import com.grupo.database.SQLiteDB;
import com.grupo.model.usuarios.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("telaLogin"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {

        // create sqlite tables if not exists
        SQLiteDB sqliteConn = new SQLiteDB();
        sqliteConn.createTablesIfNotExists();
        sqliteConn.closeConnection();

        // launch app with fxml and controllers
        launch();
    }
}