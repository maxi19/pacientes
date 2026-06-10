package com.atenciones;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Main {

		public static void main(String[] args) {
		   // SpringApplication app = new SpringApplication(Main.class);
		   // app.setAdditionalProfiles("dev");
		   // app.run(args);
			SpringApplication.run(Main.class, args);

	}
}
