package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @Column(name = "ID_Proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyecto;
    @Size(max = 40)
    @Column(name = "Nombre_proyecto")
    private String nombreProyecto;
    @Column(name = "Fecha_Inicio")
    private Date fechaInicio;
    @Column(name = "Fecha_Fin")
    private Date fechaFinal;
    @Column(name = "Descripcion_Proyecto")
    private String descripcion;
    @Column(name = "Presupuesto")
    private int presupuesto;
    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_EstadoProyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EstadoProyecto estadoProyecto;

    public Proyecto (ProyectoBuilder proyectoBuilder){
        this.idProyecto = proyectoBuilder.getIdProyecto();
        this.nombreProyecto = proyectoBuilder.getNombreProyecto();
        this.fechaInicio = proyectoBuilder.getFechaInicio();
        this.fechaFinal = proyectoBuilder.getFechaFinal();
        this.descripcion = proyectoBuilder.getDescripcion();
        this.presupuesto = proyectoBuilder.getPresupuesto();
        this.estadoProyecto = proyectoBuilder.getEstadoProyecto();
    }

    public Proyecto() {

    }
}
