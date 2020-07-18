package Jardineria.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.TablaHistorialFoto;
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

public class fotosController {
	Main main;
	Connection conn;
	TablaHistorialFoto TablaHistorial;

    @FXML
    private TextField IDFregistrar;

    @FXML
    private TextField nombreR;

    @FXML
    private TextField urlR;

    @FXML
    private TextField fechaR;

    @FXML
    private Button registrar;

    @FXML
    private TextField IDFeliminar;

    @FXML
    private Button eliminar;

    @FXML
    private TextField IDFA;

    @FXML
    private TextField nombreA;

    @FXML
    private Button actualizar;

    @FXML
    private Button ver;

    @FXML
    private TextField urlA;

    @FXML
    private TextField fechaA;
    @FXML
    private TableView<TablaHistorialFoto> mostrar;

    @FXML
    private TableColumn<TablaHistorialFoto, Integer> id_foto;

    @FXML
    private TableColumn<TablaHistorialFoto, String> nombreFoto;

    @FXML
    private TableColumn<TablaHistorialFoto, String> idProducto;

    @FXML
    private TableColumn<TablaHistorialFoto, String> fechaFoto;

    @FXML
    private TableColumn<TablaHistorialFoto, String> url;
    ObservableList<TablaHistorialFoto> tabla = FXCollections.observableArrayList();

   

    @FXML
    void clickActualizar(ActionEvent event) {
    	if(IDFA.getText().isEmpty()||nombreA.getText().isEmpty()||urlA.getText().isEmpty()||fechaA.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Advertencia");
    		alert.setHeaderText("Rellena los campos");
    		alert.setContentText("Vuelve a Intentar");
    		alert.showAndWait();
    	}else {
    		try {
				String SQL ="update historialFoto set nombreFoto=('"+nombreA.getText()+"'),fechaFoto=('"+fechaA.getText()+"'),url= ('"+urlA.getText()+"') where idFoto = ('"+IDFA.getText()+"')";
    			conn = Conexion.getConexion();
				Statement st = conn.createStatement();
				System.out.println("Conectado");
				st.execute(SQL);
				alert("Actualizado");
				IDFregistrar.setText("");
				IDFregistrar.requestFocus();
				nombreR.setText("");
				nombreR.requestFocus();
				urlR.setText("");
				urlR.requestFocus();
				fechaR.setText("");
				fechaR.requestFocus();
	 	} catch (SQLException e) {
				alert("No se pudo Actualizar");
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void clickEliminar(ActionEvent event) {
    	if(IDFeliminar.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Advertencia");
    		alert.setHeaderText("Ingresa el Id de la foto a eliminar");
    		alert.setContentText("Vuelve a Intentar");
    		alert.showAndWait();
    	}else {
    		try {
				String SQL ="delete from historialFoto where idFoto= ('"+IDFeliminar.getText()+"')"; 
    			conn = Conexion.getConexion();
				Statement st = conn.createStatement();
				System.out.println("Conectado");
				st.execute(SQL);
				alert("Eliminado correctamente");
				IDFeliminar.setText("");
				IDFeliminar.requestFocus();
	 	} catch (SQLException e) {
				alert("No se pudo eliminar ");
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void clickRegistrar(ActionEvent event) {
    	if(IDFregistrar.getText().isEmpty()||nombreR.getText().isEmpty()||urlR.getText().isEmpty()||fechaR.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Advertencia");
    		alert.setHeaderText("Rellena los campos");
    		alert.setContentText("Vuelve a Intentar");
    		alert.showAndWait();
    	}else {
    		try {
				String SQL ="insert into historialFoto (nombreFoto,idProducto,fechaFoto,url) values ('"+nombreR.getText()+"','"+IDFregistrar.getText()+"','"+fechaR.getText()+"','"+urlR.getText()+"')";
    			conn = Conexion.getConexion();
				Statement st = conn.createStatement();
				System.out.println("Conectado");
				st.execute(SQL);
				alert("Registrado");
				IDFregistrar.setText("");
				IDFregistrar.requestFocus();
				nombreR.setText("");
				nombreR.requestFocus();
				urlR.setText("");
				urlR.requestFocus();
				fechaR.setText("");
				fechaR.requestFocus();
	 	} catch (SQLException e) {
				alert("No se pudo registrar");
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void clickVer(ActionEvent event) {
    	 tabla.clear();
    	System.out.println("entra ver");
    	try { 
            String SQL = "Select *  from historialFoto";
            String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
     		conn =  DriverManager.getConnection(url,"ale","aleids");
            Statement st = conn.createStatement(); 
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) { 
            	TablaHistorialFoto  TablaHistorial = new TablaHistorialFoto();
            	TablaHistorial.setIdFoto(rs.getInt("idFoto"));
            	TablaHistorial.setNombreFoto(rs.getString("nombreFoto"));
            	TablaHistorial.setIdProducto(rs.getString("idProducto"));
            	TablaHistorial.setFechaFoto(rs.getString("fechaFoto"));
            	TablaHistorial.setUrl(rs.getString("url"));
          //  tabla.add((rs.getInt("id_foto"),rs.getString("nombreFoto"),rs.getString(" idProducto"),rs.getString("fechaFoto"),rs.getString("url")));
            tabla.add(TablaHistorial);
         }         
           
        } catch (Exception e) { 
        System.out.println("catch: "+e);
        } 
    	id_foto.setCellValueFactory(new PropertyValueFactory<>("idFoto"));
    	nombreFoto.setCellValueFactory(new PropertyValueFactory<>("nombreFoto"));
    	idProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
    	fechaFoto.setCellValueFactory(new PropertyValueFactory<>("fechaFoto"));
    	url.setCellValueFactory(new PropertyValueFactory<>("url"));
		
		
		 mostrar.setItems(tabla);
    }
    @FXML
    private Button RegresarH;

    @FXML
    void ClickRegresarH(ActionEvent event) {
    	main.VentanaMenu();
    }

	public void setMain(Main main) {
		this.main = main;;
		
	}
	void alert(String alerta) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION,alerta);
		alert.getDialogPane().setMinHeight(100);
		alert.show();
	}
}
