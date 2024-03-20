package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "lider")
public class Lider {
    @Id
    @Column(name = "ID_Lider")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLider;
    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_TipoDocumento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private IDTipoDocumento idTipoDocumento;
    @Column(name = "Nombre_Lider")
    private String nombreLider;
    private String direccionLider;
    private int telefonoLider;
    private int numDocLider;
    private Date fechaNacimiento;
    private Date fechaIngreso;
}
