package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Caracteristica;
 

public interface CaracteristicaRepository extends CrudRepository<Caracteristica, Long> {
    
	Optional<Caracteristica> findById(Long id);

    @Query("select u from Caracteristica u where u.nombre=?1")
    Optional<Caracteristica> porNombre(String nombre);
}
