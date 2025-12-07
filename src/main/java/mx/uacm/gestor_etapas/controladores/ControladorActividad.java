package mx.uacm.gestor_etapas.controladores;

import mx.uacm.gestor_etapas.persistencia.entidades.Actividad;
import mx.uacm.gestor_etapas.persistencia.entidades.Etapa;
import mx.uacm.gestor_etapas.persistencia.repositorios.IEtapasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/formulario-actividad/nueva")
public class ControladorActividad {

    private RestTemplate restTemplate = new RestTemplate();
    private final String urlActividad = "http://localhost:8080/api/recurso_actividad";
    private final String urlEtapa = "http://localhost:8080/api/recurso_etapa";

    @GetMapping("/{id}")
    public String nuevaActividad(@PathVariable Long id, Model model) {
        // Buscar etapa a la que pertenece consumiento la api
        Etapa etapa = restTemplate.getForObject(urlEtapa + "/" + id, Etapa.class);

        // Hacer un objeto actividad y asociarla a la etapa
        Actividad actividad = new Actividad();
        actividad.setEtapa(etapa);

        // Mandarla al formulario
        model.addAttribute("actividad", actividad);
        return "formularioActividades";
    }

    @PostMapping("/guardar")
    public String guardarActividad(Actividad actividad, Model model) {
        restTemplate.postForObject(urlActividad, actividad, Actividad.class);
        return "redirect:/etapas";
    }
}
