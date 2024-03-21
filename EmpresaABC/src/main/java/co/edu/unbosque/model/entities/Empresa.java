package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

@Getter
@Setter
@Entity
@Table(name = "empresa")
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @Column(name = "id_empresa")
    private int id_empresa;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
}
