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

import static com.grupo.model.usuarios.TipoUsuario.getPermissionsArrayFromString;

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
    Text txtNomeRepetido;
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
        this.txtNomeRepetido.setVisible(false);
        this.txtCampoVazio.setVisible(false);
    }

    @FXML
    public void criar(ActionEvent event) throws IOException {
        if(!"".equals(this.txtFieldPermissoes.getText()) && !"".equals(this.txtFieldTitulo.getText())){
            String Permissoes = this.txtFieldPermissoes.getText();
            TipoUsuario tipo = new TipoUsuario(this.txtFieldTitulo.getText(), getPermissionsArrayFromString(Permissoes));

            String msgErro = tipo.saveToDB();

            if(msgErro == null) {
                System.out.println("Tipo de Usuário " +tipo.getNome()+ " salvo no banco!");
                System.out.println("-----Permissões:------");
                for(String permissao: tipo.getPermissoes()) {
                    System.out.println("\t"+permissao);
                }

                this.txtCadastrado.setVisible(true);
                this.txtNomeRepetido.setVisible(false);
                this.txtCampoVazio.setVisible(false);
            }
            else{
                System.out.println("Erro: " + msgErro);

                this.txtCadastrado.setVisible(false);
                this.txtNomeRepetido.setVisible(true);
                this.txtCampoVazio.setVisible(false);
            }

        }
        else {
            this.txtCadastrado.setVisible(false);
            this.txtNomeRepetido.setVisible(false);
            this.txtCampoVazio.setVisible(true);
        }
    }

    @FXML
    private void fechar(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.buttonVoltar.getScene().getWindow();
        stage.close();
    }
}


