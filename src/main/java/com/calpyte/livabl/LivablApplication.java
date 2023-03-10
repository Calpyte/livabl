package com.calpyte.livabl;

import com.keycloak.connector.config.EnableKeycloak;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "livabl API", version = "2.0", description = "Livabl Information"))
@EnableKeycloak
public class LivablApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivablApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${openapi.service.title}") String serviceTitle, @Value("${openapi.service.version}") String serviceVersion) {
		final String securitySchemeName = "bearerAuth";
		List list = new ArrayList();
		list.add(new SecurityRequirement().addList(securitySchemeName));

		return new OpenAPI().components(new Components().addSecuritySchemes(securitySchemeName, new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))).security(list).info(new io.swagger.v3.oas.models.info.Info().title(serviceTitle).version(serviceVersion));
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}
