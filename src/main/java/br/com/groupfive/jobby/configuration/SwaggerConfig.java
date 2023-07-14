package br.com.groupfive.jobby.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Projeto Jobby")
                        .description("Projeto Recrutamento Candidatos")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("Repositório Projeto Jobby")
                                .url("https://github.com/gabrielmelim/mjv-school-grupo5-projeto-final-api")
                                .email("")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Integrantes")
                        .url("NULL"));
    }
}
