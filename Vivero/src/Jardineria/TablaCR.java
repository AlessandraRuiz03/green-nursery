package Jardineria;

public class TablaCR {
	int idCalendarioRiego;
	String dia, tipo_Producto;
	
	public TablaCR(int idCalendarioRiego, String dia , String tipo_Producto){
		this.idCalendarioRiego = idCalendarioRiego;
		this.dia = dia;
		this.tipo_Producto = tipo_Producto;
	}
	
	public TablaCR() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCalendarioRiego() {
		return idCalendarioRiego;
	}
	public String getDia() {
		return dia;
	}
	public String getTipo_Producto() {
		return tipo_Producto;
	}
	public void setIdCalendarioRiego(int idCalendarioRiego) {
		this.idCalendarioRiego = idCalendarioRiego;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public void setTipo_Producto(String tipo_Producto) {
		this.tipo_Producto = tipo_Producto;
	}
	
	

}
