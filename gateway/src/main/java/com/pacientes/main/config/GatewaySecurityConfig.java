package com.pacientes.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {

	
	  @Bean
	    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
	        http
	            .csrf(ServerHttpSecurity.CsrfSpec::disable)
	            .authorizeExchange(exchanges -> exchanges
	                // 1. Permite la interfaz gráfica de Swagger en el Gateway
	                .pathMatchers("/swagger-ui/**", "/swagger-ui.html", "/webjars/**").permitAll()
	                // 2. Permite las rutas que configuraste en tu 'urls:' de springdoc (¡Muy importante!)
	                .pathMatchers("/api/pacientes/v3/api-docs", "/api/atenciones/v3/api-docs").permitAll()
	                // 3. Permite que Spring Boot Admin acceda a las métricas del Actuator
	                .pathMatchers("/actuator/**").permitAll()
	                // 4. Cualquier otra petición a tus APIs de negocio requerirá autenticación
	                .anyExchange().authenticated()
	            )
	            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

	        return http.build();
	    }
	
	
}
