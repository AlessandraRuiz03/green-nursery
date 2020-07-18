package Jardineria.View;

import Jardineria.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class inicioController {
	 private Main main;
	 
	 
	public void setMain(Main main) {
	this.main = main;;
		
	}
	
    @FXML
    private Button producto;

    @FXML
    private Button tipoProducto;

    @FXML
    private Button riego;

    @FXML
    private Button fotos;

    @FXML
    private Button condicion;

    @FXML
    private Button calendario;

    @FXML
    private Button regresarM;

    @FXML
    private Button integrantes;

    @FXML
    private Button graficas;

    @FXML
    void ClickCalendario(ActionEvent event) {
    	main.VentanaCalendario();
    }

    @FXML
    void ClickCondicion(ActionEvent event) {
    	main.VentanaCondicion();
    }

    @FXML
    void ClickFotos(ActionEvent event) {
        main.VentanaFotos();
    }

    @FXML
    void ClickGraficas(ActionEvent event) {
    	main.VentanaGraficas();
    }

    @FXML
    void ClickIntegrantes(ActionEvent event) {
         main.VentanaIntegrantes();
    }

    @FXML
    void ClickProducto(ActionEvent event) {
         main.VentanaProducto();
    }

    @FXML
    void ClickRegresarM(ActionEvent event) {
    	main.VentanaInicio();
    }

    @FXML
    void ClickRiego(ActionEvent event) {
    	main.VentanaRiego();
    }

    @FXML
    void ClickTipoProducto(ActionEvent event) {
    	main.VentanaTipoProduto();
    }

}
