package co.edu.unbosque.model.entities;

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

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto id_proyecto;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado id_empleado;
}
