package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Envase;
import com.example.demo.repositories.EnvaseRepository;
import com.example.demo.services.EnvaseService;

@Service
@Qualifier("envase")
public class EnvaseServiceImpl implements EnvaseService {

	 @Autowired
	 private EnvaseRepository repository;
	 
	 
		@Override
		public List<Envase> listar() {
			// TODO Auto-generated method stub
			return (List<Envase>) repository.findAll();
		}

		@Override
		public Optional<Envase> findById(Long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
		}

		@Override
		public Envase guardar(Envase Envase) {
			// TODO Auto-generated method stub
			return repository.save(Envase);
		}

		@Override
		public void eliminar(Long id) {
			Optional<Envase> opt =repository.findById(id);
			if (opt.isPresent()) {
				repository.delete(opt.get());	
			}
		}

		@Override
		public List<Envase> listarPorIds(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return (List<Envase>) repository.findAll();
		}
	 

}
