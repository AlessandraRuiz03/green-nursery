package Jardineria;

public class TablaTP {
	
	String  tipo;
	int id_tipoProducto;
	
	public TablaTP (int id_tipoProducto, String tipo){
		this.id_tipoProducto = id_tipoProducto;
		this.tipo = tipo;
	}
	
	



	public TablaTP() {
		// TODO Auto-generated constructor stub
	}

	public int getId_tipoProducto() {
		return  id_tipoProducto;
	}
	public String getTipo() {
		return  tipo;
	}
	public void setId_tipoProducto(int id_tipoProducto) {
		this.id_tipoProducto = id_tipoProducto;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
