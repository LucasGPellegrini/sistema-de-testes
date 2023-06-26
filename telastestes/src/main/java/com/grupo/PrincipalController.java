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


public class PrincipalController implements Initializable{

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
    AnchorPane planPane;
       
    @FXML
    TreeView equipesList;
    @FXML
    TreeView planosList;
    
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
        
        // PLANOS
        //TODO: TERMOS ABAIXO NÃO DEVEM SER SETADOS ESTATICAMENTE (exceto root)
        TreeItem<String> rootPlano = new TreeItem<>("Projetos");
        // Equipes?
        TreeItem<String> branchProj1 = new TreeItem<>("Projeto 01");
        TreeItem<String> branchProj2 = new TreeItem<>("Projeto 02");
        TreeItem<String> branchP1 = new TreeItem<>("Plano: Operações Básicas");
        TreeItem<String> branchP2 = new TreeItem<>("Plano: Operações Seg. Grau");
        TreeItem<String> branchP3 = new TreeItem<>("Plano: Chamadas de Sistema");

        // Membros
        TreeItem<String> leafP1 = new TreeItem<>("Caso: fx:add");
        TreeItem<String> leafP2 = new TreeItem<>("Caso: fx:sub");
        TreeItem<String> leafP3 = new TreeItem<>("Caso: fx:mult");
        TreeItem<String> leafP4 = new TreeItem<>("Caso: fx:div");
        
        TreeItem<String> leafP5 = new TreeItem<>("Caso: fx:bhaskara");
        TreeItem<String> leafP6 = new TreeItem<>("Caso: fx:soma_e_produto");
        TreeItem<String> leafP7 = new TreeItem<>("Caso: fx:aprox_linear");
        
        TreeItem<String> leafP8 = new TreeItem<>("Caso: fx:get_proc_data");
        TreeItem<String> leafP9 = new TreeItem<>("Caso: fx:sys_shutdown");
        

        
        branchP1.getChildren().addAll(leafP1, leafP2,leafP3, leafP4);
        branchP2.getChildren().addAll(leafP5,leafP6, leafP7);
        branchP3.getChildren().addAll(leafP8,leafP9);
        branchProj1.getChildren().addAll(branchP1, branchP2);
        branchProj2.getChildren().addAll(branchP3);
        rootPlano.getChildren().addAll(branchProj1, branchProj2);
        planosList.setRoot(rootPlano);
        
    }


    public void selectItem() {
	TreeItem<String> item = (TreeItem<String>) equipesList.getSelectionModel().getSelectedItem();
	if(item != null) {
        	System.out.println(item.getValue());
	}
    }
    
    public void selectPlano() {
	TreeItem<String> item = (TreeItem<String>) planosList.getSelectionModel().getSelectedItem();
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
    	Parent root = FXMLLoader.load(getClass().getResource("telaLogin.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    private void switchToCriaCaso(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("telaCadCaso.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 741.0, 568.0);
        Stage stage = new Stage();
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
                criaPTBtn.setVisible(true);
                alocPTBtn.setVisible(true);
    	}
    }
    
    @FXML
    public void mostraDashb(ActionEvent event) throws IOException {
        dashbPane.setVisible(true);
        equipePane.setVisible(false);
        planPane.setVisible(false);
    }
    
    @FXML
    public void mostraEquipe(ActionEvent event) throws IOException {
        equipePane.setVisible(true);
        dashbPane.setVisible(false);
        planPane.setVisible(false);
    }
    
    @FXML
    public void mostraPlanos(ActionEvent event) throws IOException {
        planPane.setVisible(true);
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
    
    @FXML
    private void switchToCadUsr(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("telaCadUsr.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToCriaTipo(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("telaCriaTipo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void switchToCriaPlano(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("telaPlanoTestes.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}