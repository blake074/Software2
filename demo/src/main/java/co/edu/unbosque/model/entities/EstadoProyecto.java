package co.edu.unbosque.model.entities;

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
    @Column(name = "id_estado_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado_proyecto;

    @Size(max = 40)
    @Column(name = "descripcion_estado_proyecto")
    private String descripcion_estado_proyecto;
}
