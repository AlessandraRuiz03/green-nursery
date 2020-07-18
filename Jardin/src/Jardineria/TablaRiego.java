package Jardineria;

public class TablaRiego {

	String FechaRiego,tipoProducto;
	int IDRiego;
	public TablaRiego() {}
	public TablaRiego(int IDRiego,String FechaRiego,String tipoProducto){
		this.IDRiego =  IDRiego;
		this.FechaRiego = FechaRiego;
		this.tipoProducto = tipoProducto;
	}
	
	public void setIDRiego(int IDRiego) {
		this.IDRiego = IDRiego;
	}
	
	public void setFechaRiego(String FechaRiego) {
		this.FechaRiego = FechaRiego;
	}
	
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public int getIDRiego() {
		return IDRiego;
	}
	
	public String getFechaRiego() {
		return FechaRiego;
	}
	
	public String getTipoProducto() {
		return tipoProducto;
	}
}
