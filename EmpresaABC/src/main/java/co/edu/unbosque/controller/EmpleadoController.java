package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.Empleado;
import co.edu.unbosque.model.entities.EmpleadoBuilder;
import co.edu.unbosque.model.entities.EmpleadoDTO;
import co.edu.unbosque.model.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * El controlador de la entidad Empleado, que maneja las solicitudes relacionadas con los empleados.
 */
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    /**
     * El repositorio de empleado que proporciona acceso a la base de datos para los empleados.
     */
    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * El constructor de EmpleadoBuilder que se utiliza para convertir entidades Empleado a objetos EmpleadoDTO.
     */
    private EmpleadoBuilder empleadoBuilder;

    /**
     * Crea un nuevo empleado en la base de datos y devuelve su representación en forma de EmpleadoDTO.
     * @param empleado El objeto Empleado que se creará.
     * @return El objeto EmpleadoDTO creado para el empleado.
     */
    @PostMapping("/crear")
    public EmpleadoDTO crearEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
        return empleadoBuilder.convertToDto(empleado);
    }

    /**
     * Maneja las solicitudes PUT para actualizar un empleado existente.
     * @param empleado El objeto Empleado recibido en el cuerpo de la solicitud.
     * @return El objeto EmpleadoDTO actualizado para el empleado.
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpleadoDTO actualizarEmpleado(@RequestBody Empleado empleado) {
        return crearEmpleado(empleado);
    }

    /**
     * Obtiene una lista de todos los empleados en forma de objetos EmpleadoDTO.
     * @return Una lista de objetos EmpleadoDTO que representan los empleados.
     */
    @GetMapping("/lista")
    public List<EmpleadoDTO> obtenerEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados.stream()
                .map(empleadoBuilder::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Elimina un empleado de la base de datos según su ID.
     * @param id El ID del empleado que se eliminará.
     */
    @DeleteMapping("{id_empleado}")
    public void eliminarEmpleados(int id) {
        empleadoRepository.deleteById(id);
    }
}
