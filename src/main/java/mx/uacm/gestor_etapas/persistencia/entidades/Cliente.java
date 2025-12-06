package mx.uacm.gestor_etapas.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
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

    @OneToMany (mappedBy = "cliente")
    private List<Reunion> reuniones;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;

}
