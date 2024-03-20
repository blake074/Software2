package co.edu.unbosque.model;

import co.edu.unbosque.model.entities.EstadoProyecto;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@Builder
@Getter
public class ProyectoBuilder {

    private int id_proyecto;

    private String nombre_proyecto;

    private Date fecha_inicio;

    private Date fecha_fin;

    private String descripcion_proyecto;

    private int presupuesto;

    private EstadoProyecto id_estado_proyecto;

}
