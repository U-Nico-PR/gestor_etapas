package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;

@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @Column(name = "id_contrato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private int numero_empleado;
    private double monto_total;
    private String moneda;
    private LocalDate fecha_firma;
    private String folio_legal;
    private LocalDate fecha_vencimiento;
    private String tipo_contrato;
    private String condiciones;
}
