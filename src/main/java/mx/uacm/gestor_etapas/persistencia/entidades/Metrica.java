package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Metrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_metrica;
    private int id_proyecto;
    private int id_etapa;
    private String nombre;
    private double valor;
    private double valor_actual;
    private String unidad_medida;
    private LocalDate fecha_mediacion;
    private String descripcion;


}
