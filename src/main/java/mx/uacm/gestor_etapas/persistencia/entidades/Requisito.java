package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "requisitos")
@Data
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_requisito;

    private LocalDate fechaRegistro;
    private String tipo;
    private String estado;
    private String descripcion;
    private String String;
}
