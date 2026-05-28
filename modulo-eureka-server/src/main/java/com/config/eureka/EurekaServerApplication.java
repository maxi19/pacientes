package com.config.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaServer
@Configuration(proxyBeanMethods = false)
public class EurekaServerApplication {

	public static void main(String[] args) {
	    SpringApplication app = new SpringApplication(EurekaServerApplication.class);
	    app.setAdditionalProfiles("dev");
	    app.run(args);
	
	}

}
