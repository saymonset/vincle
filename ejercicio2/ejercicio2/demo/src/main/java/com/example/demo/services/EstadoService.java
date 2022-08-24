package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Estado;

public interface EstadoService {

	List<Estado> listar();

	Optional<Estado> findById(Long id);

	Estado guardar(Estado Estado);

	void eliminar(Long id);

	List<Estado> listarPorIds(Iterable<Long> ids);
}
