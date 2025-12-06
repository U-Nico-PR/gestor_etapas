package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "revisiones")
@Data
public class Revision {
    @Id
    @Column(name = "id_revision")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_revision;

    @OneToOne
    @JoinColumn(name = "id_entregable")
    private Entregable entregable;

    // Es el auditor de las revisiones
    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    private LocalDate fecha_revision;

    private String resultado;

    private String comentario;
}
