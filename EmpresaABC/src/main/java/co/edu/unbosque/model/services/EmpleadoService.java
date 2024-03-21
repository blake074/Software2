package co.edu.unbosque.model.services;

import co.edu.unbosque.model.entities.Empleado;
import co.edu.unbosque.model.entities.EmpleadoBuilder;
import co.edu.unbosque.model.entities.EmpleadoDTO;
import co.edu.unbosque.model.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * El servicio que proporciona la lógica de negocio relacionada con los empleados.
 */
@Service
public class EmpleadoService {

    /**
     * El repositorio de empleado que proporciona acceso a la base de datos para los empleados.
     */
    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * El constructor de EmpleadoBuilder que se utiliza para convertir entidades Empleado a objetos EmpleadoDTO.
     */
    @Autowired
    private EmpleadoBuilder empleadoBuilder;

    /**
     * Crea un nuevo empleado en la base de datos y devuelve su representación en forma de EmpleadoDTO.
     * @param empleado El objeto Empleado que se creará.
     * @return El objeto EmpleadoDTO creado para el empleado.
     */
    public EmpleadoDTO crearEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
        return empleadoBuilder.convertToDto(empleado);
    }

    /*
    public EmpleadoDTO obtenerEmpleados() {
        return (EmpleadoDTO) empleadoRepository.findAll();
    }

     */

    /**
     * Obtiene una lista de todos los empleados en forma de objetos EmpleadoDTO.
     * @return Una lista de objetos EmpleadoDTO que representan los empleados.
     */
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
    public void eliminarEmpleados(int id) {
        empleadoRepository.deleteById(id);
    }
}
