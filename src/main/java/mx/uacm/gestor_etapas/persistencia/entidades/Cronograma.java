package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cronogramas")
@Data
public class Cronograma {
    @Id
    @Column(name = "id_cronograma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cronograma;

    @OneToMany(mappedBy = "cronograma")
    private List<Etapa> etapas;

    private LocalDate fecha_inicio;

    private LocalDate fecha_final;

    private String descripcion;
}
