package co.edu.unbosque.model.repositories;

import co.edu.unbosque.model.entities.CicloVidaProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapaProyectoRepository extends JpaRepository<CicloVidaProyecto, Integer> {
}
