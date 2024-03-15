package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Column(name = "ID_Empleado")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Size(max = 40)
@Column(name = "rol")
    private String rol;
@Size(max = 40)
@Column(name = "Nombre_Empleado")
    private String nombreCompleto;
    @Size(max = 40)
    @Column(name = "Direccion_Empleado")
    private String direccion;
    @Size(max = 40)
    @Column(name = "Salario_Empleado")
    private int salario;
    @Column(name = "Fecha_Ingreso")
    private Date fechaIngreso;
    @Column(name = "Fecha_Nacimiento")
    private Date fechaNacimiento;
    @Size(max = 40)
    @Column(name = "Telefono_Empleado")
    private int telefono;
    @Size(max = 40)
    @Column(name = "NumDoc_Empleado")
    private int num_doc_empl;
    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_TipoDocumento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private IDTipoDocumento idTipoDocumento;
}
