package mx.uacm.gestor_etapas.persistencia.repositorios;

import mx.uacm.gestor_etapas.persistencia.entidades.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IEtapasRepositorio extends JpaRepository<Etapa, Long> {

}
