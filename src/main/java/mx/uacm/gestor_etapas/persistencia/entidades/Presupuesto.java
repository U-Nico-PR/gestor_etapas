package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "presupuestos")
@Data
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_presupuesto;

    private double monto;
    private String moneda;
    private String comentarios;

}
