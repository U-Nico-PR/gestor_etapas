package mx.uacm.gestor_etapas.config;

import mx.uacm.gestor_etapas.persistencia.entidades.Actividad;
import mx.uacm.gestor_etapas.persistencia.entidades.Cronograma;
import mx.uacm.gestor_etapas.persistencia.entidades.Etapa;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ConfigDataRest implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // 1️⃣ JSON plano
        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
        config.useHalAsDefaultJsonMediaType(false);

        // 2️⃣ Exponer IDs
        config.exposeIdsFor(Actividad.class, Etapa.class, Cronograma.class);

        // 3️⃣ (Opcional) CORS
        cors.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
