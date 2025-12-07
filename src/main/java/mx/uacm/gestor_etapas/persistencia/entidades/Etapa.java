package mx.uacm.gestor_etapas.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "etapas")
@Data
public class Etapa {

    @Id
    @Column(name = "id_etapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cronograma")
    @JsonBackReference
    private Cronograma cronograma;

    @OneToMany(mappedBy = "etapa")
    private List<Actividad> actividades;

    @OneToOne
    @JoinColumn(name = "id_presupuesto")
    private Presupuesto presupuesto;

    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_estimada;
    private LocalDate fecha_fin;
    private double costo;
    private String fase;
    private String descripcion;

}
