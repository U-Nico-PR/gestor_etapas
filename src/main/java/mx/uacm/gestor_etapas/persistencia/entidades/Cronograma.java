package mx.uacm.gestor_etapas.persistencia.entidades;

import java.time.LocalDate;

public class Cronograma {
    private Long id_cronograma;
    private Long id_proyecto;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private String descripcion;
}
