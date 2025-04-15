package es.uned.aw.ped2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;
/**
 * Para generar el war, extenderemos la clase de 
 * 
 * 
 * public class Application extends SpringBootServletInitializer
 * 
 * También añadir la siguiente línea a nuestr POM
 * 
 * <packaging>war</packaging>
 * 
 * Luego ejecutar maven -build con la opción de "package"
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    @Bean
	public RequestContextListener requestContextListener() {
	       return new RequestContextListener();
	}

}
