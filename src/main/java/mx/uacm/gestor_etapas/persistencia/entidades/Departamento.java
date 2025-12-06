package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_departamento;
    private Long id_jefe;
    private String descripcion;
    private String nombre;
    private String extencion;
    private String email;

}
