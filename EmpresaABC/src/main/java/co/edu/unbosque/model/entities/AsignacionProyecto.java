package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "asignacion_etapa_proyecto")
public class AsignacionProyecto {
    @Id
    @Column(name = "id_asignacion_etapa_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignacion_etapa_proyecto;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto id_proyecto;

    @ManyToOne
    @JoinColumn(name = "id_ciclo_vida_proyecto")
    private CicloVidaProyecto id_ciclo_vida_proyecto;

    @Column(name = "fecha_inicio")
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin")
    private LocalDate fecha_fin;
}
