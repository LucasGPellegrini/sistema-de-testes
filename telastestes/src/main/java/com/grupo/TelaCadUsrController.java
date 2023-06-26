package com.grupo;

import com.grupo.model.usuarios.TipoUsuario;
import com.grupo.model.usuarios.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

import static com.grupo.model.usuarios.TipoUsuario.getAllUserTypesFromDB;


public class TelaCadUsrController implements Initializable {
    @FXML
    ComboBox<String> CBoxTipoUsr;

    ArrayList<TipoUsuario> listaTipos;

    Integer tipoSelecionado = -1;
    
    @FXML
    TextField txtNomeCompleto;
    @FXML
    TextField txtLogin;
    
    @FXML
    PasswordField txtSenha;

    @FXML
    Text txtInvalido;

    @FXML
    Text txtTipoInvalido;

    @FXML
    Text txtUsuarioRepetido;

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

        this.listaTipos = getAllUserTypesFromDB();
        ArrayList<String> listaNomesTipoU = new ArrayList<String>();

        for(TipoUsuario tipoU: this.listaTipos){
            listaNomesTipoU.add(tipoU.getNome());
        }

        CBoxTipoUsr.getItems().addAll(listaNomesTipoU);
	    CBoxTipoUsr.setOnAction(this::getSelectedTipoUsr);
        txtInvalido.setVisible(false);
        txtTipoInvalido.setVisible(false);
        txtUsuarioRepetido.setVisible(false);
        txtCadastrado.setVisible(false);
    }    
    
    
    public void getSelectedTipoUsr(ActionEvent event) {

        String nomeTipoSelecionado = CBoxTipoUsr.getValue();

        for(TipoUsuario tipo: this.listaTipos){
            if(nomeTipoSelecionado.equals(tipo.getNome())){
                this.tipoSelecionado = tipo.getId();
            }
        }
    }
    
    @FXML
    public void cadastrarUsuario(ActionEvent event) throws IOException {
        String nome  = txtNomeCompleto.getText();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if (this.tipoSelecionado == -1) {
            txtInvalido.setVisible(false);
            txtTipoInvalido.setVisible(true);
            txtUsuarioRepetido.setVisible(false);
            txtCadastrado.setVisible(false);
        }
        else if ("".equals(nome) || "".equals(login) || "".equals(senha)) {
            txtInvalido.setVisible(true);
            txtTipoInvalido.setVisible(false);
            txtUsuarioRepetido.setVisible(false);
            txtCadastrado.setVisible(false);
        }
        else {
            // saves to db
            Usuario usuario = new Usuario(nome, login, senha);
            String errorMsg = usuario.saveToDB(true, false, this.tipoSelecionado);

            if(errorMsg != null && errorMsg.equals("Cliente já existe")){
                txtUsuarioRepetido.setVisible(true);
            }
            else if(errorMsg != null){
                System.out.println("Erro: " + errorMsg);
            }
            else{
                txtCadastrado.setVisible(true);
                txtTipoInvalido.setVisible(false);
                txtUsuarioRepetido.setVisible(false);
                txtInvalido.setVisible(false);
            }
        }
    }
    
    @FXML
    private void fechar(ActionEvent event) throws IOException {
        Stage stage = (Stage) buttonVoltar.getScene().getWindow();
        stage.close();
    }
}