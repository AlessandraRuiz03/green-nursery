package Jardineria;

public class TablaRiego {
     int idRiego;
     String fecha, tipoProducto;
     
     public TablaRiego(int idRiego, String fecha,String tipoProducto) {
    	 this.idRiego = idRiego;
    	 this.fecha = fecha;
    	 this.tipoProducto = tipoProducto;
     }
     
     public TablaRiego() {
		// TODO Auto-generated constructor stub
	}

	public int getIdRiego() {
 		return idRiego;
 	}
     public String getFecha() {
 		return fecha;
 	}
     public String getTipoProducto() {
 		return tipoProducto;
 	}
     public void setIdRiego(int idRiego) {
		this.idRiego = idRiego;
	}
     public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
     public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
