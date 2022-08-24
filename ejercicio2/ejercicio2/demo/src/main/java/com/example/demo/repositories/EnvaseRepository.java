package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Envase;

public interface EnvaseRepository extends CrudRepository<Envase, Long> {
    
	Optional<Envase> findById(Long id);

    @Query("select u from Envase u where u.nombre=?1")
    Optional<Envase> porNombre(String nombre);
}
