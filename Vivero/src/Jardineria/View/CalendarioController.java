package Jardineria.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaCR;
import Jardineria.TablaCondiciones;
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

public class CalendarioController {
	Main main;
	Connection conn;
	
	 @FXML
	    private TextField diaR;

	    @FXML
	    private Button agregar;

	    @FXML
	    private TextField TPR;

	    @FXML
	    private Button RegresarCa;

	    @FXML
	    private Button eliminar;

	    @FXML
	    private TextField IDE;

	    @FXML
	    private TextField diaAct;

	    @FXML
	    private TextField TPA;

	    @FXML
	    private TextField IDCA;

	    @FXML
	    private Button actualizar;

	    @FXML
	    private Button ver;
	    @FXML
	    private TableColumn<TablaCR, Integer> idCalendario;

	    @FXML
	    private TableColumn<TablaCR, String> dia;

	    @FXML
	    private TableColumn<TablaCR, String> tipoP;
	    @FXML
	    private TableView<TablaCR> mostrar;
	    
	    ObservableList<TablaCR> tabla = FXCollections.observableArrayList();

	    @FXML
	    void ClickAgregar() {
	    	if(diaR.getText().isEmpty()||TPR.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Ingresa los datos");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="insert into calendarioRiego (dia, tipo_Producto) values ('"+diaR.getText()+"','"+TPR.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Datos Registrados");
					  TPR.setText("");
					  TPR.requestFocus();
					  diaR.setText("");
					  diaR.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo registrar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void ClickRegresar(ActionEvent event) {
	    	main.VentanaMenu();
	    }

	    @FXML
	    void clickActualizar(ActionEvent event) {
	    	if(IDCA.getText().isEmpty()||diaAct.getText().isEmpty()||TPA.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Rellena los campos");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="update calendarioRiego set dia = ('"+diaAct.getText()+"'),tipo_Producto = ('"+TPA.getText()+"') where idCalendarioRiego = ('"+IDCA.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Actualizado");
					  IDCA.setText("");
					  IDCA.requestFocus();
					  diaAct.setText("");
					  diaAct.requestFocus();
					  TPA.setText("");
					  TPA.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo actualizar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void clickEliminar(ActionEvent event) {
	    	if(IDE.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Ingresa ID calendario a borrar");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="delete from calendarioRiego where idCalendarioRiego = ('"+IDE.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Eliminado correctamente");
					  TPR.setText("");
					  TPR.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo eliminar");
					e.printStackTrace();
				}
	    	}
	    }

	    @FXML
	    void clickVer(ActionEvent event) {
	    	System.out.println("entra ver");
	    	tabla.clear();
	    	try { 
	            String SQL = "select *from calendarioRiego";
	            String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
	     		conn =  DriverManager.getConnection(url,"ale","aleids");
	            Statement st = conn.createStatement(); 
	            ResultSet rs = st.executeQuery(SQL);
	            while (rs.next()) { 
	            	TablaCR CR = new TablaCR();
	            	CR.setIdCalendarioRiego(rs.getInt("idCalendarioRiego"));
	            	CR.setDia(rs.getString("dia"));
	            	CR.setTipo_Producto(rs.getString("tipo_Producto"));
	            	tabla.add(CR);
	           // tabla.add(new TablaCR(rs.getInt(" idCalendarioRiego"),rs.getString("dia"),rs.getString("tipo_Producto")));
	            	System.out.println("aqui");
	         }         
	           
	        } catch (Exception e) { 
	        System.out.println("catch: "+e);
	    	System.out.println("aqui no");
	        } 
			
	    	idCalendario.setCellValueFactory(new PropertyValueFactory<>("idCalendarioRiego"));
	    	dia.setCellValueFactory(new PropertyValueFactory<>("dia"));
	    	tipoP.setCellValueFactory(new PropertyValueFactory<>("tipo_Producto"));
	    	System.out.println("y aqui");
			 mostrar.setItems(tabla);
				System.out.println(":3");
	    	
	    	
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
