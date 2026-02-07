package com.pacientes.controller.dto;

import org.springframework.stereotype.Component;

import com.pacientes.domain.Paciente;
import com.pacientes.mappers.PacienteMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteDto implements PacienteMapper{

	
	private int id;

	private String nombre;
	
	private String apellido;
	
	private String documento;
	
	
	@Override
	public PacienteDto toDto() {
		return this;
	}

	@Override
	public Paciente toEntity() {
		return new Paciente(nombre, apellido,documento);
	}



}
