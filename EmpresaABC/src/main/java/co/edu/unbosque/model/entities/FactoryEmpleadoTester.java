package co.edu.unbosque.model.entities;

import java.util.Date;

public class FactoryEmpleadoTester implements FactoryEmpleado{

	@Override
	public Empleado crearEmpleado(String nombre, String direccion, Date fechai, Date fechan, String tel, String numdoc,
			int tipodoc) {
		return new EmpleadoTester(nombre, direccion, fechai, fechan, tel, numdoc, tipodoc);
	}

}
