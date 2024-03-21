package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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
    private Date fecha_ingreso;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "telefono_empleado")
    private String telefono_empleado;

    @Size(max = 40)
    @Column(name = "num_doc_empleado")
    private String num_doc_empleado;

    @ManyToOne //(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tipo_documento")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoDocumento id_tipo_documento;

    @ManyToOne //(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rol")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol id_rol;
}
