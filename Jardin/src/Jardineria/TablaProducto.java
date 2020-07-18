package Jardineria;

public class TablaProducto {
	
	String tipoProducto,nombre,fechaIngreso,condicion;
	Integer IDProducto;
	
	public TablaProducto() {}
	public TablaProducto(Integer IDProducto,String tipoProducto,String nombre,String fechaIngreso, String condicion){
		this.IDProducto = IDProducto;
		this.tipoProducto = tipoProducto;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.condicion = condicion;
	}

	
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public void setIDProducto(Integer IDProducto) {
		this.IDProducto = IDProducto;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	public String getTipoProducto() {
		return tipoProducto;
	}
	
	public Integer getIDProducto() {
		return IDProducto;
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
