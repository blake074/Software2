package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empleado;

    @Size(max = 40)
    @Column(name = "nombre_empleado")
    private String nombre_empleado;

    @Size(max = 40)
    @Column(name = "direccion_empleado")
    private String direccion_empleado;

    //@Size(max = 40)
    @Column(name = "salario_empleado")
    private int salario_empleado;

    @Column(name = "fecha_ingreso")
    private LocalDate fecha_ingreso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @Column(name = "telefono_empleado")
    private String telefono_empleado;

    @Size(max = 40)
    @Column(name = "num_doc_empleado")
    private String num_doc_empleado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento id_tipo_documento;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol id_rol;
}
