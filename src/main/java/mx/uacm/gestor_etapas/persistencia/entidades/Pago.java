package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @Column(name = "id_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    private LocalDate fecha_pago;
    private String torma_pago;
    private String referencias;
    private String estado;
}
