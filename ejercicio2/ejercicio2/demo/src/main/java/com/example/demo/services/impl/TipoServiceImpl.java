package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Tipo;
import com.example.demo.repositories.TipoRepository;
import com.example.demo.services.TipoService;
@Service
@Qualifier("tipo")
public class TipoServiceImpl implements TipoService {

	 @Autowired
	 private TipoRepository repository;
	
	 @Override
		public List<Tipo> listar() {
			// TODO Auto-generated method stub
			return (List<Tipo>) repository.findAll();
		}

		@Override
		public Optional<Tipo> findById(Long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
		}

		@Override
		public Tipo guardar(Tipo Tipo) {
			// TODO Auto-generated method stub
			return repository.save(Tipo);
		}

		@Override
		public void eliminar(Long id) {
			Optional<Tipo> opt =repository.findById(id);
			if (opt.isPresent()) {
				repository.delete(opt.get());	
			}
		}

		@Override
		public List<Tipo> listarPorIds(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return (List<Tipo>) repository.findAll();
		}
	 

}
