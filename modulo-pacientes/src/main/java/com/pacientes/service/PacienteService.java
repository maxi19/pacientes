package com.pacientes.service;

import java.util.List;

import com.pacientes.mappers.PacienteMapper;

public interface PacienteService {

	public  void add( PacienteMapper pacienteMapper  ) throws Exception ; 
	
	public List<PacienteMapper> getByDocumento(String documento) throws Exception;

}
