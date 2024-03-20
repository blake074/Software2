package co.edu.unbosque.model;

import java.util.Date;

public class CreadorProyectos implements ProyectoFactory {

    @Override
    public Proyecto createProyecto(int idDescripcionProyecto, String nombreProyecto, Date fechaInicio, Date fechaFin, String estadoProyecto) {
        Proyecto proyecto = new Proyecto();
        proyecto.idDescripcionProyecto = idDescripcionProyecto;
        proyecto.nombreProyecto = nombreProyecto;
        proyecto.fechaInicio = fechaInicio;
        proyecto.fechaFin = fechaFin;
        proyecto.estadoProyecto = estadoProyecto;
        return proyecto;
    }
}
