package mx.uacm.gestor_etapas.persistencia.entidades;

import java.time.LocalDate;

public class Revision {
    private Long id_revision;
    private Long id_entregable;
    private Long id_auditor;
    private LocalDate fecha_revision;
    private String resultado;
    private String comentario;
}
