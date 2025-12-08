package mx.uacm.gestor_etapas.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    // 1. Campo simple para el ID (se usará para guardar en BD)
    @Column(name = "id_actividad")
    private Long idActividad;

    // 2. Relación para lectura (se marca como no insertable/actualizable para que no choque con el campo de arriba)
    @OneToOne
    @JoinColumn(name = "id_actividad", insertable = false, updatable = false)
    @JsonIgnore // Importante: Esto evita que se envíe el objeto completo y cause el error 400
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
