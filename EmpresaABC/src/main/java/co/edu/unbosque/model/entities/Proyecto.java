package co.edu.unbosque.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @Column(name = "id_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proyecto;

    @Size(max = 40)
    @Column(name = "nombre_proyecto")
    private String nombre_proyecto;

    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @Column(name = "fecha_fin")
    private Date fecha_fin;

    @Column(name = "descripcion_proyecto")
    private String descripcion_proyecto;

    @Column(name = "presupuesto")
    private int presupuesto;

    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_estado_proyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EstadoProyecto id_estado_proyecto;


}
