package co.edu.unbosque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ciclovida_proyecto")
public class CicloVidaProyecto {
    @Id
    @Column(name = "ID_CicloVidaProyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCicloVidaProyecto;
    @Size(max = 40)
    @Column(name = "Descripcion_CicloVidaProyecto")
    private String descripcionCicloVidaProyecto;
}
