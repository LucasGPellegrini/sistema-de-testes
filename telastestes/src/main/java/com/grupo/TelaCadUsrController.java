package com.grupo;

import com.grupo.model.usuarios.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TelaCadUsrController implements Initializable {
    @FXML
    ComboBox<String> CBoxTipoUsr;
    // Pegar do arquivo de tipos de usuario/da pasta com os JSONS
    private String[] listaTipos = {"USR01", "USR02"};
    
    @FXML
    TextField txtNomeCompleto;
    @FXML
    TextField txtLogin;
    
    @FXML
    PasswordField txtSenha;
    
    @FXML
    Text txtInvalido;
    @FXML
    Text txtCadastrado;
    
    @FXML
    Button buttonRealizarCadst;
    
    @FXML
    Button buttonVoltar;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CBoxTipoUsr.getItems().addAll(listaTipos);
	    CBoxTipoUsr.setOnAction(this::getSelectedTipoUsr);
        txtInvalido.setVisible(false);
        txtCadastrado.setVisible(false);
    }    
    
    
    public void getSelectedTipoUsr(ActionEvent event) {
	String teste = CBoxTipoUsr.getValue();
	System.out.println(teste);
        //TODO: BUSCA O TIPO PELO NOME E RETORNA O OBJETO
        //Deve dar pra mostar as permissoes no campo de texto quando selecionar.
    }
    
    @FXML
    public void cadastrarUsuario(ActionEvent event) throws IOException {
        String nome  = txtNomeCompleto.getText();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        
        if ("".equals(nome) || "".equals(login) || "".equals(senha)) {
            txtInvalido.setVisible(true);
            txtCadastrado.setVisible(false);
        }
        else {
            // atenção incompleto aqui falta colocar no bd
            Usuario usuario = new Usuario(1, nome, login, senha);
            txtCadastrado.setVisible(true);
            txtInvalido.setVisible(false);
        }
    }
    
    @FXML
    private void fechar(ActionEvent event) throws IOException {
    Stage stage = (Stage) buttonVoltar.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
}
