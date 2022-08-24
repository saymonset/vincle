package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
	Optional<Cliente> findById(Long id);

    @Query("select u from Cliente u where u.nombre=?1")
    Optional<Cliente> porNombre(String nombre);
}
