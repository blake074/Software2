package co.edu.unbosque.model;

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
    @Column(name = "EstadoProyecto")
    private String estadoProyecto;
    @Column(name = "Descripcion_Proyecto")
    private String descripcion;
}