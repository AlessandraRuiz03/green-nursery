package Jardineria.View;
import Jardineria.Conexion;
import Jardineria.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class BDController {
	private Main main;

    @FXML
    private Button mysql;

    @FXML
    private Button sqls;

    @FXML
    void ClickMysql(ActionEvent event) {
    	Conexion.getConexion();
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Conexion");
		alert.setHeaderText("Conexion Exitosa");
		alert.setContentText("Bienvenido");
		alert.showAndWait();
    	main.VentanaMenu();
    }

    @FXML
    void ClickSqls(ActionEvent event) {
    	main.VentanaMenu();
    }

	public void setMain(Main main) {
		this.main = main;
		
	}
    
    
}
