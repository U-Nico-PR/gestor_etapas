package mx.uacm.gestor_etapas.controladores_rest;

import mx.uacm.gestor_etapas.persistencia.entidades.Cronograma;
import mx.uacm.gestor_etapas.persistencia.repositorios.ICronogramaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/recurso_cronograma")
public class ControladorCronogramaRest {

    private final ICronogramaRepositorio repo;

    public ControladorCronogramaRest(ICronogramaRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Cronograma> listar() {
        return repo.findAll();
    }
}
