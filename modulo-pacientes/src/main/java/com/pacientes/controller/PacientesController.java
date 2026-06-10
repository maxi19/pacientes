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
import com.pacientes.domain.Paciente;
import com.pacientes.mappers.PacienteMapper;
import com.pacientes.service.PacienteService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pacientes")
@Tag(name = "Pacientes")
public class PacientesController {

	@Autowired
	private PacienteService personaService;
	

	@RequestMapping(value ="/add", method={RequestMethod.PUT} )
	public ResponseEntity<?> addPaciente(@RequestBody PacienteDto pacienteDto) throws Exception {
		personaService.add(pacienteDto);
		return ResponseEntity.ok().build();
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
	
	
	@RequestMapping(value ="/hello", method={RequestMethod.GET} )
	public ResponseEntity<Paciente> hello() throws Exception {
		Paciente paciente = new Paciente();
		paciente.setApellido("guzman");
		paciente.setDocumento("31983056");
		paciente.setNombre("maxi");
		paciente.setId(1);
		
		return ResponseEntity.ok(paciente);
	}
	
}
