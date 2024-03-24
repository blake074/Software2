package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.AsignacionProyecto;
import co.edu.unbosque.model.repositories.AsignacionEtapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/etapasproyectos")
public class AsignacionProyectoController {

    @Autowired
    private AsignacionEtapaRepository asignacionEtapaRepository;

    @GetMapping("/lista")
    public List<AsignacionProyecto> obtenerEtapasProyectos() {
        return asignacionEtapaRepository.findAll();
    }

    @PostMapping("/crear")
    public AsignacionProyecto crearEtapasProyectos(@RequestBody AsignacionProyecto asignacionProyecto) {
        return asignacionEtapaRepository.save(asignacionProyecto);
    }

    @PutMapping("/actualizar/{id}")
    public AsignacionProyecto actualizarEtapasProyecto(@PathVariable("id") int id, @RequestBody AsignacionProyecto asignacionProyecto) {
        asignacionProyecto.setId_asignacion_etapa_proyecto(id);
        return asignacionEtapaRepository.save(asignacionProyecto);
    }

    @DeleteMapping("/{id}")
    public void eliminarEtapasProyectos(@PathVariable("id") int id) {
        asignacionEtapaRepository.deleteById(id);
    }
}
