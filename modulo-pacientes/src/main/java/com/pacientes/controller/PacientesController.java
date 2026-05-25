package com.pacientes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pacientes.controller.dto.PacienteDto;
import com.pacientes.mappers.PacienteMapper;
import com.pacientes.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

	@Autowired
	private PacienteService personaService;
	

	@RequestMapping(value ="/add", method={RequestMethod.PUT} )
	public BodyBuilder addPaciente(@RequestBody PacienteDto pacienteDto) throws Exception {
		personaService.add(pacienteDto);
		return ResponseEntity.ok();
	}
	
	@RequestMapping(value ="/get/{documento}", method={RequestMethod.GET} )
	public ResponseEntity<List<PacienteDto>> getPaciente(@PathVariable String documento) throws Exception {
		
		List<PacienteMapper> mappers = personaService.getByDocumento(documento);
		List<PacienteDto> dtos  = new ArrayList<PacienteDto>();
		for (PacienteMapper pacienteMapper : mappers) {
			dtos.add(pacienteMapper.toDto());
		}

		return ResponseEntity.ok(dtos);
	}
	
}
