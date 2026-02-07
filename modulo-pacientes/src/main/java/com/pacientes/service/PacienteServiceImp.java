package com.pacientes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacientes.domain.Paciente;
import com.pacientes.mappers.PacienteMapper;
import com.pacientes.repository.PacienteRepository;


@Service
public class PacienteServiceImp implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	@Override
	public void add(PacienteMapper pacienteMapper) throws Exception {
		pacienteRepository.save(pacienteMapper.toEntity());
	}


	@Override
	public List<PacienteMapper> getByDocumento(String documento) throws Exception {
		List<Paciente> pacientes = pacienteRepository.findByDocumento(documento).get();
		List<PacienteMapper> mappers = new ArrayList<PacienteMapper>();
		for (Paciente paciente : pacientes) {
			mappers.add(paciente);
		}
		
		return mappers;
	}

	
	
	
	
	
}
