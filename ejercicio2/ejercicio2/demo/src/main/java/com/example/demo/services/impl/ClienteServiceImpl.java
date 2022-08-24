package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.ClienteService;

@Service
@Qualifier("cliente")
public class ClienteServiceImpl implements ClienteService {
 
	 @Autowired
	 private ClienteRepository repository;
	 
	 
		@Override
		public List<Cliente> listar() {
			// TODO Auto-generated method stub
			return (List<Cliente>) repository.findAll();
		}

		@Override
		public Optional<Cliente> findById(Long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
		}

		@Override
		public Cliente guardar(Cliente Cliente) {
			// TODO Auto-generated method stub
			return repository.save(Cliente);
		}

		@Override
		public void eliminar(Long id) {
			Optional<Cliente> opt =repository.findById(id);
			if (opt.isPresent()) {
				repository.delete(opt.get());	
			}
		}

		@Override
		public List<Cliente> listarPorIds(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return (List<Cliente>) repository.findAll();
		}

}
