package Jardineria.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Jardineria.Calendario;
import Jardineria.Conexion;
import Jardineria.Main;
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
	
	Connection con = Conexion.getConexion();
	PreparedStatement ps;

    @FXML
    private TextField dia;
    
    @FXML
    private TextField tipoProducto;

    @FXML
    private Button registrar;

    @FXML
    private TextField idCalendarioE;

    @FXML
    private Button eliminar;

    @FXML
    private TextField idCalendario;

    @FXML
    private TextField diaA;

    @FXML
    private TextField tipoProductoA;

    @FXML
    private Button actualizar;

    @FXML
    private Button mostrarDatos;

    @FXML
    private Button RegresarR;

    @FXML
    private TableView<Calendario> MostrarTabla;

    @FXML
    private TableColumn<Calendario, Integer> IDCalendario;

    @FXML
    private TableColumn<Calendario, String> Dia;

    @FXML
    private TableColumn<Calendario, String> TipoProducto;
    ObservableList<Calendario> tabla = FXCollections.observableArrayList();
    
    Main main;

    @FXML
    void Actualizar(ActionEvent event) {
    	try{
        	ps = con.prepareStatement("UPDATE calendarioriego SET tipoproducto=?,dia=? WHERE idcalendario=?");
        	ps.setString(1, tipoProductoA.getText());
        	ps.setString(2, diaA.getText());
        	ps.setString(3, idCalendario.getText());
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Actualizacion");
    			alert.setHeaderText("Registro Actualizado Exitosamente");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}else{
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
        	ps = con.prepareStatement("DELETE FROM calendarioriego WHERE idcalendario=?");
        	ps.setString(1, idCalendarioE.getText());
        	
        	int num = ps.executeUpdate();
        	if(num>0) {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Eliminado");
    			alert.setHeaderText("Registro Elimiando Exitosamente");
    			alert.setContentText(null);
    			alert.showAndWait();
        	}else {
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Eliminado");
    			alert.setHeaderText("No se Puedo Elimiando el Registro");
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
	        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM calendarioriego");
	        while(rs.next()) {
        		Calendario  cal = new Calendario();    
        		cal.setIDCalendario(rs.getInt("IDCalendario"));
        		cal.setDia(rs.getString("Dia"));
        		cal.setTipoProducto(rs.getString("TipoProducto"));
        		tabla.add(cal);
        		}
        	}catch(SQLException e){
        		System.out.print(e);
        	}
    	IDCalendario.setCellValueFactory(new PropertyValueFactory<>("IDCalendario"));
    	Dia.setCellValueFactory(new PropertyValueFactory<>("Dia"));
    	TipoProducto.setCellValueFactory(new PropertyValueFactory<>("TipoProducto"));
    	MostrarTabla.setItems(tabla);	
    }
    
    @FXML
    void Registro(ActionEvent event) {
    	
    	try {
    	ps = con.prepareStatement("INSERT INTO calendarioriego (dia,tipoproducto) VALUES(?,?)");
    	ps.setString(1, dia.getText());
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
		this.main = main;;
		
	}


}
