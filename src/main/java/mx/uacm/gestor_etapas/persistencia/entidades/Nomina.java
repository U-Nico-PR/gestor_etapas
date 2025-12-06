package mx.uacm.gestor_etapas.persistencia.entidades;

import java.time.LocalDate;

public class Nomina {
    private Long id_nomina;
    private Long id_empleado;
    private LocalDate fecha;
    private Double monto;
    private Double deduccion;
    private String periodo_pago; //Semanal, Quincenal, Mensual
}
