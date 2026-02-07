package com.pacientes.domain;

import com.pacientes.controller.dto.PacienteDto;
import com.pacientes.mappers.PacienteMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Paciente implements PacienteMapper{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull private String nombre;
	@NonNull private String apellido;
	@NonNull private String documento;

	
	@Override
	public PacienteDto toDto() {
		return new PacienteDto(id, nombre, apellido, documento);
	}
	
	@Override
	public Paciente toEntity() {
		return this;
	}
	
}
