package com.example.swaggercustom.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

        @Value("${app.server.url}")
        private String serverUrl;

        @Value("${app.server.environment}")
        private String environment;

        private final Environment springEnvironment;

        public OpenApiConfig(Environment springEnvironment) {
                this.springEnvironment = springEnvironment;
        }

        @Bean
        public OpenAPI customOpenAPI() {
                List<Server> servers = new ArrayList<>();

                // Always add the current server
                servers.add(new Server()
                                .url(serverUrl)
                                .description(environment + " Server"));

                // Add local server if not already the current one
                if (!serverUrl.contains("localhost")) {
                        servers.add(new Server()
                                        .url("http://localhost:8080")
                                        .description("Local Development Server"));
                }

                // Get active profiles
                String[] activeProfiles = springEnvironment.getActiveProfiles();
                String activeProfile = activeProfiles.length > 0 ? activeProfiles[0] : "default";

                return new OpenAPI()
                                .info(new Info()
                                                .title("Custom Swagger UI Demo API")
                                                .description("This is a sample Spring Boot application with customized Swagger UI")
                                                .version("1.0.0")
                                                .contact(new Contact()
                                                                .name("Example Team")
                                                                .email("team@example.com")
                                                                .url("https://example.com"))
                                                .license(new License()
                                                                .name("Apache 2.0")
                                                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                                .servers(servers);
        }
}
