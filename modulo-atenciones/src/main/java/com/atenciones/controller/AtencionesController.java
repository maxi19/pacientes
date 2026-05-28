package com.atenciones.controller;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atenciones")
public class AtencionesController {

	@RequestMapping("/saludo")
	public BodyBuilder addAtencion() {
		
		
		return ResponseEntity.ok();
	}
	
	
	
}
