package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "puestos")
@Data
public class Puesto {
    @Id
    @Column(name = "id_puesto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_puesto;

    private String nombre;

    private String descripcion;

    private double sueldo_base;

    // Lado inverso: no tiene FK
    @OneToMany(mappedBy = "puesto")
    private List<Empleado> empleados;
}
