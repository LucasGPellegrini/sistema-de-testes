package com.grupo;

import java.io.IOException;

import com.grupo.model.usuarios.TipoUsuario;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CriaTipoController implements Initializable{

    @FXML
    Button buttonCria = new Button();

    @FXML
    Button buttonVoltar = new Button();

    @FXML
    Text txtTitulo = new Text();

    @FXML
    Text txtPermissoes = new Text();

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.buttonCria.setVisible(true);
        this.buttonVoltar.setVisible(true);
        this.txtPermissoes.setVisible(true);
        this.txtTitulo.setVisible(true);
    }

    @FXML
    public void criar(ActionEvent event) throws IOException {
        if(this.txtPermissoes.getText() != "" && this.txtTitulo.getText() != ""){
            String Permissoes = this.txtPermissoes.getText();
            new TipoUsuario(this.txtTitulo.getText(),getPermissions(Permissoes));
        }
    }

    private ArrayList<String> getPermissions(String tokens_String) {
        ArrayList<String> Permissoes = new ArrayList<>();
        String[] tokens = tokens_String.split("[,\\s]+");
        String auxiliar = new String();
        for (String token : tokens) {
            Permissoes.add(token);
        }
        return Permissoes;
    }

    @FXML
    private void fechar(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.buttonVoltar.getScene().getWindow();
        stage.close();
    }
}


