package Jardineria.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Jardineria.Conexion;
import Jardineria.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class registroController {
	 Main main;
	int count;
	Connection con = Conexion.getConexion();
	PreparedStatement ps;
    @FXML
    private TextField correo;

    @FXML
    private Button Registrate;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    void ClickRegistrate(){
    	try {
        	ps = con.prepareStatement("INSERT INTO usuario (correo,contrasena) VALUES(?,?)");
        	ps.setString(1, correo.getText());
        	ps.setString(2, password.getText());
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Registro");
    			alert.setHeaderText("Registro Guardado Exitosamente");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}else {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Registro");
    			alert.setHeaderText("No se Puedo Guardar el Registro");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}
        	
    }
    	public void setMain(Main main) {
    		this.main = main;
    	}
}

