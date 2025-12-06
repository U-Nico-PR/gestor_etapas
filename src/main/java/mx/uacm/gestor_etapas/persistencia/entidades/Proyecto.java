package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "proyectos")
@Data
public class Proyecto {

    @Id
    @Column(name = "id_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @OneToOne
    @JoinColumn(name = "id_encargado")
    private Empleado empleado;

    @OneToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;
    private String tipo;

    @OneToOne
    @JoinColumn(name = "id_cronograma")
    private Cronograma cronogramas;
}
