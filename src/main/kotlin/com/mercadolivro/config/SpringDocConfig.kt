package com.mercadolivro.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfig {

    @Bean
    fun springOpenAPI(): OpenAPI {

        return OpenAPI()
            .info(info())
            .externalDocs(externalDoc())
    }

    private fun info(): Info {

        return Info()
            .title("API Mercado de Livro")
            .description("API para agregar dados e status dos livros.")
            .version("0.0.1")
            .license(license())
            .contact(contact())
    }

    private fun externalDoc(): ExternalDocumentation {

        return ExternalDocumentation()
            .description("Terms of Service")
            .url("https://github.com/gilsonsilvati/mercado-livro")
    }

    private fun license(): License {

        return License()
            .name("Apache 2.0")
            .url("http://www.apache.org/licenses/LICENSE-2.0")
    }

    private fun contact(): Contact {

        return Contact()
            .name("Gilson Silva")
            .email("gilsonsilvati@gmail.com")
            .url("https://www.linkedin.com/in/gilsoncostadasilva/")
    }

}
