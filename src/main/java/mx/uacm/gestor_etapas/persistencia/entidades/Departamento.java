package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "departamentos")
@Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_departamento;

    private String descripcion;
    private String nombre;
    private String extencion;
    private String email;

    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleados;

}
