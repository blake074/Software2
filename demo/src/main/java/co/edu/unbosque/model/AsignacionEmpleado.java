package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "asignacionempleadoproyecto")
public class AsignacionEmpleado {
    @Id
    @Column(name = "ID_AsignacionEmpleadoProyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsignacionEmpeladoProyecto;
    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_Proyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proyecto idProyecto;
    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_Empleado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empleado idEmpleado;
}
