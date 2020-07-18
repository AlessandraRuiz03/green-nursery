package Jardineria.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaFoto;
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

public class fotosController {
	
	Connection con = Conexion.getConexion();
	PreparedStatement ps;
	
	@FXML
    private TextField idProducto;
    @FXML
    private TextField nombre;

    @FXML
    private TextField url;
    
    @FXML
    private TextField fechaFoto;

    @FXML
    private TableColumn<TablaFoto, String> fechaIngreso;

    @FXML
    private Button registrar;
    
    @FXML
    private Button actualizar;

    @FXML
    private TextField idFotoA;
    
    @FXML
    private TextField idFotoE;

    @FXML
    private Button eliminar;

    @FXML
    private Button mostrarDatos;

    @FXML
    private Button RegresarH;

    @FXML
    private TextField nombreA;

    @FXML
    private TextField urlA;

    @FXML
    private TextField fechaFotoA;

    @FXML
    private TableView<TablaFoto> MostrarTabla;

    @FXML
    private TableColumn<TablaFoto, Integer> IDFoto;

    @FXML
    private TableColumn<TablaFoto, String> Nombre;

    @FXML
    private TableColumn<TablaFoto, String> URL;
    
    @FXML
    private TableColumn<TablaFoto, Integer> IdProducto;
    ObservableList<TablaFoto> tabla = FXCollections.observableArrayList();
    
    
    Main main;
    
    @FXML
    void Actualizar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("UPDATE historialfoto SET nombre=?,url=?,fechafoto=? WHERE idfoto=?");
        	ps.setString(1, nombreA.getText());
        	ps.setString(2, urlA.getText());
        	ps.setString(3, fechaFotoA.getText());
        	ps.setString(4, idFotoA.getText());
        	
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
    void ClickRegresarH(ActionEvent event) {
    	main.VentanaMenu();

    }

    @FXML
    void Eliminar(ActionEvent event) {
    	try {
        	ps = con.prepareStatement("DELETE FROM historialfoto WHERE idfoto=?");
        	ps.setString(1, idFotoE.getText());
        	
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Eliminado ");
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
        	ResultSet rs = con.createStatement().executeQuery("SELECT * FROM historialfoto");
        	while(rs.next()) {
        		TablaFoto foto = new TablaFoto();
        		foto.setIDFoto(rs.getInt("IDFoto"));
        		foto.setNombre(rs.getString("nombre"));
        		foto.setUrl(rs.getString("url"));
        		foto.setFechaFoto(rs.getString("FechaFoto"));
        		foto.setIDProducto(rs.getInt("IDProducto"));
        		tabla.add(foto);
        	}
        	}catch(SQLException e) {
        		System.out.print(e);
        	}
    		IDFoto.setCellValueFactory(new PropertyValueFactory<>("IDFoto"));
    		Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    		URL.setCellValueFactory(new PropertyValueFactory<>("url"));
    		fechaIngreso.setCellValueFactory(new PropertyValueFactory<>("FechaFoto"));
    		IdProducto.setCellValueFactory(new PropertyValueFactory<>("IDProducto"));
    		MostrarTabla.setItems(tabla);
    	}
    @FXML
    void Registro(ActionEvent event) {
    	try {
    	ps = con.prepareStatement("INSERT INTO historialfoto (idproducto,nombre,url,fechafoto) VALUES(?,?,?,?)");
    	ps.setString(1, idProducto.getText());
    	ps.setString(2, nombre.getText());
    	ps.setString(3, url.getText());
    	ps.setString(4, fechaFoto.getText());
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
