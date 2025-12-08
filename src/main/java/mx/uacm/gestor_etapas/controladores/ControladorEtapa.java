package mx.uacm.gestor_etapas.controladores;

import mx.uacm.gestor_etapas.persistencia.entidades.Etapa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/formulario-etapa")
public class ControladorEtapa {

    private RestTemplate restTemplate = new RestTemplate();
    private final String urlEtapa = "http://localhost:8080/api/recurso_etapa";

    // 1. Mostrar formulario para un Cronograma específico
    @GetMapping("/nueva/{idCronograma}")
    public String nuevaEtapa(@PathVariable Long idCronograma, Model model) {

        // Creamos una etapa vacía y le asignamos el ID del padre (Cronograma)
        Etapa etapa = new Etapa();
        etapa.setIdCronograma(idCronograma);

        model.addAttribute("etapa", etapa);
        return "formularioEtapas";
    }

    // 2. Guardar la etapa
    @PostMapping("/guardar")
    public String guardarEtapa(Etapa etapa) {
        // Enviamos el objeto a la API
        restTemplate.postForObject(urlEtapa, etapa, Etapa.class);
        return "redirect:/etapas";
    }
}