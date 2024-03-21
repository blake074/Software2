
package co.edu.unbosque.model.entities;

import java.util.Date;

public interface ProyectoFactory {
    Proyecto createProyecto(String nombreProyecto, Date fechaInicio, Date fechaFin,
                            String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto);
}