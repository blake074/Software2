package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.Empleado;
import co.edu.unbosque.model.entities.EmpleadoDTO;
import co.edu.unbosque.model.repositories.EmpleadoRepository;
import co.edu.unbosque.model.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * El controlador de la entidad Empleado, que maneja las solicitudes relacionadas con los empleados.
 */
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    /**
     * El servicio de empleado que maneja la lógica de negocio relacionada con los empleados.
     */
    @Autowired
    private EmpleadoService empleadoService;

    /**
     * El repositorio de empleado que proporciona acceso a la base de datos para los empleados.
     */
    @Autowired
    private EmpleadoRepository empleadoRepository;

    /*
    @GetMapping("/lista")
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll();
    }
     */

    /**
     * Maneja las solicitudes GET para obtener una lista de empleados.
     * @return Una lista de objetos EmpleadoDTO que representan los empleados.
     */
    @GetMapping("/lista")
    public List<EmpleadoDTO> obtenerEmpleados() {
        return (List<EmpleadoDTO>) empleadoService.obtenerEmpleados();
    }


    /**
     * Maneja las solicitudes POST para crear un nuevo empleado.
     * @param empleado El objeto Empleado recibido en el cuerpo de la solicitud.
     * @return El objeto EmpleadoDTO creado para el empleado.
     */
    @PostMapping("/crear")
    public EmpleadoDTO crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    /**
     * Maneja las solicitudes PUT para actualizar un empleado existente.
     * @param empleado El objeto Empleado recibido en el cuerpo de la solicitud.
     * @return El objeto EmpleadoDTO actualizado para el empleado.
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpleadoDTO actualizarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    /**
     * Maneja las solicitudes DELETE para eliminar un empleado por su ID.
     * @param id_empleado El ID del empleado que se eliminará.
     */
    @DeleteMapping("{id_empleado}")
    public void eliminarEmpleado(@PathVariable("id_empleado") int id_empleado) {
        empleadoService.eliminarEmpleados(id_empleado);
    }
}
