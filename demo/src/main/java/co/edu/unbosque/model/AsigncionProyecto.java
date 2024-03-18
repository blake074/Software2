package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "asignacionetapaproyecto")
public class AsigncionProyecto {
    @Id
    @Column(name = "ID_AsignacionEtapaProyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsignacionProyecto;
    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_Proyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proyecto idProyecto;
    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_CicloVidaProyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CicloVidaProyecto idCicloVidaProyecto;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
}
