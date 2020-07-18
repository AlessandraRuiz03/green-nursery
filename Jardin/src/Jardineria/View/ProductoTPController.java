package Jardineria.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Jardineria.Conexion;
import Jardineria.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class ProductoTPController {
	
	Main main;
	Connection con = Conexion.getConexion();
	PreparedStatement ps;
	
	  @FXML
	    private LineChart<String, Integer> producto;

	    @FXML
	    private Button ver;
	    @FXML
	    private CategoryAxis xAxis;
	    @FXML
	    private ObservableList<String> leyenda;

	    @SuppressWarnings("unchecked")
		@FXML
	    void VerGrafica(ActionEvent event) throws SQLException {
	    	
	    	 Statement st = con.createStatement();
	    		String sql = "SELECT tipoproducto, COUNT(*)FROM producto\r\n" + 
	    				"GROUP BY tipoproducto";
	    		System.out.println("SQL " + sql);
	    			ResultSet rs = st.executeQuery(sql);
				
				XYChart.Series<String, Integer> barraProducto = new XYChart.Series<>();
				ObservableList<String> leyenda =  FXCollections.observableArrayList();
				 while (rs.next()){
			            
			            leyenda.add(""+rs.getString(1));
			            barraProducto.getData().add(new XYChart.Data<>(""+rs.getString(1), rs.getInt(2)));
			        }
				 xAxis.setCategories(leyenda);  // se asigna la leyenda a la grafica
			     producto.getData().addAll(barraProducto); // s
	    	
	    }

	public void setMain(Main main) {
		this.main = main;
		
	}

}
