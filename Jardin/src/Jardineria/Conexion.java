  package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Conexion {
	
	public static Connection getConexion(){
		Connection con = null;
		try {
		String url= "jdbc:mariadb://127.0.0.1:3306/jardineria";
		Class.forName("org.mariadb.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de Conexion");
			alert.setHeaderText("No se puedo establecer Conexion");
			alert.setContentText("Intenta otra Vez");
			alert.showAndWait();
			System.out.print(e);
		}
		return con;
	}
}
