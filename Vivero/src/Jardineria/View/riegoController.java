package Jardineria.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaProducto;
import Jardineria.TablaRiego;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class riegoController {
	Connection conn;
	
	Main main;
	
	  @FXML
	    private TextField fecha;

	    @FXML
	    private TextField tipoProducto;

	    @FXML
	    private Button registrar;

	    @FXML
	    private TextField IdRiegoE;

	    @FXML
	    private Button eliminar;

	    @FXML
	    private TextField IdProductoA;

	    @FXML
	    private TextField IdRiego;

	    @FXML
	    private TextField fechaA;

	    @FXML
	    private TextField tipoProductoA;

	    @FXML
	    private Button actualizar;

	    @FXML
	    private Button mostrarDatos;

	    @FXML
	    private Button RegresarR;

	    @FXML
	    private TableColumn<TablaRiego, String> Fecha;

	    @FXML
	    private TableColumn<TablaRiego, String> TipoProducto;
	    @FXML
	    private TableColumn<TablaRiego, Integer> idRiego;
	    @FXML
	    private TableView<TablaRiego> mostrar;
	   
	    ObservableList<TablaRiego> tabla = FXCollections.observableArrayList();
	    
	    
	    

	    
	    @FXML
	    void clickRegistrar(ActionEvent event) {
	    	if(fecha.getText().isEmpty()||tipoProducto.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Rellena los campos");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="insert into riegos (fecha, tipoProducto) values ('"+fecha.getText()+"','"+tipoProducto.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Riego Registrado");
					  fecha.setText("");
					  fecha.requestFocus();
					  tipoProducto.setText("");
					  tipoProducto.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo registrar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void ClickActualizar() {
	    	if(IdRiego.getText().isEmpty()||fechaA.getText().isEmpty()|| tipoProductoA.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Rellena los campos");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL =" update riegos set fecha = ('"+fechaA.getText()+"'),tipoProducto = ('"+tipoProductoA.getText()+"') where idRiego = ('"+IdRiego.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Riego Actualizado");
					  fechaA.setText("");
					  fechaA.requestFocus();
					  tipoProductoA.setText("");
					  tipoProductoA.requestFocus();
					  IdRiego.setText("");
					  IdRiego.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo Actualizar");
					e.printStackTrace();
				}
	    	}
	    }


	    @FXML
	    void clickEliminar() {
	    	if(IdRiegoE.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Ingresa el riego a eliminar");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="delete from riegos where idRiego= ('"+IdRiegoE.getText()+"')"; 
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert(" Eliminado correctamente");
					IdRiegoE.setText("");
					IdRiegoE.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo eliminar ");
					e.printStackTrace();
				}
	    	}
	    }
	    
	    @FXML
	    void clickMostrarDatos(ActionEvent event) {
	    	 tabla.clear();
	    	System.out.println("entra ver");
	    	try { 
	            String SQL = "Select *  from riegos";
	            String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
	     		conn =  DriverManager.getConnection(url,"ale","aleids");
	            Statement st = conn.createStatement(); 
	            ResultSet rs = st.executeQuery(SQL);
	            while (rs.next()) { 
	            	TablaRiego riego = new TablaRiego();
	            	riego.setIdRiego(rs.getInt("idRiego"));
	            	riego.setFecha(rs.getString("fecha"));
	            	riego.setTipoProducto(rs.getString("tipoProducto"));
	            	tabla.add(riego);
	            
	         }         
	           
	        } catch (Exception e) { 
	        System.out.println("catch: "+e);
	        } 
			 idRiego.setCellValueFactory(new PropertyValueFactory<>("idRiego"));
	    	 Fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
			 TipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoProducto"));
			
			
			 mostrar.setItems(tabla);
	    }
	    @FXML
	    void ClickRegresarR(ActionEvent event) {
	    	main.VentanaMenu();
	    }

    void alert(String alerta) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION,alerta);
		alert.getDialogPane().setMinHeight(100);
		alert.show();
	}
    public void setMain(Main main) {
		this.main = main;
		
	}
	

}
