package com.example.afraid.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Value("\${server.port:8080}")
    private lateinit var serverPort: String

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Afraid Health Management API")
                    .description("건강 관리 시스템 API - 각 장기별 건강 정보를 관리합니다")
                    .version("v1.0.0")
                    .contact(
                        Contact()
                            .name("Afraid Development Team")
                            .email("dev@afraid.com")
                            .url("https://afraid.com")
                    )
                    .license(
                        License()
                            .name("MIT License")
                            .url("https://opensource.org/licenses/MIT")
                    )
            )
            .servers(
                listOf(
                    Server()
                        .url("http://localhost:$serverPort")
                        .description("Local development server"),
                    Server()
                        .url("https://api.afraid.com")
                        .description("Production server")
                )
            )
    }
}