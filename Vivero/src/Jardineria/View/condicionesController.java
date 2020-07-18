package Jardineria.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaCondiciones;
import Jardineria.TablaProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;


public class condicionesController {
	Connection conn;
	
	Main main;
	  @FXML
	    private TextField condicionR;

	    @FXML
	    private Button eliminar;

	    @FXML
	    private TextField IDCA;

	    @FXML
	    private Button actualizar;

	    @FXML
	    private Button ver;

	    @FXML
	    private Button RegresarC;

	    @FXML
	    private TextField CondicionA;

	    @FXML
	    private Button agregar;

	    @FXML
	    private TextField IDCEliminar;
	    @FXML
	    private TableView<TablaCondiciones> mostrar;

	    @FXML
	    private TableColumn<TablaCondiciones, Integer> idCondicion;

	    @FXML
	    private TableColumn<TablaCondiciones, String> condicion;
	    ObservableList<TablaCondiciones> tabla = FXCollections.observableArrayList();
	    
	    @FXML
	    void clickAgregar(ActionEvent event) {
	    	if(condicionR.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Rellena el campo");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="insert into condicionProducto (condicion) values ('"+condicionR.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Condicion Registrada");
					condicionR.setText("");
					condicionR.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo registrar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void ClickActualizar(ActionEvent event) {
	    	if(IDCA.getText().isEmpty()||CondicionA.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Rellena los campos");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="update condicionProducto set condicion = ('"+CondicionA.getText()+"') where idCondicion= ('"+IDCA.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Condicion Actualizada");
					CondicionA.setText("");
					CondicionA.requestFocus();
					IDCA.setText("");
					IDCA.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo actualizar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void ClickEliminar(ActionEvent event) {
	    	if(IDCEliminar.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Rellena el campo");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="delete from condicionProducto where idCondicion = ('"+IDCEliminar.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Condicion Eliminada");
					IDCEliminar.setText("");
					IDCEliminar.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo eliminar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void ClickRegresarC(ActionEvent event) {
	    	main.VentanaMenu();
	    }

	    

	    @FXML
	    void clickVer(ActionEvent event) {
	    tabla.clear();
	    	System.out.println("entra ver");
	    	try { 
	            String SQL = "Select *  from condicionProducto";
	            String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
	     		conn =  DriverManager.getConnection(url,"ale","aleids");
	            Statement st = conn.createStatement(); 
	            ResultSet rs = st.executeQuery(SQL);
	            while (rs.next()) { 
	            	TablaCondiciones condiciones = new TablaCondiciones();
	            	condiciones.setIdCondicion(rs.getInt("idCondicion"));
	            	condiciones.setCondicion(rs.getString("condicion"));
	            tabla.add(condiciones);
	            
	         }         
	           
	        } catch (Exception e) { 
	        System.out.println("catch: "+e);
	        } 
			
	    	idCondicion.setCellValueFactory(new PropertyValueFactory<>("idCondicion"));
	    	condicion.setCellValueFactory(new PropertyValueFactory<>("condicion"));
			 mostrar.setItems(tabla);
			    
	    }
	
	    
	    void alert(String alerta) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION,alerta);
			alert.getDialogPane().setMinHeight(100);
			alert.show();
		}
		
	   

		public void setMain(Main main) {
			this.main = main;;
			
		}
}
