package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Envase;

public interface EnvaseService {

	List<Envase> listar();

	Optional<Envase> findById(Long id);

	Envase guardar(Envase Envase);

	void eliminar(Long id);

	List<Envase> listarPorIds(Iterable<Long> ids);
}

