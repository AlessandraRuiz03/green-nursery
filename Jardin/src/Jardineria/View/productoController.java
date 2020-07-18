package Jardineria.View;

import java.sql.*;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaProducto;
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

public class productoController {
	
	Connection con = Conexion.getConexion();
	PreparedStatement ps;
	Main main;

    @FXML
    private TextField tipoProducto;

    @FXML
    private TextField nombre;

    @FXML
    private TextField fechaIngreso;
    
    @FXML
    private TextField condicion;

    @FXML
    private TextField IdEliminar;

    @FXML
    private TableView<TablaProducto> MostrarDatos;

    @FXML
    private TableColumn<TablaProducto, Integer> IDTipoProducto;

    @FXML
    private TableColumn<TablaProducto, String> TipoProducto;

    @FXML
    private TableColumn<TablaProducto, Integer> IDProducto;

    @FXML
    private TableColumn<TablaProducto, String> Nombre;

    @FXML
    private TableColumn<TablaProducto, String> FechaIngreso;

    @FXML
    private TableColumn<TablaProducto, Integer> IDCondicion;

    @FXML
    private TableColumn<TablaProducto, String> Condicion;

    @FXML
    private TextField tipoPactualizar;

    @FXML
    private TextField IdPactualizar;

    @FXML
    private TextField nombreAct;

    @FXML
    private TextField FIactualizar;

    @FXML
    private TextField condicionAct;

    @FXML
    private Button MostrarTabla;

    @FXML
    private Button RegresarTP;

    @FXML
    private Button Registrar;

    @FXML
    private Button eliminar;

    @FXML
    private Button Actualizar;
    ObservableList<TablaProducto> tabla = FXCollections.observableArrayList();
    
    @FXML
    void Actualizar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("UPDATE producto SET tipoproducto=?,nombre=?,fechaingreso=?,condicion=? WHERE idproducto= ?");
        	ps.setString(1, tipoPactualizar.getText());
        	ps.setString(2, nombreAct.getText());
        	ps.setString(3, FIactualizar.getText());
        	ps.setString(4, condicionAct.getText());
        	ps.setString(5, IdPactualizar.getText());
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
    void ClickRegresarTP(ActionEvent event) {
    	main.VentanaMenu();
    }

    @FXML
    void Eliminar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("DELETE FROM producto WHERE idproducto=?");
        	ps.setString(1, IdEliminar.getText());
        	
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Eliminado");
    			alert.setHeaderText("Registro Eliminado Exitosamente");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}else {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Actualizacion");
    			alert.setHeaderText("No se Puedo Eliminar el Registro");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}

    }

    @FXML
    void Registro(ActionEvent event) {
    	
    	try {
    	
    	ps = con.prepareStatement("INSERT INTO producto (tipoproducto,nombre,fechaingreso,condicion) VALUES(?,?,?,?)");
    	ps.setString(1, tipoProducto.getText());
    	ps.setString(2, nombre.getText());
    	ps.setString(3, fechaIngreso.getText());
    	ps.setString(4, condicion.getText());
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

    @FXML
    void MostrarDatos(ActionEvent event) {
    	tabla.clear();
    	try {
        	ResultSet rs = con.createStatement().executeQuery("SELECT * FROM producto p INNER JOIN tipoproducto t\r\n" + 
        			"ON p.TipoProducto = t.TipoProducto");
        	while(rs.next()) {
        		TablaProducto proc = new TablaProducto();
        		proc.setIDProducto(rs.getInt("IDProducto"));
        		proc.setTipoProducto(rs.getString("TipoProducto"));
        		proc.setNombre(rs.getString("Nombre"));
        		proc.setFechaIngreso(rs.getString("FechaIngreso"));
        		proc.setCondicion(rs.getString("Condicion"));
        		tabla.add(proc);
        	
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}
    		TipoProducto.setCellValueFactory(new PropertyValueFactory<>("TipoProducto"));
    		IDProducto.setCellValueFactory(new PropertyValueFactory<>("IDProducto"));
    		Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
    		FechaIngreso.setCellValueFactory(new PropertyValueFactory<>("FechaIngreso"));
    		Condicion.setCellValueFactory(new PropertyValueFactory<>("Condicion"));
    		MostrarDatos.setItems(tabla);
    }
    public void setMain(Main main) {
		this.main = main;
		
	}
}
