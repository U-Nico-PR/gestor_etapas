package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @Column(name = "id_equipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_responsable")
    private Empleado responsable;

    @OneToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    private String rol_asignado;
    private LocalDate fecha_asignacion;
    private LocalDate fecha_fin;
}
