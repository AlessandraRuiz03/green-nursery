package Jardineria;

public class Calendario {

	String tipoProducto,dia;
	int IDCalendario;
	
	public Calendario(){
	}
		public Calendario(int IDCalendario,String dia,String tipoProducto) {
		this.IDCalendario = IDCalendario;
		this.dia = dia;
		this.tipoProducto = tipoProducto;
	}
	public void setIDCalendario(int IDCalendario) {
		this.IDCalendario = IDCalendario;
	}
	
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public int getIDCalendario() {
		return IDCalendario;
	}
	public String getDia() {
		return dia;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
}
