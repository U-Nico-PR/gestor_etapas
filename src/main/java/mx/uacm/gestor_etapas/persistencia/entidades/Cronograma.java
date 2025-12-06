package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cronogramas")
public class Cronograma {
    @Id
    @Column(name = "id_cronograma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cronograma;

    @OneToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proeyecto;

    private LocalDate fecha_inicio;

    private LocalDate fecha_final;

    private String descripcion;
}
