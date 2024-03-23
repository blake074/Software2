package co.edu.unbosque.model.repositories;

import co.edu.unbosque.model.entities.Empleado;
import co.edu.unbosque.model.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
}
