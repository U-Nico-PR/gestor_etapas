package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_requisito;
    private Long id_proyecto;
    private LocalDate fechaRegistro;
    private String tipo;
    private String estado;
    private String descripcion;
    private String String;
}
