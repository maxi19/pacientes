package com.pacientes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Run {

		public static void main(String[] args) {
		  //  SpringApplication app = new SpringApplication(Run.class);
		  //  app.setAdditionalProfiles("dev");
		  //  app.run(args);
			SpringApplication.run(Run.class, args);

	}
}
