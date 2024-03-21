package co.edu.unbosque.model.services;

import co.edu.unbosque.model.entities.CreadorProyectos;
import co.edu.unbosque.model.entities.EstadoProyecto;
import co.edu.unbosque.model.entities.Proyecto;
import co.edu.unbosque.model.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private CreadorProyectos creadorProyectos;

    public Proyecto crearProyecto (Proyecto proyecto, String nombreProyecto, Date fechaInicio, Date fechaFin,
                                   String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto){
        proyectoRepository.save(proyecto);
        return creadorProyectos.createProyecto(nombreProyecto, fechaInicio, fechaFin, descripcionProyecto,
                presupuesto, idEstadoProyecto);
    }

    public List<Proyecto> obtenerProyectos(){
        List<Proyecto> proyectoList = proyectoRepository.findAll();
        return proyectoList;
    }

    public void eliminarProyectos(int id) {
        proyectoRepository.deleteById(id);
    }
}
