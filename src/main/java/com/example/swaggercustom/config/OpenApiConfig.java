package com.example.swaggercustom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

        @Value("${app.server.url}")
        private String serverUrl;

        @Value("${app.server.environment}")
        private String environment;

        @Bean
        public OpenAPI customOpenAPI() {

                return new OpenAPI()
                                .info(new Info()
                                                .title("Custom Swagger UI Demo API - " + environment)
                                                .description("This is a sample Spring Boot application with customized Swagger UI - "
                                                                + environment)
                                                .version("1.0.0")
                                                .contact(new Contact()
                                                                .name("Example Team")
                                                                .email("team@example.com")
                                                                .url("https://example.com"))
                                                .license(new License()
                                                                .name("Apache 2.0")
                                                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
        }
}
