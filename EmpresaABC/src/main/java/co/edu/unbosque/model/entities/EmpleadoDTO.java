package co.edu.unbosque.model.entities;

import lombok.*;

import java.util.Date;

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
    private Date fechaIngreso;
    private Date fechaNacimiento;
    private String telefono;
    private String numDoc_Empleado;
    private TipoDocumento ID_TipoDocumento;

    @Override
    public String toString() {
        return "EmpleadoDTO{" +
                "id=" + id +
                ", rol=" + rol +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", salario=" + salario +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono='" + telefono + '\'' +
                ", numDoc_Empleado='" + numDoc_Empleado + '\'' +
                ", ID_TipoDocumento=" + ID_TipoDocumento +
                '}';
    }
}
