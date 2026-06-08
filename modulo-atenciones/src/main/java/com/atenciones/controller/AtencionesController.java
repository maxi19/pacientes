package com.atenciones.controller;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/atenciones")
@Tag(name = "Atenciones")
public class AtencionesController {

	@RequestMapping("/saludo")
	public BodyBuilder addAtencion() {
		
		
		return ResponseEntity.ok();
	}
	
	
	
}
