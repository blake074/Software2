package co.edu.unbosque.controller;

import co.edu.unbosque.model.entities.Empleado;
import co.edu.unbosque.model.entities.EmpleadoDTO;
import co.edu.unbosque.model.repositories.EmpleadoRepository;
import co.edu.unbosque.model.services.EmpleadoService;
import co.edu.unbosque.model.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmpleadoController {
    @GetMapping("/AsignacionEmpleado")
    public ModelAndView asignacionEmpleado() {

        return new ModelAndView("AsignacionEmpleado");
    }

    @GetMapping("/AsignacionEmpleadoForm")
    public ModelAndView asignacionEmpleadoForm() {

        return new ModelAndView("AsignacionEmpleadoForm");

    }

    @GetMapping("/Empleado")
    public ModelAndView empleado() {

        return new ModelAndView("Empleado");
    }

    @GetMapping("/EmpleadoForm")
    public ModelAndView empleadoForm() {

        return new ModelAndView("EmpleadoForm");

    }

    @GetMapping("/EstadoProyecto")
    public ModelAndView estadoProyecto() {

        return new ModelAndView("EstadoProyecto");
    }

    @GetMapping("/EstadoProyectoForm")
    public ModelAndView estadoProyectoForm() {

        return new ModelAndView("EstadoProyectoForm");
    }

    @GetMapping("/EtapaProyecto")
    public ModelAndView etapaProyecto() {

        return new ModelAndView("EtapaProyecto");
    }

    @GetMapping("/EtapaProyectoForm")
    public ModelAndView etapaProyectoForm() {

        return new ModelAndView("EtapaProyectoForm");
    }

    @GetMapping("/ListaEtapas")
    public ModelAndView listaEtapas() {

        return new ModelAndView("ListaEtapas");
    }

    @GetMapping("/ListaEtapasForm")
    public ModelAndView listaEtapasForm() {

        return new ModelAndView("ListaEtapasForm");
    }

    @GetMapping("/")
    public ModelAndView index() {

        return new ModelAndView("Proyecto");
    }

    @GetMapping("/ProyectoForm")
    public ModelAndView proyectosForm() {

        return new ModelAndView("ProyectoForm");
    }

    @GetMapping("/Rol")
    public ModelAndView rol() {

        return new ModelAndView("Rol");
    }

    @GetMapping("/RolForm")
    public ModelAndView rolForm() {

        return new ModelAndView("RolForm");
    }

    @GetMapping("/TipoDocumento")
    public ModelAndView tipoDocumento() {

        return new ModelAndView("TipoDocumento");
    }

    @GetMapping("/TipoDocumentoForm")
    public ModelAndView tipoDocumentoForm() {

        return new ModelAndView("TipoDocumentoForm");
    }
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
