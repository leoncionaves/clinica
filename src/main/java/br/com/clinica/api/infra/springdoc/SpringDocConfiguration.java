package br.com.clinica.api.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Clínica API")
                        .description("API Rest da aplicação Clínica-API.")
                        .contact(new Contact()
                                .name("3Ps Sistemas")
                                .email("leoncionaves@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://3pssistemas.com.br/clinica-api/licenca"))
                );
    }
}
