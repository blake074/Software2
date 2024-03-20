package co.edu.unbosque.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "asignacion_empleado_proyecto")
public class AsignacionEmpleado {
    @Id
    @Column(name = "id_asignacion_empleado_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignacion_empleado_proyecto;

    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_proyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proyecto id_proyecto;

    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_empleado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empleado id_empleado;
}
