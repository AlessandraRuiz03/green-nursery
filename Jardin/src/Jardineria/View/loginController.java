package Jardineria.View;

import Jardineria.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class loginController {
	
	private Main main;
	
	  @FXML
	    private Button inicio;

	    @FXML
	    private Button registro;

	
	
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
