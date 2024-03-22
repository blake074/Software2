package co.edu.unbosque.model.services;

import co.edu.unbosque.model.entities.EstadoProyecto;
import co.edu.unbosque.model.entities.Proyecto;
import co.edu.unbosque.model.entities.ProyectoFactory;
import co.edu.unbosque.model.repositories.ProyectoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProyectoService implements ProyectoFactory {
    @Autowired
    private ProyectoRepository proyectoRepository;


    public List<Proyecto> obtenerProyectos(){
        List<Proyecto> proyectoList = proyectoRepository.findAll();
        return proyectoList;
    }

    public void eliminarProyectos(int id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto createProyecto(String nombreProyecto, Date fechaInicio, Date fechaFin, String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre_proyecto(nombreProyecto);
        proyecto.setFecha_inicio(fechaInicio);
        proyecto.setFecha_fin(fechaFin);
        proyecto.setDescripcion_proyecto(descripcionProyecto);
        proyecto.setPresupuesto(presupuesto);
        proyecto.setId_estado_proyecto(idEstadoProyecto);
        return proyectoRepository.save(proyecto);
    }
}
