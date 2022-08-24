package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Tipo;

public interface TipoService {

	List<Tipo> listar();

	Optional<Tipo> findById(Long id);

	Tipo guardar(Tipo Tipo);

	void eliminar(Long id);

	List<Tipo> listarPorIds(Iterable<Long> ids);
}
