package com.javalord.task_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "User & Task Management API",
                version = "1.0.0",
                description = """
            This API provides endpoints for managing users and their tasks.

            Features include:
            - Creating and managing users
            - Creating and tracking tasks
            - Updating task status

            Built with Spring Boot and documented using OpenAPI 3 (Swagger).
            """,
                contact = @Contact(
                        name = "Olojede Olamide Christopher",
                        email = "olojedechristopher24@gmail.com",
                        url = "https://github.com/Christopher-OOC"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),

        servers = {
                @Server(
                        description = "Local Development Server",
                        url = "http://localhost:8080"
                ),
        },

        tags = {
                @Tag(
                        name = "Users",
                        description = "Operations related to user management"
                ),
                @Tag(
                        name = "Tasks",
                        description = "Operations related to task creation and tracking"
                )
        }
)
public class OpenApiConfig {

}
