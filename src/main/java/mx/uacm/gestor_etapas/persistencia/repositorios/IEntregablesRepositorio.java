package mx.uacm.gestor_etapas.persistencia.repositorios;

import mx.uacm.gestor_etapas.persistencia.entidades.Entregable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "recurso_entregable")
public interface IEntregablesRepositorio extends JpaRepository<Entregable, Long> {
}
