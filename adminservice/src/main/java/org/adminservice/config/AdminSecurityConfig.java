package org.adminservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
@EnableWebFluxSecurity
public class AdminSecurityConfig {

	   private final AdminServerProperties adminServer;

	 

	    public AdminSecurityConfig(AdminServerProperties adminServer) {
	        this.adminServer = adminServer;
	    }

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
	            .httpBasic(Customizer.withDefaults());

	        return http.build();
	    }
	
}
