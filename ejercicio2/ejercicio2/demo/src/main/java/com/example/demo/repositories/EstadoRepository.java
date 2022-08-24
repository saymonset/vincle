package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    
	Optional<Estado> findById(Long id);

    @Query("select u from Estado u where u.nombre=?1")
    Optional<Estado> porNombre(String nombre);
}
