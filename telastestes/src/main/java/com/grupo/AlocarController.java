package com.grupo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AlocarController implements Initializable{
    
    @FXML
    Button buttonVoltar;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    @FXML
    private void fechar(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.buttonVoltar.getScene().getWindow();
        stage.close();
    }
    
}
