package Jardineria;

public class TablaTipoProducto {
	
	String tipoProducto;
	int IDTipoProducto;
	
	public TablaTipoProducto(){}
	public TablaTipoProducto(int IDTipoProducto,String tipoProducto){
		this.IDTipoProducto = IDTipoProducto;
		this.tipoProducto = tipoProducto;
	}
	
	public void setIDTipoProducto(int IDTipoProducto) {
		this.IDTipoProducto = IDTipoProducto;
	}
	
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public int getIDTipoProducto() {
		return IDTipoProducto;
	}
	
	public String getTipoProducto() {
		return tipoProducto;
	}
}
