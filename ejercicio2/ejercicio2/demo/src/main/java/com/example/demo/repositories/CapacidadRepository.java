package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Capacidad;

public interface CapacidadRepository extends CrudRepository<Capacidad, Long> {
    
	Optional<Capacidad> findById(Long id);

    @Query("select u from Capacidad u where u.nombre=?1")
    Optional<Capacidad> porNombre(String nombre);
}
