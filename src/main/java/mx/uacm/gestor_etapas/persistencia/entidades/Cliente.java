package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre;
    private String razonSocial;
    private String rfc;
    private String direccion;
    private String email;
    private String contactoPrincipal;
    private String telefono;
    private String empresa;
    private String estado;
    @OneToMany (mappedBy = "reuniones")
    private List<Reunion> reuniones;
    @OneToMany(mappedBy = "facturas")
    private List<Factura> facturas;

}
