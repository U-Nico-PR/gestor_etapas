package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "metricas")
@Data
public class Metrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_metrica;

    private String nombre;
    private double valor;
    private double valor_actual;
    private String unidad_medida;
    private LocalDate fecha_mediacion;
    private String descripcion;


}
