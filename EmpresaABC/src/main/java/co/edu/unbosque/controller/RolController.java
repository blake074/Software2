package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.Rol;
import co.edu.unbosque.model.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/lista")
    public List<Rol> obtenerRoles() {
        return rolRepository.findAll();
    }

    @PostMapping("/crear")
    public Rol crearRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    @PutMapping("/actualizar/{id}")
    public Rol actualizarRol(@PathVariable("id") int id, @RequestBody Rol rol) {
        rol.setId_rol(id);
        return rolRepository.save(rol);
    }

    @DeleteMapping("/{id_rol}")
    public void eliminarRol(@PathVariable("id_rol") int id_rol) {
        rolRepository.deleteById(id_rol);
    }

}
