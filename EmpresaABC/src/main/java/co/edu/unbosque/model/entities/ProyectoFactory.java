
package co.edu.unbosque.model.entities;

import java.time.LocalDate;
import java.util.Date;

public interface ProyectoFactory {
    Proyecto createProyecto(String nombreProyecto, LocalDate fechaInicio, LocalDate fechaFin,
                            String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto);
}