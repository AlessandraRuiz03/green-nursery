package Jardineria;

public class TablaHistorialFoto {

	int idFoto;
	String nombreFoto, idProducto,fechaFoto,url;
	
	public TablaHistorialFoto(int idFoto, String nombreFoto,String idProducto,String fechaFoto,String url) {
		this.idFoto = idFoto;
		this.nombreFoto = nombreFoto;
		this.idProducto = idProducto;
		this.fechaFoto = fechaFoto;
		this.url = url;
	}
	
	public TablaHistorialFoto() {
		// TODO Auto-generated constructor stub
	}

	public int getIdFoto() {
		return idFoto;
	}
	public String getNombreFoto() {
		return nombreFoto;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public String getFechaFoto() {
		return fechaFoto;
	}
	public String getUrl() {
		return url;
	}
	
	public void setFechaFoto(String fechaFoto) {
		this.fechaFoto = fechaFoto;
	}
	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
