package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Estado;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.services.EstadoService;

@Service
@Qualifier("estado")
public class EstadoServiceImpl implements EstadoService {

	 @Autowired
	 private EstadoRepository repository;
	 
	 
		@Override
		public List<Estado> listar() {
			// TODO Auto-generated method stub
			return (List<Estado>) repository.findAll();
		}

		@Override
		public Optional<Estado> findById(Long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
		}

		@Override
		public Estado guardar(Estado Estado) {
			// TODO Auto-generated method stub
			return repository.save(Estado);
		}

		@Override
		public void eliminar(Long id) {
			Optional<Estado> opt =repository.findById(id);
			if (opt.isPresent()) {
				repository.delete(opt.get());	
			}
		}

		@Override
		public List<Estado> listarPorIds(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return (List<Estado>) repository.findAll();
		}
	 

}
