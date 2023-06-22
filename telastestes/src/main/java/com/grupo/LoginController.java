package com.grupo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


public class LoginController {
	
	@FXML
	TextField usernametxtfield;
	
	@FXML
	RadioButton admbutton;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
    	String username = usernametxtfield.getText();
    	boolean isAdmin = admbutton.isSelected();
    	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("telaPrincipal.fxml"));	
	root = loader.load();	

	PrincipalController secondaryController = loader.getController();
	secondaryController.mostraNome(username, isAdmin);

	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();

    }
    
}
