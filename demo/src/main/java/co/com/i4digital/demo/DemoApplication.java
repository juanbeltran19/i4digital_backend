/**
 * Copyright (c) 2021 i4digital
 * <br><A HREF="http://www.i4digital.com>"</br>
 * Todos los derechos reservados.
 */
package co.com.i4digital.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase que se encarga de iniciar la aplicacion
 *
 * @version
 * @author juanpbeltran
 * <br><b>Fecha de desarrollo : </b> 24/04/2021
 * <br><b>Fecha de modificación : </b> 00/00/0000
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("co.com.i4digital.repositorio")
@EntityScan("co.com.i4digital.modelo")
@ComponentScan(basePackages = "co.com.i4digital") 
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer CORSConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET");
            }
        };
    }	
	
}
