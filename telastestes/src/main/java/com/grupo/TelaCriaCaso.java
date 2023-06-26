package com.grupo;

import com.grupo.model.testes.CasoDeTeste;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TelaCriaCaso implements Initializable{

    private String[] listaPrioridades = {"Baixa", "Media", "Alta"};
    
    @FXML
    TextField txtTitulo;
    
    @FXML
    TextArea txtDescricao;
    
    @FXML
    ComboBox<String> cBoxPrioridade;
    
    @FXML
    DatePicker dataLimite;
    
    @FXML
    DatePicker dataPrevista;
    
    @FXML
    TextField textUsuario;
    
    @FXML
    Button buttonCriarRequisito;
    
    @FXML
    TextArea txtResultadoEsperado;
    
    @FXML 
    Button buttonVoltar;
    
    @FXML
    Button buttonCriar;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cBoxPrioridade.getItems().addAll(listaPrioridades);
        //cBoxPrioridade.setOnAction(this::getSelectedTipoUsr);
        
    }
    @FXML
    public void cadastrarCaso(ActionEvent event) throws IOException{
        String titulo = txtTitulo.getText();
        
        CasoDeTeste caso = new CasoDeTeste();
        caso.setDescricao(txtDescricao.getText());
        caso.setPrioridade(cBoxPrioridade.getValue());
        caso.setResultadoEsperado(txtResultadoEsperado.getText());
        caso.setDataLimite(java.sql.Date.valueOf(dataLimite.getValue()));
        caso.setDataPrevista(java.sql.Date.valueOf(dataPrevista.getValue()));
        
        
    }
    
    @FXML
    private void fechar(ActionEvent event) throws IOException {
        Stage stage = (Stage) buttonVoltar.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
}
