package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;

@Service
public interface ClienteService {
	List<Cliente> listar();

	Optional<Cliente> findById(Long id);

	Cliente guardar(Cliente Cliente);

	void eliminar(Long id);

	List<Cliente> listarPorIds(Iterable<Long> ids);
}
