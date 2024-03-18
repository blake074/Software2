package co.edu.unbosque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name = "ID_Rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Size(max =  40)
    @Column(name = "Descripcion_Rol")
    private String descripcionRol;
}
