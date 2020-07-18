package Jardineria.View;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Jardineria.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class cantRiegosFecha implements Initializable{
	
	
    private Main main;
   
    @FXML
    private Button button;
    @FXML
    private LineChart<String, Integer> chartBarras;
    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> leyenda;
    
  // private int ultvalor;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Pasaaaaaa");
    }    

    @FXML
    private void btnGenera(ActionEvent event) throws SQLException {
    
        String url = "jdbc:sqlserver://localhost;databaseName=GreenNursery;";  
 	Connection conn = DriverManager.getConnection(url,"ale","aleids"); 
        Statement st = conn.createStatement();
        System.out.println("pasa arriba");
        
		        String sql = " select fecha, count(*) from riegos"
		        		+ " group by fecha  ";
		        
		System.out.println("SQL " + sql);
		ResultSet rs = st.executeQuery(sql);
		
		
		XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series<>();
		
		ObservableList<String> leyenda =  FXCollections.observableArrayList();
		while (rs.next()){
		    
		    leyenda.add(""+rs.getString(1)); 
		    dataSeries1.getData().add(new XYChart.Data<>(""+rs.getString(1), rs.getInt(2))); 
		    
		}
		
		xAxis.setCategories(leyenda);
		chartBarras.getData().addAll(dataSeries1);
    	
    	/*catch(Exception e) {
    		System.out.println("catch"+e);
    	}*/
    }

	public void setMain(Main main) {
		this.main = main;
		
	}
    
}








