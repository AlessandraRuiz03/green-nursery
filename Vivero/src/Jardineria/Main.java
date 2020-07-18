package Jardineria;
	

import Jardineria.View.BDController;
import Jardineria.View.CalendarioController;

import Jardineria.View.GraficasController;
import Jardineria.View.cantFotosPorTipoProdu;
import Jardineria.View.cantProducCondicionActual;
import Jardineria.View.cantRiegosPorDia;
import Jardineria.View.cantRiegosPorTipoProducto;
import Jardineria.View.condicionesController;
import Jardineria.View.fotosController;
import Jardineria.View.inicioController;
import Jardineria.View.loginController;
import Jardineria.View.productoController;
import Jardineria.View.productoTPcontroller;
import Jardineria.View.registroController;
import Jardineria.View.riegoController;
import Jardineria.View.tipoProductController;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public Stage stage;
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.stage = stage;
		VentanaInicio();
		
		}
	public void VentanaInicio() {
		
		try {
		
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Login.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setTitle("GREEN NURSERY");
			this.stage = stage;
			stage.initOwner(primaryStage);
			stage.setScene(scene);
			//stage.initModality(Modality.WINDOW_MODAL);
			loginController controler = loader.getController();
			controler.setMain(this);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void VentanaMenu() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Inicio.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageInicio = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageInicio;
			stageInicio.initOwner(primaryStage);
			stageInicio.setScene(scene);
			stageInicio.initModality(Modality.WINDOW_MODAL);
			inicioController controler = loader.getController();
			controler.setMain(this);
			stageInicio.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaRegistro() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Registro.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageRegistro = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageRegistro;
			stageRegistro.initOwner(primaryStage);
			stageRegistro.setScene(scene);
			stageRegistro.initModality(Modality.WINDOW_MODAL);
			registroController controler = loader.getController();
			controler.setMain(this);
			stageRegistro.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaProducto() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Producto.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageProducto;
			stageProducto.initOwner(primaryStage);
			stageProducto.setScene(scene);
			stageProducto.initModality(Modality.WINDOW_MODAL);
			productoController controler = loader.getController();
			controler.setMain(this);
			stageProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaFotos() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Fotos.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageFotos = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageFotos;
			stageFotos.initOwner(primaryStage);
			stageFotos.setScene(scene);
			stageFotos.initModality(Modality.WINDOW_MODAL);
			fotosController controler = loader.getController();
			controler.setMain(this);
			stageFotos.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaCondicion() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Condiciones.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageCondiciones = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageCondiciones;
			stageCondiciones.initOwner(primaryStage);
			stageCondiciones.setScene(scene);
			stageCondiciones.initModality(Modality.WINDOW_MODAL);
			condicionesController controler = loader.getController();
			controler.setMain(this);
			stageCondiciones.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaRiego() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Riego.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageRiego = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageRiego;
			stageRiego.initOwner(primaryStage);
			stageRiego.setScene(scene);
			stageRiego.initModality(Modality.WINDOW_MODAL);
			riegoController controler = loader.getController();
			controler.setMain(this);
			stageRiego.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaTipoProduto() {
		stage.close();
		try {
		
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/TipoProducto.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			tipoProductController controler = loader.getController();
			controler.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaBD() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/BD.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageBD = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageBD;
			stageBD.initOwner(primaryStage);
			stageBD.setScene(scene);
			stageBD.initModality(Modality.WINDOW_MODAL);
			BDController controler = loader.getController();
			controler.setMain(this);
			stageBD.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaIntegrantes() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Integrantes.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			inicioController controler = loader.getController();
			controler.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaCalendario() {
		stage.close();
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Calendario.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			CalendarioController controler = loader.getController();
			controler.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaGraficas() {
		stage.close();
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Graficas.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			GraficasController controlerG = loader.getController();
			controlerG.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Ventana1() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/ProductoTP.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			productoTPcontroller TP = loader.getController();
			TP.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Ventana2() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/BarraRiegoR.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			//GraficasController controlerG = loader.getController();
			//controlerG.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Ventana3() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/CantProducCA.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			cantProducCondicionActual controlerG = loader.getController();
			controlerG.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Ventana4() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/CantFotos.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			cantFotosPorTipoProdu controlerG = loader.getController();
			controlerG.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void Ventana5() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/RiegoPD.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			cantRiegosPorDia controlerG = loader.getController();
			controlerG.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Ventana6() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/BarraRiegoP.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			cantRiegosPorTipoProducto controlerG = loader.getController();
			controlerG.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Stage getVentanaInicio() {
		return stage;
	}
	
	public Stage getVentanaMenu() {
		return stage;
	}
	
	public Stage getVentanaRegistro() {
		return stage;
	}
	
	public Stage getVentanaProducto() {
		return stage;
	}
	
	public Stage getVentanaFotos() {
		return stage;
	}
	
	public Stage getVentanaCondicion() {
		return stage;
	}
	
	public Stage getVentanaRiego() {
		return stage;
	}
	
	public Stage getVentanaTipoProducto() {
		return stage;
	}
	
	public Stage getVentanaBD() {
		return stage;
	}
	
	public Stage getVentanaIntegrantes() {
		return stage;
	}
	
	public Stage getVentanaCalendario() {
		return stage;
	}
	
	public Stage getVentanaGraficas() {
		return stage;
	}
	
	public Stage getVentana1() {
		return stage;
	}
	
	public Stage getVentana2() {
		return stage;
	}
	
	public Stage getVentana3() {
		return stage;
	}
	
	public Stage getVentana4() {
		return stage;
	}
	
	public Stage getVentana5() {
		return stage;
	}
	
	public Stage getVentana6() {
		return stage;
	}
}






