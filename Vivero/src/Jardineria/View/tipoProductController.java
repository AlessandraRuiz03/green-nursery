package Jardineria.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaHistorialFoto;
import Jardineria.TablaTP;
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


public class tipoProductController {
		Main main;
		Connection conn;
		
	
	 @FXML
	    private Button RegresarTP;
	  @FXML
	    private TextField TPR;

	    @FXML
	    private TextField IDProductoE;

	    @FXML
	    private TextField TPA;

	    @FXML
	    private TextField IDA;

	    @FXML
	    private Button registrar;

	    @FXML
	    private Button eliminar;

	    @FXML
	    private Button actualizar;

	    @FXML
	    private Button ver;
	    @FXML
	    private TableView<TablaTP> mostrar;

	    @FXML
	    private TableColumn<TablaTP, Integer> id_tipoProducto;

	    @FXML
	    private TableColumn<TablaTP, String> tipo;
	    ObservableList<TablaTP> tabla = FXCollections.observableArrayList();
	   
	    
	    @FXML
	    void clickRegistrar() {
	    	if(TPR.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Ingresa el tipo de producto");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="insert into TipoProducto (tipo) values ('"+TPR.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Nuevo Tipo de Producto Registrado");
					  TPR.setText("");
					  TPR.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo registrar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void clicActualizar(ActionEvent event) {
	    	 if(TPA.getText().isEmpty()|| IDA.getText().isEmpty()) {
		    		Alert alert = new Alert(AlertType.WARNING);
		    		alert.setTitle("Advertencia");
		    		alert.setHeaderText("Ingresa datos a actualizar");
		    		alert.setContentText("Vuelve a Intentar");
		    		alert.showAndWait();
		    	}else {
		    		try {
						String SQL ="update TipoProducto set tipo = ('"+TPA.getText()+"') where id_tipoProducto= ('"+IDA.getText()+"')";
		    			conn = Conexion.getConexion();
						Statement st = conn.createStatement();
						System.out.println("Conectado");
						st.execute(SQL);
						alert("Actualizado");
						IDA.setText("");
						IDA.requestFocus();
						TPA.setText("");
						TPA.requestFocus();
			 	} catch (SQLException e) {
						alert("No se pudo actualizar ");
						e.printStackTrace();
					}
		    	}
	    }

	    @FXML
	    void clickEliminar(ActionEvent event) {
	    	 if(IDProductoE.getText().isEmpty()) {
		    		Alert alert = new Alert(AlertType.WARNING);
		    		alert.setTitle("Advertencia");
		    		alert.setHeaderText("Ingresa tipo de Producto para eliminar");
		    		alert.setContentText("Vuelve a Intentar");
		    		alert.showAndWait();
		    	}else {
		    		try {
						String SQL ="delete from TipoProducto where id_tipoProducto= ('"+IDProductoE.getText()+"')"; 
		    			conn = Conexion.getConexion();
						Statement st = conn.createStatement();
						System.out.println("Conectado");
						st.execute(SQL);
						alert("Tipo de Producto Eliminado correctamente");
						IDProductoE.setText("");
						IDProductoE.requestFocus();
			 	} catch (SQLException e) {
						alert("No se pudo eliminar ");
						e.printStackTrace();
					}
		    	}
	    }

	  

	    @FXML
	    void ClickRegresarTP(ActionEvent event) {
	    	main.VentanaMenu();
	    }
	    @FXML
	    void ClickVer() {
	    	try {
	    		  String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
	    		  Connection conn =  DriverManager.getConnection(url,"ale","aleids");  
	    		  Statement st = conn.createStatement();
	        
	    		  String sql = "select * from TipoProducto" ;
		          System.out.println("SQL " + sql);
	    		  ResultSet rs = st.executeQuery(sql);
	    		  	while (rs.next()) {
	    		  		TablaTP  tipoP = new TablaTP();
	    		  		tipoP.setId_tipoProducto(rs.getInt("id_tipoProducto"));
	    		  		tipoP.setTipo(rs.getString("tipo"));
	    		  		 tabla.add(tipoP);
		    	  	}    
	    	  }
	    	  catch (Exception e) { 
				System.out.println("catch:"+e);
				
         }
	    	  id_tipoProducto.setCellValueFactory(new PropertyValueFactory<>("id_tipoProducto"));
	    	  tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
	        
	          mostrar.setItems(tabla);
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
