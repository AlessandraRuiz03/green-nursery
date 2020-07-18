package Jardineria;

public class TablaProducto {
	
	String tipoProducto,nombre,fechaIngreso,condicion;
	int  idProducto;
	
	public TablaProducto(int idProducto,String tipoProducto,String nombre,String fechaIngreso,String condicion){
		this. idProducto = idProducto;
		this.tipoProducto = tipoProducto;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.condicion = condicion;
		
	}
	
public TablaProducto() {
		// TODO Auto-generated constructor stub
	}

	public void setIdProducto(int idProducto) {
		this.idProducto =  idProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public void setCondicion(String condicion){
		this.condicion = condicion;
	}
	public int getIdProducto() {
		return  idProducto;
	}
	
	public String getTipoProducto() {
		return tipoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public String getCondicion() {
		return condicion;
	}
}
