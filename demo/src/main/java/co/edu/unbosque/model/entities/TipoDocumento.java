package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
    @Id
    @Column(name = "id_tipo_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_documento;

    @Size(max = 40)
    @Column(name = "descripcion_documento")
    private String descripcion_documento;
}
