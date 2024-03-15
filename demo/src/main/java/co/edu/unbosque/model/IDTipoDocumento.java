package co.edu.unbosque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TipoDocumento")
public class IDTipoDocumento {
    @Id
    @Column(name = "ID_TipoDocumento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_doc;
    @Size(max = 40)
    @Column(name = "Descripcion_Documento")
    private String descripcion_documento;
}
