package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.EstadoProyecto;
import co.edu.unbosque.model.repositories.EstadoProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/estados")
public class EstadoProyectoController {

    @Autowired
    private EstadoProyectoRepository estadoProyectoRepository;

    @GetMapping("/lista")
    public List<EstadoProyecto> obtenerEstados() {
        return estadoProyectoRepository.findAll();
    }

    @PostMapping("/crear")
    public EstadoProyecto crearEstado(@RequestBody EstadoProyecto estadoProyecto) {
        return estadoProyectoRepository.save(estadoProyecto);
    }

    @PutMapping("/actualizar/{id}")
    public EstadoProyecto actualizarEstado(@PathVariable("id") int id, @RequestBody EstadoProyecto estadoProyecto) {
        estadoProyecto.setId_estado_proyecto(id);
        return estadoProyectoRepository.save(estadoProyecto);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstado(@PathVariable("id") int id) {
        estadoProyectoRepository.deleteById(id);
    }
}
