package co.edu.unbosque.model.repositories;

import co.edu.unbosque.model.entities.AsignacionProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionEtapaRepository extends JpaRepository<AsignacionProyecto, Integer> {
}
