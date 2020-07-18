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

public class CantidadFotoController {
	
	Main main;
	Connection con = Conexion.getConexion();
	PreparedStatement ps;
	@FXML
    private LineChart<String, Integer> foto;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private Button ver;

    @SuppressWarnings("unchecked")
	@FXML
    void verGrafica(ActionEvent event) throws SQLException {
    	Statement st = con.createStatement();
		String sql = "SELECT IDProducto,COUNT(*) FROM historialfoto\r\n" + 
				"GROUP BY IDProducto";
		System.out.println("SQL " + sql);
			ResultSet rs = st.executeQuery(sql);
		
		XYChart.Series<String, Integer> barraFoto = new XYChart.Series<>();
		ObservableList<String> leyenda =  FXCollections.observableArrayList();
		 while (rs.next()){
	            
	            leyenda.add(""+rs.getString(1));
	            barraFoto.getData().add(new XYChart.Data<>(""+rs.getString(1), rs.getInt(2))); 
	        }
		 xAxis.setCategories(leyenda); 
	     foto.getData().addAll(barraFoto);    
    }

	public void setMain(Main main) {
		this.main = main;
	}
}
