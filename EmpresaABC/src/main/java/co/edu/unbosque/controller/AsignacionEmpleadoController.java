package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.AsignacionEmpleado;
import co.edu.unbosque.model.repositories.AsignacionEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/proyectosempleados")
public class AsignacionEmpleadoController {

    @Autowired
    private AsignacionEmpleadoRepository asignacionEmpleadoRepository;

    @GetMapping("/lista")
    public List<AsignacionEmpleado> obtener() {
        return asignacionEmpleadoRepository.findAll();
    }

    @PostMapping("/crear")
    public AsignacionEmpleado crear(@RequestBody AsignacionEmpleado asignacionEmpleado) {
        return asignacionEmpleadoRepository.save(asignacionEmpleado);
    }

    @PutMapping("/actualizar/{id}")
    public AsignacionEmpleado actualizar(@PathVariable("id") int id, @RequestBody AsignacionEmpleado asignacionEmpleado) {
        asignacionEmpleado.setId_asignacion_empleado_proyecto(id);
        return asignacionEmpleadoRepository.save(asignacionEmpleado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        asignacionEmpleadoRepository.deleteById(id);
    }
}
