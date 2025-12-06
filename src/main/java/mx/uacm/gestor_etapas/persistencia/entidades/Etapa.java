package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "etapa")
public class Etapa {

    @Id
    @Column(name = "id_etapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cronograma")
    private Cronograma cronogrma;

    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_estimada;
    private LocalDate fecha_fin;
    private double costo;
    private String fase;
    private String descripcion;
}
