package Jardineria.View;

import Jardineria.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {
	
	private Main main;
	
	  @FXML
	    private Button inicio;

	    @FXML
	    private Button registro;
	    @FXML
	    private TextField correo;
	    @FXML
	    private PasswordField password;

	
	
	    @FXML
	    void ClickInicio(ActionEvent event) {
	    	main.VentanaBD();
	    	
	    }
	 
	    @FXML
	    void ClickRegistro() {
	    	main.VentanaRegistro();
	    }

	 
	 
	 public void setMain(Main main) {
			this.main = main;
		}

}
