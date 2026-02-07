package com.pacientes.mappers;

public interface IMapper <D, E > {
	

	public D toDto();
	
	public E toEntity();
	

	
}
