package Jardineria.View;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class BDController {
	private Main main;

    @FXML
    private Button mysql;

    @FXML
    private Button sqls;

    @FXML
    void ClickMysql(ActionEvent event) {
    	//main.VentanaMenu();
    }
   

    @FXML
    void ClickSqls(ActionEvent event) {
    	try {
    	Connection conn;
    	conn = Conexion.getConexion();
    	Statement st = conn.createStatement();
		System.out.println("Conectado");
    	main.VentanaMenu();
    	}
    	catch(SQLException e) {
			alert("No se pudo conectar");
			e.printStackTrace();
		}
    		
   	}
  

	public void setMain(Main main) {
		this.main = main;
		
	}
	void alert(String alerta) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION,alerta);
		alert.getDialogPane().setMinHeight(100);
		alert.show();
	}
    
    
}
