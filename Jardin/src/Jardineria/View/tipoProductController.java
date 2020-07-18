package Jardineria.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaTipoProducto;
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
	
	Connection con = Conexion.getConexion();
	PreparedStatement ps;
	
	ResultSet rs;

    @FXML
    private TextField tipoProducto;

    @FXML
    private TextField idProductoE;

    @FXML
    private TableView<TablaTipoProducto> TablaDatos;

    @FXML
    private TableColumn<TablaTipoProducto, Integer> IDProducto;

    @FXML
    private TableColumn<TablaTipoProducto, String> TipoProducto;

    @FXML
    private TextField tipoProductoAct;

    @FXML
    private TextField idTipoPAct;

    @FXML
    private Button registrar;

    @FXML
    private Button eliminar;

    @FXML
    private Button actualizar;

    @FXML
    private Button mostrarDatos;

    @FXML
    private Button RegresarTP;
    
    ObservableList<TablaTipoProducto> tabla = FXCollections.observableArrayList();

	Main main;

    @FXML
    void ClickActualizar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("UPDATE tipoproducto SET tipoproducto=? WHERE idtipoproducto= ?");
        	ps.setString(1, tipoProductoAct.getText());
        	ps.setString(2, idTipoPAct.getText());
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
    void ClickEliminar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("DELETE FROM tipoproducto WHERE idtipoproducto=?");
        	ps.setString(1,  idProductoE.getText());
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Eliminar");
    			alert.setHeaderText("Registro Eliminado Exitosamente");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}else {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Eliminar");
    			alert.setHeaderText("No se Puedo Eliminar el Registro");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}

    }

    @FXML
    void ClickMostrarDatos(ActionEvent event) {
    	tabla.clear();
    	try {
    	ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tipoproducto");
    	while(rs.next()) {
    		TablaTipoProducto tp = new TablaTipoProducto();
    		tp.setIDTipoProducto(rs.getInt("IDTipoProducto"));
    		tp.setTipoProducto(rs.getString("TipoProducto"));
    		tabla.add(tp);
    	} 
    	}catch(SQLException e) {
    		System.out.print(e);
    	}
    	IDProducto.setCellValueFactory(new PropertyValueFactory<>("IDTipoProducto"));
    	TipoProducto.setCellValueFactory(new PropertyValueFactory<>("TipoProducto"));
    	TablaDatos.setItems(tabla);

    }

    @FXML
    void ClickRegresarTP(ActionEvent event) {
    	main.VentanaMenu();
    }

    @FXML
    void Registro(ActionEvent event) {
    	try {
    	ps = con.prepareStatement("INSERT INTO tipoproducto (tipoproducto) VALUES(?)");
    	ps.setString(1, tipoProducto.getText());
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
