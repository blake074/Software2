package co.edu.unbosque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado_proyecto")
public class EstadoProyecto {
    @Id
    @Column(name = "ID_EstadoProyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadoProyecto;
    @Size(max = 40)
    @Column(name = "Descripcion_EstadoProyecto")
    private String descripcionEstadoProyecto;
}
