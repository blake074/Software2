package co.edu.unbosque.model.entities;

import java.util.Date;

public interface FactoryEmpleado {

	public Empleado crearEmpleado(String nombre, String direccion, Date fechai, Date fechan
									, String tel, String numdoc, int tipodoc);
	
}
