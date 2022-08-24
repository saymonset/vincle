package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Capacidad;
import com.example.demo.repositories.CapacidadRepository;
import com.example.demo.services.CapacidadService;

@Service
@Qualifier("capacidad")
public class CapacidadServiceImpl implements CapacidadService {

	 @Autowired
	 private CapacidadRepository repository;
	
	@Override
	public List<Capacidad> listar() {
		// TODO Auto-generated method stub
		return (List<Capacidad>) repository.findAll();
	}

	@Override
	public Optional<Capacidad> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Capacidad guardar(Capacidad capacidad) {
		// TODO Auto-generated method stub
		return repository.save(capacidad);
	}

	@Override
	public void eliminar(Long id) {
		Optional<Capacidad> opt =repository.findById(id);
		if (opt.isPresent()) {
			repository.delete(opt.get());	
		}
	}

	@Override
	public List<Capacidad> listarPorIds(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return (List<Capacidad>) repository.findAll();
	}

}
