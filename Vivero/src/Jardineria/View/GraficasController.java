package Jardineria.View;

import Jardineria.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class GraficasController {
	private Main main;
    @FXML
    private Button productoTP;

    @FXML
    private Button productoCA;

    @FXML
    private Button riego;

    @FXML
    private Button riegosD;

    @FXML
    private Button fotografiaTP;

    @FXML
    private Button calendario;

    @FXML
    private Button regresarG;

    @FXML
    void ClickCalendario() {
    	main.Ventana6();
    }

    @FXML
    void ClickFotografiaTP4() {
    	main.Ventana4();
    }

    @FXML
    void ClickProductoCA3() {
    	main.Ventana3();

    }

    @FXML
    void ClickProductoTP1() {
    	main.Ventana1();
    }

    @FXML
    void ClickRegresarG() {
    	main.VentanaMenu();
    }

    @FXML
    void ClickRiego() {
    	main.Ventana5();
    }

    @FXML
    void ClickRiegosD2() {
    	main.Ventana2();
    }

    public void setMain(Main main) {
		this.main = main;
	}
    

}