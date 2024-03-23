package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.EstadoProyecto;
import co.edu.unbosque.model.entities.Proyecto;
import co.edu.unbosque.model.repositories.ProyectoRepository;
import co.edu.unbosque.model.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<Proyecto> obtenerProyectos() {

        return (List<Proyecto>) proyectoService.obtenerProyectos();
    }

    @PostMapping("/crear")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto newProyecto = proyectoService.createProyecto(
                proyecto.getNombre_proyecto(),
                proyecto.getFecha_inicio(),
                proyecto.getFecha_fin(),
                proyecto.getDescripcion_proyecto(),
                proyecto.getPresupuesto(),
                proyecto.getId_estado_proyecto()
        );
        return ResponseEntity.ok(newProyecto);
    }
    @PutMapping("/actualizar")
    public Proyecto actualizarProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.updateProyecto(proyecto);
    }
    @DeleteMapping("{id_proyecto}")
    public void eliminarProyecto(@PathVariable("id_proyecto") int idProyecto) {
        proyectoService.eliminarProyectos(idProyecto);
    }
}
