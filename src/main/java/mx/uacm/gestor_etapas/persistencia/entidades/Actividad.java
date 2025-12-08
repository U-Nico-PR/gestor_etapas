package mx.uacm.gestor_etapas.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "actidades")
@Data
public class Actividad {

    @Id
    @Column(name = "id_activida")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_etapa")
    @JsonIgnoreProperties("actividades")
    private Etapa etapa;

    // Es el responsable
    @OneToOne
    @JoinColumn(name = "id_responsable")
    private Empleado responsable;

    @OneToOne(mappedBy = "actividad")
   // ESTO PERMITE LEER EL ENTREGABLE,
    // PERO EVITA QUE AL LEERLO SE TRAIGA DE NUEVO LA ACTIVIDAD
    @JsonIgnoreProperties("actividad")
    private Entregable entregable;

    private String tipo;
    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private String estado;
    private int horas_estimadas;
    private int horas_reales;
    private String descripcion;
}
