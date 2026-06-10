package com.atenciones.controller;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/atenciones")
@Tag(name = "Atenciones")
public class AtencionesController {

	@RequestMapping(value = "/saludo" , produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public ResponseEntity<?> addAtencion() {
		
		
		return ResponseEntity.ok().build();
	}
	
	
	
}
