package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ciclo_vida_proyecto")
public class CicloVidaProyecto {
    @Id
    @Column(name = "id_ciclo_vida_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ciclo_vida_proyecto;

    @Size(max = 40)
    @Column(name = "descripcion_ciclo_vida_proyecto")
    private String descripcion_ciclo_vida_proyecto;
}
