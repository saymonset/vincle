package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Caracteristica;

public interface CaracteristicaService {

	List<Caracteristica> listar();

	Optional<Caracteristica> findById(Long id);

	Caracteristica guardar(Caracteristica Caracteristica);

	void eliminar(Long id);

	List<Caracteristica> listarPorIds(Iterable<Long> ids);
}
