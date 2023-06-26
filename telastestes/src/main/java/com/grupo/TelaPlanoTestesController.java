package com.grupo;

import com.grupo.model.testes.Estado;
import com.grupo.model.testes.PlanoDeTeste;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaPlanoTestesController implements Initializable {

    @FXML
    TextArea descricaotxt;
    
    @FXML
    ComboBox<String> casosBox;
    private String[] listaCasos = {"Caso: fx:add", "Caso: fx:sub", "Caso: fx:div", "Caso: fx:mult"};
    
    @FXML
    Button addCasoBtn;
    @FXML
    Button criarPlanobtn;
    @FXML
    Button butttonVoltar;
    
    @FXML
    Text casoAddedtxt;
    
    private ArrayList<String> casosadded = new ArrayList<>();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        casoAddedtxt.setVisible(false);
        casosBox.getItems().addAll(listaCasos);
	casosBox.setOnAction(this::getSelectedCaso);
    }
    
    public void getSelectedCaso(ActionEvent event) {
	String caso = casosBox.getValue();
        //TODO: BUSCA O CASO PELO NOME E RETORNA O OBJETO DO CASO
    }
    
    @FXML
    private void fechar(ActionEvent event) throws IOException {
        Stage stage = (Stage) butttonVoltar.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    @FXML
    private void adicionarCaso(ActionEvent event) throws IOException {
        String caso = casosBox.getValue();
        casosadded.add(caso);
        casoAddedtxt.setVisible(true);
    }
    
    @FXML
    private void criarPlano(ActionEvent event) throws IOException {
        String descricao = descricaotxt.getText();
        PlanoDeTeste plano = new PlanoDeTeste();
        plano.setDescricao(descricao);
        plano.setEstado(Estado.ESPERA);
        //----------------------------------------
        System.out.println("Plano de Testes Criado:\n"+descricao);
        System.out.println("  Casos: ");
        for(String caso : casosadded) {
            System.out.println("  -> "+caso);
        }
    }
    
}
