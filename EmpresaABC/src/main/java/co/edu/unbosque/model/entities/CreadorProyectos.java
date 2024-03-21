package co.edu.unbosque.model.entities;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreadorProyectos implements ProyectoFactory {


    @Override
    public Proyecto createProyecto(String nombreProyecto, Date fechaInicio, Date fechaFin, String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto) {
        Proyecto proyecto = new Proyecto();
        nombreProyecto = proyecto.getNombre_proyecto();
        fechaInicio = proyecto.getFecha_inicio();
        fechaFin = proyecto.getFecha_fin();
        descripcionProyecto = proyecto.getDescripcion_proyecto();
        presupuesto = proyecto.getPresupuesto();
        idEstadoProyecto = proyecto.getId_estado_proyecto();
        return proyecto;
    }
}
