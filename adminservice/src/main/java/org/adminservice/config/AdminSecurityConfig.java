package org.adminservice.config;


import java.time.Instant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class AdminSecurityConfig {

	   private final AdminServerProperties adminServer;

	 

	    public AdminSecurityConfig(AdminServerProperties adminServer) {
	        this.adminServer = adminServer;
	    }

	    @Profile("prod")
	    @Bean
	    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
	        String contextPath = this.adminServer.getContextPath() != null ? this.adminServer.getContextPath() : "";

	        http
	            .csrf(ServerHttpSecurity.CsrfSpec::disable)
	            .authorizeExchange(exchanges -> exchanges
	            	.pathMatchers("/actuator/**", contextPath + "/actuator/**").permitAll()
	                      
	                .pathMatchers(contextPath + "/assets/**").permitAll()
	                .pathMatchers(contextPath + "/login").permitAll()
	                .anyExchange().authenticated()
	            )
	            .formLogin(form -> form.loginPage(contextPath + "/login"))
	            .logout(logout -> logout.logoutUrl(contextPath + "/logout"))
	            .httpBasic(Customizer.withDefaults())
	            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
	        return http.build();
	    }
	
	    
	    @Bean
	    @Profile("prod")
	    public SecurityWebFilterChain securityWebFilterChainProd(ServerHttpSecurity http) {
	        String contextPath = this.adminServer.getContextPath() != null ? this.adminServer.getContextPath() : "";

	        http
	            .csrf(ServerHttpSecurity.CsrfSpec::disable)
	            .authorizeExchange(exchanges -> exchanges
	                .pathMatchers("/actuator/**", contextPath + "/actuator/**").permitAll()
	                .pathMatchers(contextPath + "/assets/**").permitAll()
	                .pathMatchers(contextPath + "/login").permitAll()
	                .anyExchange().authenticated()
	            )
	            // Mantiene el login visual de Spring Boot Admin si accedes directo
	            .formLogin(form -> form.loginPage(contextPath + "/login"))
	            .logout(logout -> logout.logoutUrl(contextPath + "/logout"))
	            .httpBasic(Customizer.withDefaults())
	            // 🔄 NUEVO: Permite que el Gateway le envíe tokens JWT de Keycloak
	            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

	        return http.build();
	    }

	    

	    // 💻 PERFIL DEV: Se activa localmente en tu IDE (Emulación sin Keycloak)
	    @Bean
	    @Profile("dev")
	    public SecurityWebFilterChain securityWebFilterChainDev(ServerHttpSecurity http) {
	        String contextPath = this.adminServer.getContextPath() != null ? this.adminServer.getContextPath() : "";

	        http
	            .csrf(ServerHttpSecurity.CsrfSpec::disable)
	            .authorizeExchange(exchanges -> exchanges
	                .pathMatchers("/actuator/**", contextPath + "/actuator/**").permitAll()
	                .pathMatchers(contextPath + "/assets/**").permitAll()
	                .pathMatchers(contextPath + "/login").permitAll()
	                .anyExchange().authenticated()
	            )
	            .formLogin(form -> form.loginPage(contextPath + "/login"))
	            .logout(logout -> logout.logoutUrl(contextPath + "/logout"))
	            .httpBasic(Customizer.withDefaults())
	            // 🔄 NUEVO: Valida JWT de forma estática localmente sin buscar a Keycloak
	            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtDecoder(mockReactiveJwtDecoder())));

	        return http.build();
	    }

	    // Decodificador Reactivo Falso para el ambiente local (dev)
	    private ReactiveJwtDecoder mockReactiveJwtDecoder() {
	        return token -> Mono.just(
	            Jwt.withTokenValue(token)
	                .header("alg", "none")
	                .claim("sub", "local-admin-user")
	                .claim("scope", "profile email")
	                .issuedAt(Instant.now())
	                .expiresAt(Instant.now().plusSeconds(3600))
	                .build()
	        );
	    }
	    
}
