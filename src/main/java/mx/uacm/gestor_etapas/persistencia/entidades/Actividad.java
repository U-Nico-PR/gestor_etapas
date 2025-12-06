package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Actividad {

    @Id
    @Column(name = "id_activida")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_etapa")
    private Etapa etapa;

    @OneToOne
    @JoinColumn(name = "id_requisito")
    private Requisito requisito;

    @OneToOne
    @JoinColumn(name = "id_responsable")
    private Empleado responsable;

    private String tipo;
    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private String estado;
    private int horas_estimadas;
    private int horas_reales;
    private String descripcion;
}
