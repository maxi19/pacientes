package springconfigserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Value("${hotels.msg}") 
    String message ;

	
	@RequestMapping("/mostrar")
	public String mensaje() {
		System.out.println("hola");
		return this.mensaje();
	}
	
}
