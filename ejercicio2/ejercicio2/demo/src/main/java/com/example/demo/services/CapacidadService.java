package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Capacidad;
@Service
public interface CapacidadService {

	List<Capacidad> listar();

	Optional<Capacidad> findById(Long id);

	Capacidad guardar(Capacidad capacidad);

	void eliminar(Long id);

	List<Capacidad> listarPorIds(Iterable<Long> ids);

}
