package mx.uacm.gestor_etapas.persistencia.entidades;

import java.time.LocalDate;

public class Empleado {
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
}
