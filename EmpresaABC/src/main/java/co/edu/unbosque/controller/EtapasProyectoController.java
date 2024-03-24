package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.CicloVidaProyecto;
import co.edu.unbosque.model.repositories.EtapaProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/etapas")
public class EtapasProyectoController {

    @Autowired
    private EtapaProyectoRepository etapaProyectoRepository;

    @GetMapping("/lista")
    public List<CicloVidaProyecto> obtenerEtapas() {
        return etapaProyectoRepository.findAll();
    }

    @PostMapping("/crear")
    public CicloVidaProyecto crearEtapa(@RequestBody CicloVidaProyecto cicloVidaProyecto) {
        return etapaProyectoRepository.save(cicloVidaProyecto);
    }

    @PutMapping("/actualizar/{id}")
    public CicloVidaProyecto actualizarEtapa(@PathVariable("id") int id, @RequestBody CicloVidaProyecto cicloVidaProyecto) {
        cicloVidaProyecto.setId_ciclo_vida_proyecto(id);
        return etapaProyectoRepository.save(cicloVidaProyecto);
    }

    @DeleteMapping("/{id}")
    public void eliminarEtapa(@PathVariable("id") int id) {
        etapaProyectoRepository.deleteById(id);
    }
}
