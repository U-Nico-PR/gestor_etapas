package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reuniones")
@Data
public class Reunion {
    @Id
    @Column(name = "id_reunion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reunion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @OneToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    private LocalDate fecha_inicio;      // Recomendado que sea unique junto con hora_inicio

    private LocalTime hora_inicio;      // Recomendado que sea unique junto con fecha_reunion

    private LocalTime hora_fin;

    private String titulo;

    private String objetivo;

    private String lugar;
}
