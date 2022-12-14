package com.idat.HospedajeMicroservicio.service;

import java.util.List;

import com.idat.HospedajeMicroservicio.dto.HospedajeDTO;



public interface HospedajeService {
	List<HospedajeDTO> listar();
	HospedajeDTO obtenerId(Integer id);
	void guardar(HospedajeDTO hospedaje);
	void eliminar(Integer id);
	
	void actualizar(HospedajeDTO hospedaje);

}
