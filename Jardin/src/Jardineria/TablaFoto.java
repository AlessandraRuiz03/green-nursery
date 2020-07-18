package Jardineria;

public class TablaFoto {

	String nombre,url, FechaFoto;
	
	int IDFoto,IDProducto;
	
	public TablaFoto() {}
	public TablaFoto(int IDFoto,String nombre,String url,String FechaFoto,int IDProducto) {
		this.IDFoto = IDFoto;
		this.nombre = nombre;
		this.url = url;
		this.FechaFoto = FechaFoto;
		this.IDProducto = IDProducto;
	}
	
	public void setIDFoto(int IDFoto) {
		this.IDFoto = IDFoto;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setFechaFoto(String FechaFoto) {
		this.FechaFoto = FechaFoto;
	}
	public void setIDProducto(int IDProducto) {
		this.IDProducto = IDProducto;
	}
	
	public int getIDFoto() {
		return IDFoto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getUrl() {
		return url;
	}
	public String getFechaFoto() {
		return FechaFoto;
	}
	
	public int getIDProducto() {
		return IDProducto;
	}
}
