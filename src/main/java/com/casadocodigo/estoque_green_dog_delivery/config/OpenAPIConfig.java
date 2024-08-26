package com.casadocodigo.estoque_green_dog_delivery.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	 @Bean
	    public GroupedOpenApi usersGroup(@Value("${springdoc.version}") String appVersion) {
	        return GroupedOpenApi
	                .builder()
	                .group("estoque")
	                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Controle de Estoque API").version(appVersion)))
	                .packagesToScan("com.casadocodigo")
	                .build();
	    }

}
