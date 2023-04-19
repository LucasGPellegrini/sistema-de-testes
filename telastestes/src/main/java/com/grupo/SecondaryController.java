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
import javafx.util.Duration;


public class SecondaryController {

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
	
	//slidePane.setTranslateX(-160);
	//barBtn.setVisible(true);
	
	private Stage stage;
	private Scene scene;
	private Parent root;
        

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