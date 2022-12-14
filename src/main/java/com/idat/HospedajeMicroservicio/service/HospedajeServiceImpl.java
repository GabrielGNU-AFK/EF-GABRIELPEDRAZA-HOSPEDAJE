package com.idat.HospedajeMicroservicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.HospedajeMicroservicio.dto.HospedajeDTO;
import com.idat.HospedajeMicroservicio.model.Hospedaje;
import com.idat.HospedajeMicroservicio.repository.HospedajeRepository;

@Service
public class HospedajeServiceImpl implements HospedajeService {
	
	@Autowired
	private HospedajeRepository repository;

	@Override
	public List<HospedajeDTO> listar() {
		List<Hospedaje> lista=repository.findAll();
		List<HospedajeDTO> listaDto=new ArrayList<>();
		HospedajeDTO dto=null;
		for(Hospedaje hos: lista) {
			dto=new HospedajeDTO();
			dto.setIdHosp(hos.getIdHospedaje());
			dto.setNomb(hos.getNombre());
			listaDto.add(dto);
		}
		return listaDto;
	}

	@Override
	public HospedajeDTO obtenerId(Integer id) {
		Hospedaje hos=repository.findById(id).orElse(null);
		HospedajeDTO dto= new HospedajeDTO();
		dto.setIdHosp(hos.getIdHospedaje());
		dto.setNomb(hos.getNombre());
		return dto;
	}

	@Override
	public void guardar(HospedajeDTO hospedaje) {
		
		Hospedaje hos= new Hospedaje();
		hos.setIdHospedaje(hospedaje.getIdHosp());
		hos.setNombre(hospedaje.getNomb());
		
		repository.save(hos);
		

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void actualizar(HospedajeDTO hospedaje) {
		Hospedaje hos= new Hospedaje();
		hos.setIdHospedaje(hospedaje.getIdHosp());
		hos.setNombre(hospedaje.getNomb());
		repository.saveAndFlush(hos);
		
	}

}
