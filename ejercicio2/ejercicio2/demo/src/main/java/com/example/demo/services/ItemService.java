package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.ItemException;
import com.example.demo.models.Item;
import com.example.demo.request.UpdateEstadoItem;

public interface ItemService {
    List<Item> listar();
    Optional<Item> porId(Long id);
    Item guardar(Item item) throws ItemException;
    void eliminar(Long id);
    List<Item> listarPorIds(Iterable<Long> ids);
    Item updateEstadoItems(UpdateEstadoItem updateEstadoItem);


}
