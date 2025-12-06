package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "facturas")
@Data
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

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
