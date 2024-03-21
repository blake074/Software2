package co.edu.unbosque.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "asignacion_etapa_proyecto")
public class AsignacionProyecto {
    @Id
    @Column(name = "id_asignacion_etapa_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignacion_etapa_proyecto;

    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_proyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proyecto id_proyecto;

    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_ciclo_vida_proyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CicloVidaProyecto id_ciclo_vida_proyecto;

    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @Column(name = "fecha_fin")
    private Date fecha_fin;
}
