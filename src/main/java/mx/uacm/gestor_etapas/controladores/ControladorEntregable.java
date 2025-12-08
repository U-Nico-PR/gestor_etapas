package mx.uacm.gestor_etapas.controladores;

import mx.uacm.gestor_etapas.persistencia.entidades.Actividad;
import mx.uacm.gestor_etapas.persistencia.entidades.Entregable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/formulario-entregable")
public class ControladorEntregable {

    private RestTemplate restTemplate = new RestTemplate();

    // URLs de tu API interna (Spring Data REST)
    private final String urlActividad = "http://localhost:8080/api/recurso_actividad";
    private final String urlEntregable = "http://localhost:8080/api/recurso_entregable";

    // 1. Mostrar el formulario para una Actividad especifica
    @GetMapping("/nuevo/{idActividad}")
    public String nuevoEntregable(@PathVariable Long idActividad, Model model) {
        // Recuperamos la actividad para asegurarnos que existe y vincularla
        Actividad actividad = restTemplate.getForObject(urlActividad + "/" + idActividad, Actividad.class);

        // Preparamos el nuevo entregable
        Entregable entregable = new Entregable();
        // ASIGNAMOS EL ID AL NUEVO CAMPO
        entregable.setIdActividad(idActividad); // Vinculación inicial

        model.addAttribute("entregable", entregable);

        // Retornamos el nombre del archivo HTML (sin .html)
        return "formularioEntregables";
    }

    // 2. Guardar el entregable
    @PostMapping("/guardar")
    public String guardarEntregable(Entregable entregable) {
        // Enviamos el objeto a la API REST para que se guarde en BD
        restTemplate.postForObject(urlEntregable, entregable, Entregable.class);

        // Redirigimos al cronograma principal
        return "redirect:/etapas";
    }
}