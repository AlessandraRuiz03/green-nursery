package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Conexion {
	static Connection contacto = null;
	public static boolean status= false;
	public static Connection getConexion() throws SQLException {
		status = false;
		 
   		  String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
   		  contacto =  DriverManager.getConnection(url,"ale","aleids");  
   		  try {
   			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   		  }catch(ClassNotFoundException e) {
   			  Alert alert = new Alert(AlertType.ERROR);
   			  alert.setTitle("Error");
   			  alert.setHeaderText("No se pudo conectar");
   			  alert.setContentText(null);
   			  alert.showAndWait();
   		  }
		return contacto;
	}
	
	public static ResultSet Consulta(String sql) {
		try {
			Connection conn = getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		}catch(SQLException e){
			
		}
		return null;
		
	}

	

}
