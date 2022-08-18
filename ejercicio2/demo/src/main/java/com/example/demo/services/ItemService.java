package com.example.demo.services;

import com.example.demo.models.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> listar();
    Optional<Item> porId(Long id);
    Item guardar(Item item);
    void eliminar(Long id);
    List<Item> listarPorIds(Iterable<Long> ids);


}
