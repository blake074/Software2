package co.edu.unbosque.model.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

    private int id;
    private Rol rol;
    private String nombreCompleto;
    private String direccion;
    private int salario;
    private LocalDate fechaIngreso;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String numDoc_Empleado;
    private TipoDocumento ID_TipoDocumento;
}
