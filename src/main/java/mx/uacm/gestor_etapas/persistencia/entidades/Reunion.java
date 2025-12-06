package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Entity
public class Reunion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reunion;
    private LocalDate fecha_inicio;      // Recomendado que se unique junto con hora_inicio
    private LocalTime hora_reunion;// Recomendado que se unique junto con fecha_reunion
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private Long id_cliente;
    private Long id_equipo;
    private Long id_proyecto;
    private LocalTime hora_fin;
    private String titulo;
    private String objetivo;
    private String lugar;

}
