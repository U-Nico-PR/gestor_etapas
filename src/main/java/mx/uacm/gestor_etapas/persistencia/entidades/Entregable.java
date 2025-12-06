package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "entregables")
@Data
public class Entregable {
    @Id
    @Column(name = "id_entregable")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entregable;

    @OneToOne
    @JoinColumn(name = "id_actividad")
    private Actividad actividad;

    // Quien es autor del entregable
    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    private String tipo;

    private String nombre;

    private String version;

    private String url_repositorio;

    private LocalDate fecha_entrega;

    private String descripcion;
}
