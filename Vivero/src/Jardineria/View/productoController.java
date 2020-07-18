package Jardineria.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import Jardineria.Procedimientos;
import Jardineria.TablaProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class productoController {
	
	int count;
	Main main;
	@FXML
	private Button regresar;

    @FXML
    private TextField tipoProducto;

    @FXML
    private TextField nombre;

    @FXML
    private TextField fechaIngreso;
    @FXML
    private TextField tipoPA;
    
    @FXML
    private TextField condicion;

    @FXML
    private Button registrar;

    @FXML
    private TextField IdEliminar;

    @FXML
    private Button eliminar;

    @FXML
    private TextField idPActualizar;

    @FXML
    private TextField nombreAct;

    @FXML
    private TextField FIactualizar;
   

    @FXML
    private Button actualizar;
    
    @FXML
    private Button mostrar;
    @FXML
    private TextField condicionAct;
    
    @FXML
    TableColumn<TablaProducto, Integer>  id_producto;
   
    @FXML
    TableColumn<TablaProducto, String> TipoProducto;
    
    @FXML
    TableColumn<TablaProducto, String> Nombre;

    @FXML
    TableColumn<TablaProducto, String> FechaIngreso;
    
    @FXML
    TableColumn<TablaProducto, String> Condicion;
    
    @FXML
    TableView<TablaProducto> MostrarDatos;
    
    ObservableList<TablaProducto> tabla = FXCollections.observableArrayList();
    Connection conn;
    
    @FXML
    void Registro(){
    	if(tipoProducto.getText().isEmpty() || nombre.getText().isEmpty() || fechaIngreso.getText().isEmpty() || condicion.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Advertencia");
    		alert.setHeaderText("Agregue correctamente la Informacion");
    		alert.setContentText("Vuelve a Intentar");
    		alert.showAndWait();
    		tipoProducto.setText("");
    		nombre.setText("");
    		fechaIngreso.setText("");
    		condicion.setText("");
    		tipoProducto.requestFocus();
    		nombre.requestFocus();
    		fechaIngreso.requestFocus();
    		condicion.requestFocus();
    	}else {
    		try {
    			//componer consulta
    			ResultSet res = Conexion.Consulta("Select count(nombre)from producto where nombre='"+nombre.getText()+"'");
    			System.out.print("pasa");
    			try {
    				while(res.next()) {
    					count = res.getInt(1);
    				}
    			}catch(SQLException e) {	
    			}
    			
    			if(count>=1) {
    				Alert alert = new Alert(AlertType.WARNING);
    				alert.setTitle("Advertencia");
    				alert.setHeaderText("Este Elemento Ya Existe");
    				alert.setContentText("Vuelve a Intentar");
    				alert.showAndWait();
    			}else {
    				Procedimientos.AgregarDatosProductos(tipoProducto.getText(),nombre.getText(),fechaIngreso.getText(),condicion.getText());
    	    		tipoProducto.setText("");
    	    		nombre.setText("");
    	    		fechaIngreso.setText("");
    	    		tipoProducto.requestFocus();
    	    		nombre.requestFocus();
    	    		fechaIngreso.requestFocus();
    	    		Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setTitle("Datos");
    				alert.setHeaderText("Los Datos han sido registrados");
    				alert.setContentText(null);
    				alert.showAndWait();
    			}
    		}catch(SQLException e) {
    			System.out.print("catch"+e);
    		}
    		
    	}
    }
    
    @FXML
    void Mostrar() {
    	System.out.println("entra ver");
    	tabla.clear();
    	try { 
            String SQL = "select * from producto inner join TipoProducto \r\n" + 
            		"	on producto.tipoProducto = TipoProducto.tipo\r\n" + 
            		"	inner join condicionProducto\r\n" + 
            		"	on producto.condicion = condicionProducto.condicion";
            String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
     		conn =  DriverManager.getConnection(url,"ale","aleids");
            Statement st = conn.createStatement(); 
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) { 
            	TablaProducto producto = new TablaProducto();
            	producto.setIdProducto(rs.getInt("idProducto"));
            	producto.setCondicion(rs.getString("condicion"));
            	producto.setFechaIngreso(rs.getString("fechaIngreso"));
            	producto.setNombre(rs.getString("nombre"));
            	producto.setTipoProducto(rs.getString("tipoProducto"));
            	tabla.add(producto);
           
         }         
           
        } catch (Exception e) { 
         System.out.println("catch: "+e);
        } 
		
    //	id_producto.setCellValueFactory(new PropertyValueFactory<>("idProducto")); //aqui marca error 
		 TipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoProducto"));
		 Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		 FechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
		 Condicion.setCellValueFactory(new PropertyValueFactory<>("condicion"));
		 MostrarDatos.setItems(tabla);
		    }

    @FXML
    void clickEliminar( ) {
    	 if(IdEliminar.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText("Ingresa el Id del producto a eliminar");
	    		alert.setContentText("Vuelve a Intentar");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="delete from producto where idProducto= ('"+IdEliminar.getText()+"')"; //modificar 
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Eliminado correctamente");
					  IdEliminar.setText("");
					  IdEliminar.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo eliminar ");
					e.printStackTrace();
				}
	    	}
    }
    
    @FXML
    void clickActualizar() {
    	 if(idPActualizar.getText().isEmpty()|| tipoPA.getText().isEmpty()|| nombreAct.getText().isEmpty()||FIactualizar.getText().isEmpty()||condicionAct.getText().isEmpty()) {
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Advertencia");
	    		alert.setHeaderText(" ");
	    		alert.setContentText("Rellena los campos");
	    		alert.showAndWait();
	    	}else {
	    		try {
					String SQL ="update producto set tipoProducto = ('"+tipoPA.getText()+"'), nombre = ('"+nombreAct.getText()+"'), fechaIngreso= ('"+FIactualizar.getText()+"'), condicion=('"+condicionAct.getText()+"') where idProducto = ('"+idPActualizar.getText()+"')";
	    			conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					System.out.println("Conectado");
					st.execute(SQL);
					alert("Actualizado");
					 idPActualizar.setText("");
					 idPActualizar.requestFocus();
				     tipoPA.setText("");
					 tipoPA.requestFocus();
				     nombreAct.setText("");
					 nombreAct.requestFocus();
					 FIactualizar.setText(" ");
					 FIactualizar.requestFocus();
					 condicionAct.setText(" ");
					 condicionAct.requestFocus();
		 	} catch (SQLException e) {
					alert("No se pudo actualizar ");
					e.printStackTrace();
				}
	    	}
    }
    

    @FXML
    void clickRegresar() {
     	main.VentanaMenu();
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
