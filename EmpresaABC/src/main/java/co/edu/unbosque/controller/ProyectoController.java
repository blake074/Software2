package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.EstadoProyecto;
import co.edu.unbosque.model.entities.Proyecto;
import co.edu.unbosque.model.repositories.ProyectoRepository;
import co.edu.unbosque.model.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;
    @Autowired
    private ProyectoRepository proyectoRepository;
    @GetMapping("/lista")
    public List<Proyecto> obtenerEmpleados() {
        return (List<Proyecto>) proyectoService.obtenerProyectos();
    }

    @PostMapping("/crear")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto,
                                                  @RequestParam String nombreProyecto,
                                                  @RequestParam Date fechaInicio,
                                                  @RequestParam Date fechaFin,
                                                  @RequestParam String descripcionProyecto,
                                                  @RequestParam int presupuesto,
                                                  @RequestParam EstadoProyecto idEstadoProyecto) {
        Proyecto newProyecto = proyectoService.createProyecto(nombreProyecto, fechaInicio, fechaFin, descripcionProyecto, presupuesto, idEstadoProyecto);
        return ResponseEntity.ok(newProyecto);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Proyecto actualizarEmpleado(@RequestBody Proyecto proyecto, String nombreProyecto, Date fechaInicio, Date fechaFin,
                                       String descripcionProyecto, int presupuesto, EstadoProyecto idEstadoProyecto) {
        return proyectoService.createProyecto(nombreProyecto, fechaInicio, fechaFin, descripcionProyecto, presupuesto, idEstadoProyecto);
    }
    @DeleteMapping("{id_proyecto}")
    public void eliminarEmpleado(@PathVariable("id_proyecto") int idProyecto) {
        proyectoService.eliminarProyectos(idProyecto);
    }
}
