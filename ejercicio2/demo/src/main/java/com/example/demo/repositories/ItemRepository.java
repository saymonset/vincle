package com.example.demo.repositories;

import com.example.demo.models.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findById(Long id);

}
