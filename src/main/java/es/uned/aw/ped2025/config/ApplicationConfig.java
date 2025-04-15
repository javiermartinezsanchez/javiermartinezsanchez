package es.uned.aw.ped2025.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Beans definidos en la configuración de la aplicación.
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public ActiveUserStore activeUserStore() {
        return new ActiveUserStore();
    }

}
