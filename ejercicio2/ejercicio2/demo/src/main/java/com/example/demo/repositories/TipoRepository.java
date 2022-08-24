package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, Long> {
    
	Optional<Tipo> findById(Long id);

    @Query("select u from Tipo u where u.nombre=?1")
    Optional<Tipo> porNombre(String nombre);
}

