package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;
    private Long id_departamento;
    private Long id_puesto;
    private Long id_equipo;
    private String nombre;
    private String telefono;
    private String email;
    private String rfc;
    private LocalDate fecha_contratacion;
    private String estado; // ¿Qué estado?
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}
