package mx.uacm.gestor_etapas.persistencia.entidades;

import java.time.LocalDate;

public class Entregable {
    private Long id_entregable;
    private Long id_actividad;
    private Long id_encargado;
    private String tipo;
    private String nombre;
    private String version;
    private String url_repositorio;
    private LocalDate fecha_entrega;
    private String descripcion;
}
