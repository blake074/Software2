package co.edu.unbosque.model.entities;

import java.util.Date;

public class FactoryEmpleadoArquitecto implements FactoryEmpleado {

	@Override
	public Empleado crearEmpleado(String nombre, String direccion, Date fechai, Date fechan, String tel, String numdoc,
			int tipodoc) {
		return new EmpleadoArquitecto(nombre, direccion, fechai, fechan, tel, numdoc, tipodoc);
	}

}
