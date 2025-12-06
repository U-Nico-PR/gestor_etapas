package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {
    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_puesto")
    private Puesto puesto;

    @ManyToOne
    @JoinColumn(name = "id_nomina")
    private Nomina nomina;

    private String nombre;

    private String telefono;

    private String email;

    private String rfc;

    // @Temporal(TemporalType.DATE)
    private LocalDate fecha_contratacion;

    private String estado; // ¿Qué estado?
}
