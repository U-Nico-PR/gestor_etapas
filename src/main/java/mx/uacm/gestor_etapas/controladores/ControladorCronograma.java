package mx.uacm.gestor_etapas.controladores;

import mx.uacm.gestor_etapas.persistencia.entidades.Cronograma;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/etapas")
public class ControladorCronograma {

    // Declarado como atributo. Podría ser en un Bean para que Spring lo gestione
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080/api/recurso_cronograma";

    @GetMapping
    public String consumirAPI(Model model) {
        ResponseEntity<List<Cronograma>> resp = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cronograma>>() {}
        );
        List<Cronograma> cronogramas = resp.getBody();
        model.addAttribute("cronogramas", cronogramas != null ? cronogramas : List.of());
        return "cronograma"; // nombre de la vista Thymeleaf
    }
}
