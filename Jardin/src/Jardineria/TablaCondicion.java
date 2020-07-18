package Jardineria;

public class TablaCondicion {

	String condicion;
	int IDCondicion;
	
	public TablaCondicion() {}
	
	public TablaCondicion(int IDCondicion,String condicion) {
		this.IDCondicion = IDCondicion;
		this.condicion = condicion;
	}
	
	public void setIDCondicion(int idCondicion) {
		this.IDCondicion = idCondicion;
	}
	
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	public int getIDCondicion() {
		return IDCondicion;
	}
	public String getCondicion() {
		return condicion;
	}
}
