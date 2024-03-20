package co.edu.unbosque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @Column(name = "ID_Proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idProyecto;

    @Column(name = "Descripcion_Proyecto")
    public int idDescripcionProyecto;

    @Size(max = 40)
    @Column(name = "Nombre_proyecto")
    public String nombreProyecto;

    @Column(name = "Fecha_Inicio")
    public Date fechaInicio;

    @Column(name = "Fecha_Fin")
    public Date fechaFin;

    @Column(name = "EstadoProyecto")
    public String estadoProyecto;


    public Proyecto() {

    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", idDescripcionProyecto=" + idDescripcionProyecto +
                ", nombreProyecto='" + nombreProyecto + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estadoProyecto='" + estadoProyecto + '\'' +
                '}';
    }
}
