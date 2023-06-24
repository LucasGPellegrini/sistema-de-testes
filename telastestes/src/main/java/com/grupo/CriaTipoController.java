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
import javafx.scene.control.TextField;

public class CriaTipoController implements Initializable{

    @FXML
    Button buttonCria;
    @FXML
    Button buttonVoltar;

    @FXML
    TextField txtFieldTitulo;
    @FXML
    TextField txtFieldPermissoes;
    
    @FXML
    Text txtCadastrado;
    @FXML
    Text txtCampoVazio;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public CriaTipoController() {
        this.buttonCria = new Button();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.buttonCria.setVisible(true);
        this.buttonVoltar.setVisible(true);
        this.txtCadastrado.setVisible(false);
        this.txtCampoVazio.setVisible(false);
    }

    @FXML
    public void criar(ActionEvent event) throws IOException {
        if(!"".equals(this.txtFieldPermissoes.getText()) && !"".equals(this.txtFieldTitulo.getText())){
            String Permissoes = this.txtFieldPermissoes.getText();
            TipoUsuario tipo = new TipoUsuario(this.txtFieldTitulo.getText(),getPermissions(Permissoes));
            
            System.out.println("Tipo de Usuário "+tipo.getNome()+" criado!");
            System.out.println("-----Permissões:------");
            for(String permissao: tipo.getPermissoes()) {
                System.out.println("\t"+permissao);
            }
            
            this.txtCadastrado.setVisible(true);
            this.txtCampoVazio.setVisible(false);
        }
        else {
            this.txtCadastrado.setVisible(false);
            this.txtCampoVazio.setVisible(true);
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


