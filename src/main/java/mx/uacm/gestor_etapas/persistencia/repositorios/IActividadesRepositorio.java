package mx.uacm.gestor_etapas.persistencia.repositorios;

import mx.uacm.gestor_etapas.persistencia.entidades.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "recurso_actividad")
public interface IActividadesRepositorio extends JpaRepository<Actividad, Long> {
}
