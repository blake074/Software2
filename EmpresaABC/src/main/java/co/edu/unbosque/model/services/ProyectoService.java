package co.edu.unbosque.model.services;

import co.edu.unbosque.model.entities.EstadoProyecto;
import co.edu.unbosque.model.entities.Proyecto;
import co.edu.unbosque.model.entities.ProyectoFactory;
import co.edu.unbosque.model.repositories.EstadoProyectoRepository;
import co.edu.unbosque.model.repositories.ProyectoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ProyectoService implements ProyectoFactory {
    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private EstadoProyectoRepository estadoProyectoRepository;

    public List<Proyecto> obtenerProyectos(){
        List<Proyecto> proyectoList = proyectoRepository.findAll();
        return proyectoList;
    }

    public void eliminarProyectos(int id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto createProyecto(String nombreProyecto, LocalDate fechaInicio, LocalDate fechaFin, String descripcionProyecto, Integer presupuesto, EstadoProyecto idEstadoProyecto) {
        EstadoProyecto estadoProyecto = estadoProyectoRepository.findById(idEstadoProyecto.getId_estado_proyecto())
                .orElseThrow(() -> new EntityNotFoundException("EstadoProyecto no encontrado"));

        Proyecto proyecto = new Proyecto();
        proyecto.setNombre_proyecto(nombreProyecto);
        proyecto.setFecha_inicio(fechaInicio);
        proyecto.setFecha_fin(fechaFin);
        proyecto.setDescripcion_proyecto(descripcionProyecto);
        proyecto.setPresupuesto(presupuesto);
        proyecto.setId_estado_proyecto(estadoProyecto);

        return proyectoRepository.save(proyecto);
    }

    public Proyecto updateProyecto(Proyecto proyecto) {
        Proyecto proyectoExistente = proyectoRepository.findById(proyecto.getId_proyecto())
                .orElseThrow(() -> new EntityNotFoundException("Proyecto no encontrado"));

        EstadoProyecto estadoProyecto = estadoProyectoRepository.findById(proyecto.getId_estado_proyecto().getId_estado_proyecto())
                .orElseThrow(() -> new EntityNotFoundException("EstadoProyecto no encontrado"));

        proyectoExistente.setNombre_proyecto(proyecto.getNombre_proyecto());
        proyectoExistente.setFecha_inicio(proyecto.getFecha_inicio());
        proyectoExistente.setFecha_fin(proyecto.getFecha_fin());
        proyectoExistente.setDescripcion_proyecto(proyecto.getDescripcion_proyecto());
        proyectoExistente.setPresupuesto(proyecto.getPresupuesto());
        proyectoExistente.setId_estado_proyecto(estadoProyecto);

        return proyectoRepository.save(proyectoExistente);
    }
}
