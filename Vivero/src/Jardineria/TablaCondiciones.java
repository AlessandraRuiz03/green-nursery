package Jardineria;

public class TablaCondiciones {
	
	int idCondicion;
	String condicion;
	
	public TablaCondiciones(int idCondicion,String condicion) {
		this.idCondicion = idCondicion;
		this.condicion = condicion;
	}
	
	public TablaCondiciones() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCondicion() {
		return idCondicion;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setIdCondicion(int idCondicion) {
		this.idCondicion = idCondicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
}
