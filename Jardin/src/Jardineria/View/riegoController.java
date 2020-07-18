package Jardineria.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Jardineria.Conexion;
import Jardineria.Main;
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
	
	Connection con = Conexion.getConexion();
	PreparedStatement ps;

    @FXML
    private TextField fechaRiego;

    @FXML
    private Button registrar;

    @FXML
    private TextField idRiegoE;

    @FXML
    private Button eliminar;

    @FXML
    private TextField idRiegoA;

    @FXML
    private TextField fechaRiegoA;

    @FXML
    private TextField tipoProductoA;

    @FXML
    private Button actualizar;

    @FXML
    private Button mostrarDatos;

    @FXML
    private Button RegresarR;

    @FXML
    private TableView<TablaRiego> MostrarTabla;

    @FXML
    private TableColumn<TablaRiego, Integer> IDRiego;

    @FXML
    private TableColumn<TablaRiego, String> FechaRiego;

    @FXML
    private TableColumn<TablaRiego, String> TipoProducto;
    
    @FXML
    private TextField tipoProducto;
    
    ObservableList<TablaRiego> tabla = FXCollections.observableArrayList();
    Main main;

    @FXML
    void Actualizar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("UPDATE riego SET fechariego=?,tipoproducto=? WHERE idriego= ?");
        	ps.setString(1, fechaRiegoA.getText());
        	ps.setString(2, tipoProductoA.getText());
        	ps.setString(3, idRiegoA.getText());
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
    void ClickRegresarR(ActionEvent event) {
    	main.VentanaMenu();
    }

    @FXML
    void Eliminar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("DELETE FROM riego WHERE idriego= ?");
        	ps.setString(1, idRiegoE.getText());
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
    			alert.setHeaderText("No se Puedo Eliminado el Registro");
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
        	ResultSet rs = con.createStatement().executeQuery("SELECT * FROM riego");
        	while(rs.next()) {
        		TablaRiego riego = new TablaRiego();
        		riego.setIDRiego(rs.getInt("IDRiego"));
        		riego.setFechaRiego(rs.getString("FechaRiego"));
        		riego.setTipoProducto(rs.getString("TipoProducto"));
        		tabla.add(riego);
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}
        	IDRiego.setCellValueFactory(new PropertyValueFactory<>("IDRiego"));
        	FechaRiego.setCellValueFactory(new PropertyValueFactory<>("FechaRiego"));
        	TipoProducto.setCellValueFactory(new PropertyValueFactory<>("TipoProducto"));
        	MostrarTabla.setItems(tabla);

    }

    @FXML
    void Registro(ActionEvent event) {
    	
    	try {
    	ps = con.prepareStatement("INSERT INTO riego (fechariego,tipoproducto) VALUES(?,?)");
    	ps.setString(1, fechaRiego.getText());
    	ps.setString(2, tipoProducto.getText());
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
