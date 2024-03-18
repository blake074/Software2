package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@Builder
@Getter
public class ProyectoBuilder {

    private int idProyecto;

    private String nombreProyecto;

    private Date fechaInicio;

    private Date fechaFinal;

    private String descripcion;

    private int presupuesto;

    private EstadoProyecto estadoProyecto;

}
