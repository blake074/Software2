package co.edu.unbosque.model.entities;

import java.util.Date;

public class FactoryEmpleadoDesarrollador implements FactoryEmpleado {

	@Override
	public Empleado crearEmpleado(String nombre, String direccion, Date fechai, Date fechan, String tel, String numdoc,
			int tipodoc) {
		return new EmpleadoDesarrollador(nombre, direccion, fechai, fechan, tel, numdoc, tipodoc);
	}

}
