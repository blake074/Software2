package co.edu.unbosque.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "proyecto")
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto {
    @Id
    @Column(name = "id_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proyecto;

    @Size(max = 40)
    @Column(name = "nombre_proyecto")
    private String nombre_proyecto;

    @Column(name = "fecha_inicio")
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin")
    private LocalDate fecha_fin;

    @Column(name = "descripcion_proyecto")
    private String descripcion_proyecto;

    @Column(name = "presupuesto")
    private int presupuesto;

    @ManyToOne(fetch =  FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_estado_proyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EstadoProyecto id_estado_proyecto;



    @Override
    public String toString() {
        return "Proyecto{" +
                "id_proyecto=" + id_proyecto +
                ", nombre_proyecto='" + nombre_proyecto + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", descripcion_proyecto='" + descripcion_proyecto + '\'' +
                ", presupuesto=" + presupuesto +
                ", id_estado_proyecto=" + id_estado_proyecto +
                '}';
    }
}
