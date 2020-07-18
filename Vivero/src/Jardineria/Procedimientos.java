package Jardineria;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Procedimientos {

	public static void AgregarDatosProductos(String tipoProducto,String nombre,String fechaIngreso,String condicion) throws SQLException {
		CallableStatement ingreso = Conexion.getConexion().prepareCall("{call AgregarDatosProductos(?,?,?,?)}");
		ingreso.setString(1, tipoProducto);
		ingreso.setString(2, nombre);
		ingreso.setString(3, fechaIngreso);
		ingreso.setString(4, condicion);
		ingreso.execute();
	}
	
	public static void AgregarDatosRegistro(String correo,String password) throws SQLException {
		CallableStatement ingreso = Conexion.getConexion().prepareCall("{call AgregarDatosRegistro(?,?)}");
		ingreso.setString(1, correo);
		ingreso.setString(2, password);
		ingreso.execute();
	}
}

