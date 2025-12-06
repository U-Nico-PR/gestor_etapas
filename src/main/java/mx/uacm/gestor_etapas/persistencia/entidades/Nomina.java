package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "nominas")
@Data
public class Nomina {
    @Id
    @Column(name = "id_nomina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nomina;

    // mappedBy se utiliza cuando no es lado propietario y no tiene la FK
    @OneToMany(mappedBy = "nomina,")
    private List<Empleado> empleados;

    //@Temporal(TemporalType.DATE) Según no es recomendable cuando se usa LocalDate.
    private LocalDate fecha;

    private Double monto;

    private Double deduccion;

    private String periodo_pago; //Semanal, Quincenal, Mensual
}
