package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Item;
import com.example.demo.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository repository;

  
    @Override
    @Transactional(readOnly = true)
    public List<Item> listar() {
        return (List<Item>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Item> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Item guardar(Item item) {
        return repository.save(item);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
        //  client.eliminarCursoUsuarioPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> listarPorIds(Iterable<Long> ids) {
        return (List<Item>) repository.findAllById(ids);
    }


}
