package com.grupo;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TreeItem;
import javafx.util.Duration;


public class SecondaryController implements Initializable{

    @FXML
    Label olaTxt;
	
    @FXML
    Button barBtn;
    @FXML
    Button criaUsrBtn;
    @FXML
    Button cadUsrBtn;
    @FXML
    Button cadEqpBtn;
    @FXML
    Button gerEqpBtn;
    @FXML
    Button atribTesteBtn;
    @FXML
    Button criaCTBtn;
    @FXML
    Button gerCTBtn;
    @FXML
    Button gerExTesteBtn;
    @FXML
    Button criaPTBtn;
    @FXML
    Button alocPTBtn;
    @FXML
    Button hideBarBtn;
	
    @FXML
    AnchorPane slidePane;
    @FXML
    AnchorPane dashbPane;
    @FXML
    AnchorPane equipePane;
    @FXML
    AnchorPane msgPane;
       
    @FXML
    TreeView equipesList;
    
    @FXML
    private ProgressIndicator testProgress;
    //TODO: testesConcluídos / testesEmAndamento;
    //TODO: OU Colocar um listener no testRatio
    //      OU Incrementar toda vez que concluir um teste!
    private double testRatio;
    
    @FXML
    ComboBox<String> pegaTesteBox;
    private String[] listaTestes = {"Teste1", "Teste2"};
	
    private Stage stage;
    private Scene scene;
    private Parent root;
        
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        pegaTesteBox.getItems().addAll(listaTestes);
	pegaTesteBox.setOnAction(this::getSelectedTest);
        
        testRatio = 0.5;
        testProgress.setStyle("-fx-accent: #00FF00;");
        testProgress.setProgress(testRatio);
        
        //TODO: TERMOS ABAIXO NÃO DEVEM SER SETADOS ESTATICAMENTE (exceto root)
        TreeItem<String> rootItem = new TreeItem<>("Equipes");
        // Equipes?
        TreeItem<String> branchItem1 = new TreeItem<>("Equipe 01");
        TreeItem<String> branchItem2 = new TreeItem<>("Equipe 02");
        TreeItem<String> branchItem3 = new TreeItem<>("Equipe 03");
        // Membros
        TreeItem<String> leafItem1 = new TreeItem<>("Lucas Guerreiro");
        TreeItem<String> leafItem2 = new TreeItem<>("Pedro Leale");
        TreeItem<String> leafItem3 = new TreeItem<>("Amauri PietroPaulo");
        TreeItem<String> leafItem4 = new TreeItem<>("Rafael Azambuja");
        TreeItem<String> leafItem5 = new TreeItem<>("Pedro Henrique");
        TreeItem<String> leafItem6 = new TreeItem<>("Vinicius Calixto");
        TreeItem<String> leafItem7 = new TreeItem<>("Gabriel Moraes");
        TreeItem<String> leafItem8 = new TreeItem<>("Marcelo Maia");
        TreeItem<String> leafItem9 = new TreeItem<>("Valtinho Valter");
        
        branchItem1.getChildren().addAll(leafItem1, leafItem2,leafItem3);
        branchItem2.getChildren().addAll(leafItem4,leafItem5, leafItem6);
	branchItem3.getChildren().addAll(leafItem7, leafItem8, leafItem9);
        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);
        equipesList.setRoot(rootItem);
        
    }


    public void selectItem() {
	TreeItem<String> item = (TreeItem<String>) equipesList.getSelectionModel().getSelectedItem();
	if(item != null) {
        	System.out.println(item.getValue());
	}
    }


    public void getSelectedTest(ActionEvent event) {
	String teste = pegaTesteBox.getValue();
	System.out.println(teste);
        //TODO: BUSCA O TESTE PELO NOME E RETORNA O OBJETO TESTE
        //Retorna pra quando gerar relatório.
    }

    
    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        //App.setRoot("primary");
    	Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void mostraNome(String username, boolean adm) {
    	if(adm) {
    		olaTxt.setText("Administrador\n" + username);
                criaUsrBtn.setVisible(true);
                cadUsrBtn.setVisible(true);
                cadEqpBtn.setVisible(true);
                gerEqpBtn.setVisible(true);
                atribTesteBtn.setVisible(true);
    	}
    	else {
    		olaTxt.setText(username);
                criaCTBtn.setVisible(true);
                gerCTBtn.setVisible(true);
                gerExTesteBtn.setVisible(true);
                criaPTBtn.setVisible(true);
                alocPTBtn.setVisible(true);
    	}
    }
    
    @FXML
    public void mostraDashb(ActionEvent event) throws IOException {
        dashbPane.setVisible(true);
        equipePane.setVisible(false);
        msgPane.setVisible(false);
    }
    
    @FXML
    public void mostraEquipe(ActionEvent event) throws IOException {
        equipePane.setVisible(true);
        dashbPane.setVisible(false);
        msgPane.setVisible(false);
    }
    
    @FXML
    public void mostraMsg(ActionEvent event) throws IOException {
        msgPane.setVisible(true);
        dashbPane.setVisible(false);
        equipePane.setVisible(false);
    }
    

    @FXML
    private void correMenu(ActionEvent event) throws IOException {
    	TranslateTransition slide = new TranslateTransition();
    	slide.setDuration(Duration.seconds(0.4));
    	slide.setNode(slidePane);
    	
    	slide.setToX(0);
    	slide.play();
    	slidePane.setTranslateX(-160);
    	
    	slide.setOnFinished((ActionEvent e) -> {
    		hideBarBtn.setVisible(true);
    		barBtn.setVisible(false);
    	});
    }
    
    @FXML
    private void someMenu(ActionEvent event) throws IOException {
    	TranslateTransition slide = new TranslateTransition();
    	slide.setDuration(Duration.seconds(0.4));
    	slide.setNode(slidePane);
    	
    	slide.setToX(-160);
    	slide.play();
    	slidePane.setTranslateX(0);
    	
    	slide.setOnFinished((ActionEvent e) -> {
    		hideBarBtn.setVisible(false);
    		barBtn.setVisible(true);
    	});
    }
    

}