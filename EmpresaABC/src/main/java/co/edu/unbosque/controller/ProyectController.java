package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.Empleado;
import co.edu.unbosque.model.entities.EmpleadoDTO;
import co.edu.unbosque.model.entities.EstadoProyecto;
import co.edu.unbosque.model.entities.Proyecto;
import co.edu.unbosque.model.repositories.ProyectoRepository;
import co.edu.unbosque.model.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectController {
    @Autowired
    private ProyectoService proyectoService;
    @Autowired
    private ProyectoRepository proyectoRepository;
    @GetMapping("/lista")
    public List<Proyecto> obtenerEmpleados() {
        return (List<Proyecto>) proyectoService.obtenerProyectos();
    }
    @PostMapping("/crear")
    public Proyecto crearEmpleado(@RequestBody Proyecto proyecto, String nombreProyecto, Date fechaInicio, Date fechaFin,
                                     String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto) {
        return proyectoService.crearProyecto(proyecto, nombreProyecto, fechaInicio, fechaFin, descripcionProyecto, presupuesto, idEstadoProyecto);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Proyecto actualizarEmpleado(@RequestBody Proyecto proyecto, String nombreProyecto, Date fechaInicio, Date fechaFin,
                                       String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto) {
        return proyectoService.crearProyecto(proyecto, nombreProyecto, fechaInicio, fechaFin, descripcionProyecto, presupuesto, idEstadoProyecto);
    }
    @DeleteMapping("{id_empleado}")
    public void eliminarEmpleado(@PathVariable("id_proyecto") int idProyecto) {
        proyectoService.eliminarProyectos(idProyecto);
    }
}
