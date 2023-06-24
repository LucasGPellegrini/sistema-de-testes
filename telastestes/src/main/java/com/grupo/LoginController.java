package com.grupo;

import com.grupo.model.usuarios.Cliente;
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
	TextField logintxtfield;

	@FXML
	TextField senhatxtfield;
	
	@FXML
	RadioButton admbutton;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
    	String login = logintxtfield.getText();
			String senha = senhatxtfield.getText();
    	boolean isAdmin = admbutton.isSelected();

			Cliente cliente = Cliente.doLoginAuth(login, senha, (isAdmin ? "administrador" : "usuario"));

			if(cliente == null){
				System.out.println("Login invalido!");
			}
			else{
				System.out.println((isAdmin ? "administrador" : "usuario") + " " + cliente.getNomeCompleto() + " autenticado!");

				FXMLLoader loader = new FXMLLoader(getClass().getResource("telaPrincipal.fxml"));	
				root = loader.load();	

				PrincipalController secondaryController = loader.getController();
				secondaryController.mostraNome(cliente.getNomeCompleto(), isAdmin);

				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
    }

    public static class CriaTipoController {
    }
}
