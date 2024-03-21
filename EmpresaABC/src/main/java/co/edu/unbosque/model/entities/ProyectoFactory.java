
package co.edu.unbosque.model.entities;

import java.util.Date;

public interface ProyectoFactory {
    Proyecto createProyecto(int idDescripcionProyecto, String nombreProyecto, Date fechaInicio, Date fechaFin, String estadoProyecto);
}