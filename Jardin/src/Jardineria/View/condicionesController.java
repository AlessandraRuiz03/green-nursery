package Jardineria.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaCondicion;
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

public class condicionesController {
	
	Connection con = Conexion.getConexion();
	PreparedStatement ps;

    @FXML
    private TextField condicion;

    @FXML
    private Button registrar;

    @FXML
    private TextField idCondicion;
    
    @FXML
    private TextField idCondicionE;

    @FXML
    private Button eliminar;

    @FXML
    private TextField Condicion;

    @FXML
    private Button actualizar;

    @FXML
    private Button motrarDatos;

    @FXML
    private Button RegresarC;

    @FXML
    private TableView<TablaCondicion> TablaDatos;

    @FXML
    private TableColumn<TablaCondicion, Integer> IDCondicion;

    @FXML
    private TableColumn<TablaCondicion, String> CondicioN;
    
    ObservableList<TablaCondicion> tabla = FXCollections.observableArrayList();
    
    Main main;
    
    @FXML
    void Actualizar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("UPDATE condicion SET condicion=? WHERE idcondicion=?");
        	ps.setString(1, Condicion.getText());
        	ps.setString(2, idCondicion.getText());
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Actualizacion");
    			alert.setHeaderText("Registro Actualizado Exitosamente");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}else {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Actualizacion");
    			alert.setHeaderText("No se Puedo Actualizar el Registro");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}
    }

    @FXML
    void ClickRegresarC(ActionEvent event) {
    	main.VentanaMenu();
    }

    @FXML
    void Eliminar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("DELETE FROM condicion WHERE idcondicion=?");
        	ps.setString(1, idCondicionE.getText());
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Elimiando");
    			alert.setHeaderText("Registro Eliminado Exitosamente");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}else {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Eliminado");
    			alert.setHeaderText("No se Puedo Eliminar el Registro");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}
    }
    @FXML
    void MostrarDatos(ActionEvent event) {
    	tabla.clear();
    	try {
        	ResultSet rs = con.createStatement().executeQuery("SELECT * FROM condicion");
        	while(rs.next()){
        		TablaCondicion con = new TablaCondicion();
        		con.setIDCondicion(rs.getInt("IDCondicion"));
        		con.setCondicion(rs.getString("Condicion"));
        		tabla.add(con);
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}
    		IDCondicion.setCellValueFactory(new PropertyValueFactory<>("IDCondicion"));
    		CondicioN.setCellValueFactory(new PropertyValueFactory<>("Condicion"));
        	TablaDatos.setItems(tabla);
    }


    @FXML
    void Registro(ActionEvent event) {
    	
    	try {
    	ps = con.prepareStatement("INSERT INTO condicion (condicion) VALUES(?)");
    	ps.setString(1, condicion.getText());
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
			this.main = main;;
			
		}
}
