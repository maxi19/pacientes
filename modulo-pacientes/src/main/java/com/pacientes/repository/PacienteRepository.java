package com.pacientes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacientes.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	Optional<List<Paciente>> findByDocumento(String documento) ;
	
}
