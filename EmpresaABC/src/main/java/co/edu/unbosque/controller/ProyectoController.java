package co.edu.unbosque.controller;
import co.edu.unbosque.model.entities.Proyecto;
import co.edu.unbosque.model.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/lista")
    public List<Proyecto> obtenerProyectos() {
        return proyectoService.obtenerProyectos();
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
    @PutMapping("/actualizar/{id_proyecto}")
    public Proyecto actualizarProyecto(@PathVariable("id_proyecto") int idProyecto, @RequestBody Proyecto proyecto) {
        proyecto.setId_proyecto(idProyecto);
        return proyectoService.updateProyecto(proyecto);
    }
    @DeleteMapping("{id_proyecto}")
    public void eliminarProyecto(@PathVariable("id_proyecto") int idProyecto) {
        proyectoService.eliminarProyectos(idProyecto);
    }
}