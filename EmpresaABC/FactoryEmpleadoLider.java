package model;

import java.util.Date;

public class FactoryEmpleadoLider implements FactoryEmpleado{

	@Override
	public Empleado crearEmpleado(String nombre, String direccion, Date fechai, Date fechan, String tel, String numdoc,
			int tipodoc) {
		return new EmpleadoLider(nombre, direccion, fechai, fechan, tel, numdoc, tipodoc);
	}

}
