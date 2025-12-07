package mx.uacm.gestor_etapas.persistencia.repositorios;

import mx.uacm.gestor_etapas.persistencia.entidades.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

// Regresa un objeto HAL con metadatos _embedded, _links, page
@RepositoryRestResource(path="recurso_cronograma")
public interface ICronogramaRepositorio extends JpaRepository<Cronograma, Long> {

    // @RestResource(path="antes-de", rel="encontrar-tarea-antes-de-fecha")

}
