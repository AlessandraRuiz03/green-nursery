package Jardineria.View;

import java.sql.ResultSet;
import java.sql.SQLException;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.Procedimientos;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class registroController {
	Main main;
	int count;
    @FXML
    private TextField correo;

    @FXML
    private Button Registrate;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    void ClickRegistrate() {
    	if(correo.getText().isEmpty() || password.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Advertencia");
    		alert.setHeaderText("Agregue correctamente la Informacion");
    		alert.setContentText("Vuelve a Intentar");
    		alert.showAndWait();
    		
    		correo.setText("");
    		password.setText("");
    		
    		correo.requestFocus();
    		password.requestFocus();
    	
    	}
    	else {
    		try {
    			ResultSet res = Conexion.Consulta("Select count(correo) from registro where correo='"+correo.getText()+"'");
    			try {
    				while(res.next()) {
    					count = res.getInt(1);
    					
    				}
    			} catch (SQLException e) {
    		}
    			if(count>=1) {
    				Alert alert = new Alert(AlertType.WARNING);
    				alert.setTitle("Advertencia");
    				alert.setHeaderText("Este Elemento Ya Existe");
    				alert.setContentText("Vuelve a Intentar");
    				alert.showAndWait();
    			} else {
    				Procedimientos.AgregarDatosRegistro(correo.getText(), password.getText());
    				correo.setText("");
    	    		password.setText("");
    	    		correo.requestFocus();
    	    		password.requestFocus();
    	    		Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setTitle("Datos");
    				alert.setHeaderText("Los Datos han sido registrados");
    				alert.setContentText(null);
    				alert.showAndWait();
    	    		
    			}
    		} catch(SQLException e) {
    			
    		}
    	}
    	
    }
    	public void setMain(Main main) {
    		this.main = main;
    	}
}
