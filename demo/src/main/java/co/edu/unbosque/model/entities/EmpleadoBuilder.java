package co.edu.unbosque.model.entities;

import org.springframework.stereotype.Component;

@Component
public class EmpleadoBuilder {

    public EmpleadoDTO convertToDto(Empleado empleado) {
        return EmpleadoDTO.builder()
                .id(empleado.getId_empleado())
                .rol(empleado.getId_rol())
                .nombreCompleto(empleado.getNombre_empleado())
                .direccion(empleado.getDireccion_empleado())
                .salario(empleado.getSalario_empleado())
                .fechaIngreso(empleado.getFecha_ingreso())
                .fechaNacimiento(empleado.getFecha_nacimiento())
                .telefono(empleado.getTelefono_empleado())
                .numDoc_Empleado(empleado.getNum_doc_empleado())
                .ID_TipoDocumento(empleado.getId_tipo_documento())
                .build();
    }
}
