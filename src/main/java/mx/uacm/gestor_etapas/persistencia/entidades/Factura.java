package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;
    private Long id_cliente;
    private String numeroFactura;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double subtotal;
    private double iva;
    private double total;
    private String estado;
    private String formaPago;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
