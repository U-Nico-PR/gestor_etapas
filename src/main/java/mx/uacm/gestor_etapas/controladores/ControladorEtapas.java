package mx.uacm.gestor_etapas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/etapas")
public class ControladorEtapas {

    @GetMapping
    public String consumirAPI(Model model) {
        String url = "http://localhost:8080/api/etapas";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        model.addAttribute("apiResponse", response);
        return "ok";
    }
}
