package model;

import java.util.Date;

public class EmpleadoDesarrollador extends Empleado {

	public EmpleadoDesarrollador(String nombre_empleado, String direccion_empleado, Date fecha_ingreso,
			Date fecha_nacimiento, String telefono_empleado, String num_doc_empleado, int id_tipo_documento) {
		super(nombre_empleado, direccion_empleado, fecha_ingreso, fecha_nacimiento, telefono_empleado, num_doc_empleado,
				id_tipo_documento);
		setId_rol(3);
		setSalario_empleado(2500000);	
		}

}
