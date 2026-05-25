package com.atenciones.mappers;

public interface IMapper <D, E > {
	

	public D toDto();
	
	public E toEntity();
	

	
}
